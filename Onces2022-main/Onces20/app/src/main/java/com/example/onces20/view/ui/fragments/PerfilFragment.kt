package com.example.onces20.view.ui.fragments

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import com.example.onces20.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class PerfilFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_perfil, container, false)

        val btcamara=view.findViewById<Button>(R.id.Btcamara)
        btcamara.setOnClickListener {
            val intent= Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 123)
        }

        val btgaleria=view.findViewById<Button>(R.id.Btgaleria)
        btgaleria.setOnClickListener {
            val intent= Intent(Intent.ACTION_PICK)
            intent.type="image/*"
            startActivityForResult(intent, 456)
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView=view?.findViewById<ImageView>(R.id.fotoperfil)
        if(requestCode==123){
            var bitmap=data?.extras?.get("data") as Bitmap
            imageView?.setImageBitmap(bitmap)
        }else if(requestCode==456){
            imageView?.setImageURI(data?.data)
        }
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btm=view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
        btm.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.homebar -> findNavController().navigate(R.id.action_productosFragment_to_homeFragment)
                R.id.perfilbar -> findNavController().navigate(R.id.action_productosFragment_to_perfilFragment)
                R.id.mapabar -> findNavController().navigate(R.id.action_productosFragment_to_ruta_PedidosFragment)
            }
        }
    }
}