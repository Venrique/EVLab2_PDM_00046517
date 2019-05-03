package com.sovize.evlab2_pdm_00046517

import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sovize.evlab2_pdm_00046517.fragments.BtnFragment
import com.sovize.evlab2_pdm_00046517.fragments.ImageFragment
import com.sovize.evlab2_pdm_00046517.interfaces.comunicacion
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), comunicacion , BtnFragment.OnFragmentInteractionListener, ImageFragment.OnFragmentInteractionListener{
    override fun onFragmentInteraction(uri: Uri) {

    }

    var contador = 0

    override fun enviarnumero(img: Int) {

        if(contador>3){
            contador=0
        }else if (contador<0){
            contador=3
        }

        if (img == -1 && contador == 0){
            contador = 3
        }

        if(img == -1){
            contador--
        }else{
            contador++
        }

        var imagenFrag = newInstance()

        var bundleEnvio = Bundle()
        bundleEnvio.putSerializable("numero",contador)

        imagenFrag.arguments = bundleEnvio

        supportFragmentManager.beginTransaction().replace(R.id.contenedorImg,imagenFrag).commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imgfrag = newInstance()

        supportFragmentManager.beginTransaction().replace(R.id.contenedorImg,imgfrag).commit()
    }

    fun newInstance():ImageFragment{
        return ImageFragment()
    }
}
