package com.example.onces20.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.onces20.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class ConfiguracionFragment : Fragment() {
    lateinit var firebaseAuth: FirebaseAuth
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
                R.id.homebar -> findNavController().navigate(R.id.action_configuracionFragment_to_homeFragment)
                R.id.perfilbar -> findNavController().navigate(R.id.action_configuracionFragment_to_perfilFragment)
                R.id.mapabar -> findNavController().navigate(R.id.action_configuracionFragment_to_ruta_PedidosFragment)
                R.id.carritobar -> findNavController().navigate(R.id.action_configuracionFragment_to_comprasFragment)
                R.id.cerrarsesion->{
                    firebaseAuth.signOut()
                    findNavController().navigate(R.id.action_configuracionFragment_to_loginActivity)
                    true
                }
            }
        }
    }
}