package com.example.onces20.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onces20.R
import com.example.onces20.model.compras
import com.example.onces20.view.adapter.ComprasAdapter
import com.example.onces20.view.adapter.OnCompraItemClickListener
import com.example.onces20.viewmodel.ComprasViewModel
import com.google.firebase.firestore.FirebaseFirestore

class ComprasFragment : Fragment(), OnCompraItemClickListener {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: ComprasAdapter
    lateinit var precioT: TextView
    lateinit var precioS: TextView
    lateinit var precioiva: TextView
    val database: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val viewModel by lazy { ViewModelProvider(this).get(ComprasViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_compras, container, false)
        val btfactura=view.findViewById<Button>(R.id.BTcompletarcompra)
        btfactura.setOnClickListener {
            findNavController().navigate(R.id.action_comprasFragment_to_facturaFragment2)
        }
        recyclerView=view.findViewById(R.id.recyclerviewcompra)
        precioT= view.findViewById(R.id.preciototal)
        precioS= view.findViewById(R.id.subtotal)
        precioiva= view.findViewById(R.id.iva)
        adapter= ComprasAdapter(requireContext(), this)
        recyclerView.layoutManager=LinearLayoutManager(context)
        recyclerView.adapter=adapter
        observeData()
        preciosubtotal()
        return view
    }

    private fun observeData() {
        viewModel.fectchComprasData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun preciosubtotal() {
        database.collection("compras")
            .get()
            .addOnSuccessListener { result ->
                val preciounitario = mutableListOf<String>()
                for (document in result) {
                    val precio = document["precio"].toString()
                    preciounitario.add(precio!!)
                }
                val preciototal = preciounitario.mapNotNull { it.toIntOrNull() }.sum()
                precioS.setText(Integer.toString(preciototal))

            }
    }

    override fun onItemClick(producto: compras, position: Int) {
        TODO("Not yet implemented")
    }
}