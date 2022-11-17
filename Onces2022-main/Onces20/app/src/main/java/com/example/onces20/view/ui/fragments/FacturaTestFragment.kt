package com.example.onces20.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil.setContentView
import com.example.onces20.R
import com.example.onces20.databinding.FragmentFacturaTestBinding


class FacturaTestFragment : Fragment() {
    lateinit var binding: FragmentFacturaTestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_factura_test)

        var unidadVal=view.findViewById<TextView>(R.id.textUnidadFT)
        var cantidadProd=view.findViewById<TextView>(R.id.textCantidadFT)
        var subtotalVal=view.findViewById<TextView>(R.id.textSubtotalFT)
        var ivaVal=view.findViewById<TextView>(R.id.textIvaFT)
        var totalVal=view.findViewById<TextView>(R.id.textTotalFT)
        val iva= 19
        var botonCalcularVal=view.findViewById<Button>(R.id.buttonCalcularFT)

        botonCalcularVal.setOnClickListener {
            var subtotalCantidad=(unidadVal.text.toString().toInt())*(cantidadProd.text.toString().toInt())
            var ivaCalculo=(subtotalCantidad*iva)/100
            var totalCalculo=subtotalCantidad+ivaCalculo

            subtotalVal.setText(
                subtotalCantidad.toString()
            )
            ivaVal.setText(
                ivaCalculo.toString()
            )
            totalVal.setText(
                totalCalculo.toString()
            )
        }
    }
}