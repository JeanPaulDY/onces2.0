package com.example.onces20.view.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.onces20.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class AcercaDeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_acerca_de, container, false)
        val btcomentarios=view.findViewById<Button>(R.id.contactobutton2)
        btcomentarios.setOnClickListener {
            findNavController().navigate(R.id.action_acerca_DeFragment_to_comentariosFragment)
        }
        val btcontactenos=view.findViewById<Button>(R.id.contactobutton)
        btcontactenos.setOnClickListener {
            findNavController().navigate(R.id.action_acerca_DeFragment_to_contactenosFragment)
        }
        return view
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