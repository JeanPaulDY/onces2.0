package com.example.onces20.view.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import com.example.onces20.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MakeAnOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_an_order)

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