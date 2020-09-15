package com.example.registrodeconsumo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.registrodeconsumo.database.Pedidos
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {


    lateinit var mViewModel: PedidosViewModel
    private  var idpedidos:Int?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel= ViewModelProvider(this).get(PedidosViewModel::class.java) //variable representa VM
        arguments?.let {

            idpedidos=it.getInt("id")
        }

    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        idpedidos?.let {
            mViewModel.getOnePedidosByID(it).observe(viewLifecycleOwner, Observer {

            })
        }



        saveBtn.setOnClickListener {


            val textseg =iditemTv.text.toString()
            val precioseg=precioTv.text.toString().toInt()
            val cantseg=cantTv.text.toString().toInt()
            if (!textseg.isEmpty()){
            val mPedidos = Pedidos(item = textseg, precio = precioseg, cantidad = cantseg)
                mViewModel.insertPedidos(mPedidos)
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }

    }
}