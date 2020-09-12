package com.example.registrodeconsumo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_second.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {


    lateinit var mViewModel: PedidosViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mViewModel= ViewModelProvider(this).get(PedidosViewModel::class.java) //variable representa VM
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




        saveBtn.setOnClickListener {


            val textseg =iditemTv.text.toString()
            val precioseg=precioTv.text.toString()
            val cantseg=cantTv.text.toString()
            if (!textseg.isEmpty()){


            }

            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }

    }
}