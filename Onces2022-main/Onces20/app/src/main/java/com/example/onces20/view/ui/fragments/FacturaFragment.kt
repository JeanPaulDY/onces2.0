package com.example.onces20.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.onces20.R
import com.example.onces20.databinding.FragmentFacturaBinding
import com.example.onces20.databinding.FragmentHacerPedidoBinding
import com.google.android.material.bottomnavigation.BottomNavigationView


class FacturaFragment : Fragment() {
    lateinit var binding: FragmentFacturaBinding
    lateinit var binding: FragmentHacerPedidoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) {
        var subtotal=view.findViewById<TextView>(R.id.textView10)
        var iva=view.findViewById<TextView>(R.id.textView11)
        var cantidad=view.findViewById<TextView>(R.id.textView7)
        var botonPagar=view.findViewById<Button>(R.id.button)
        var printTotalValor=()

        botonPagar.setOnClickListener {
            var subtotalCantidad=(subtotal.text.toString().toInt())*(cantidad.text.toString().toInt())
            var ivaCalculo=(subtotalCantidad*iva.text.toString().toInt()))/100
            var totalCalculo=subtotalCantidad+ivaCalculo

            printTotalValor.setText(
                totalCalculo.toString()
            )
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
