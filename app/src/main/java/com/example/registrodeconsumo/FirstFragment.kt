package com.example.registrodeconsumo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.registrodeconsumo.database.Pedidos
import kotlinx.android.synthetic.main.fragment_first.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(),PedidosAdapter.PasstheData {

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
       // viewModel.insertPedidos(pedidos1)
        //viewModel.insertPedidos(pedidos2)
        //scuchar el liveData del ViewModel

        //instancia el elemento visual RV
        val mRecyclerView= recyclerView
        //instanciamos un objeto de la clase aDapter
        val mAdapter= PedidosAdapter(this)
        mRecyclerView.adapter= mAdapter
        mRecyclerView.layoutManager= LinearLayoutManager(context)


//observando el LiveData del view Model
        viewModel.allPedidos.observe(viewLifecycleOwner, Observer {
            Log.d("datos",it.toString())
//Se hace un update al adapter
            mAdapter.updateDataList(it)
        })

//doy vida al botoncito

        fab.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        }

    override fun passTheData(mpedidos: Pedidos) {
        //llega el registro a editar
        Toast.makeText(context,mpedidos.item,Toast.LENGTH_LONG).show()
        }
}
