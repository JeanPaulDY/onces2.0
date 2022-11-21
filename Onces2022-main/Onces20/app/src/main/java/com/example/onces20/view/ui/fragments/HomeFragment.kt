package com.example.onces20.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.onces20.R


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardPerf=view.findViewById<ImageView>(R.id.cardPerfil)
        cardPerf.setOnClickListener{
            findNavController().navigate(R.id.action_homeFragment_to_perfilFragment)
        }
        val cardProd=view.findViewById<ImageView>(R.id.cardProductos)
        cardProd.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_productosFragment)
        }
        val cardComp=view.findViewById<ImageView>(R.id.cardCompras)
        cardComp.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_comprasFragment)
        }
        val cardRuta=view.findViewById<ImageView>(R.id.cardRutaPedido)
        cardRuta.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_ruta_PedidosFragment)
        }
        val cardConf=view.findViewById<ImageView>(R.id.cardConfiguracion)
        cardConf.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_configuracionFragment)
        }
        val cardAcer=view.findViewById<ImageView>(R.id.cardAcercaDe)
        cardAcer.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_acerca_DeFragment)
        }
    }

}