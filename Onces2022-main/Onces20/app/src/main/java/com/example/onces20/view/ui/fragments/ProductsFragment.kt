package com.example.onces20.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onces20.R
import com.example.onces20.view.adapter.ProductosAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView

class ProductsFragment : Fragment() {
    lateinit var recyclerLib:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_productos, container, false)
        recyclerLib=view.findViewById(R.id.recyclerview1)
        val adapter=ProductosAdapter()
        recyclerLib.layoutManager=LinearLayoutManager(context)
        recyclerLib.adapter=adapter
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