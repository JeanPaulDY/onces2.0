package com.example.onces20.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onces20.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ConfiguracionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_configuracion, container, false)
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