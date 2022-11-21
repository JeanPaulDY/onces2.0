package com.example.onces20.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.onces20.R
import com.example.onces20.model.productos
import com.example.onces20.view.adapter.OnBookItemClickListener
import com.example.onces20.view.adapter.ProductosAdapter
import com.example.onces20.viewmodel.LibraryViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProductsFragment : Fragment(),OnBookItemClickListener {
    lateinit var recyclerLib:RecyclerView
    lateinit var firebaseAuth: FirebaseAuth
    lateinit var adapter: ProductosAdapter
    val database:FirebaseFirestore=FirebaseFirestore.getInstance()
    private val viewmodel by lazy { ViewModelProvider(this).get(LibraryViewModel::class.java) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_productos, container, false)
        recyclerLib=view.findViewById(R.id.recyclerview1)
        adapter=ProductosAdapter(requireContext(),this)
        recyclerLib.layoutManager=LinearLayoutManager(context)
        recyclerLib.adapter=adapter
        observeData()
        return view
    }
    fun observeData(){
        viewmodel.libraryData().observe(viewLifecycleOwner, Observer {
            adapter.setListData(it)
            adapter.notifyDataSetChanged()
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btm=view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
        btm.setOnNavigationItemReselectedListener {
            when(it.itemId){
                R.id.homebar -> findNavController().navigate(R.id.action_productosFragment_to_homeFragment)
                R.id.perfilbar -> findNavController().navigate(R.id.action_productosFragment_to_perfilFragment)
                R.id.mapabar -> findNavController().navigate(R.id.action_productosFragment_to_ruta_PedidosFragment)
                R.id.cerrarsesion->{
                    firebaseAuth.signOut()
                    findNavController().navigate(R.id.action_productosFragment_to_loginActivity)
                    true
                }
            }
        }
    }

    override fun onItemClick(producto: productos, position: Int) {
        val titulo:String=producto.producto
        val precio:String=producto.precio
        val image:String=producto.image
        val dato= hashMapOf(
            "titulo" to titulo,
            "precio" to precio,
            "image" to image
        )
        database.collection("compras")
            .document(titulo)
            .set(dato)
            .addOnSuccessListener {
                Toast.makeText(context, "Producto fue agregado al carrito", Toast.LENGTH_SHORT).show()
            }
    }
}