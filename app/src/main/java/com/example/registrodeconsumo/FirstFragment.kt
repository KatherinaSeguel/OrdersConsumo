package com.example.registrodeconsumo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.registrodeconsumo.database.Pedidos

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    lateinit var viewModel: PedidosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel=ViewModelProvider(this).get(PedidosViewModel::class.java)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //  val pedidos= Pedidos(0,"Bebidas",1200,1)
       // val pedidos1= Pedidos(4,"Pisco",2000,2)
        //val pedidos2= Pedidos(5,"Papas Fritas",1500,4)
        // viewModel.insertPedidos(pedidos)
        //viewModel.insertPedidos(pedidos1)
        //viewModel.insertPedidos(pedidos2)
        //scuchar el liveData del ViewModel

        viewModel.allPedidos.observe(viewLifecycleOwner, Observer {
            Log.d("datos",it.toString())
        })




        view.findViewById<Button>(R.id.button_second).setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
}