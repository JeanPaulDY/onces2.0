package com.example.onces20.view.ui.fragments

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.onces20.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth

class FavoritosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_favoritos, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lateinit var firebaseAuth: FirebaseAuth
        super.onViewCreated(view, savedInstanceState)
        val btm = view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.homebar -> findNavController().navigate(R.id.action_perfilFragment_to_homeFragment)
                R.id.mapabar -> findNavController().navigate(R.id.action_productosFragment_to_ruta_PedidosFragment)
                R.id.cerrarsesion -> {
                    firebaseAuth.signOut()
                    findNavController().navigate(R.id.action_productosFragment_to_loginActivity)
                    true
                }
            }
        }
    }

}