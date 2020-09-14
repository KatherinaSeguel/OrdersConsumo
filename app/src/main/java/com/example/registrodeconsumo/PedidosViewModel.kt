package com.example.registrodeconsumo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.registrodeconsumo.database.Pedidos
import com.example.registrodeconsumo.database.PedidosDatabase
import kotlinx.coroutines.launch


//application constructor de la clase que viene de la clase AndroidViewModel y lo alimenta
//el application es el contexto que necesita la Base de Datos.Así no dependemos de una vista ,sino es el ViewModel independiente.
class PedidosViewModel(application: Application) : AndroidViewModel(application){
    private  val mrepository : PedidosRepository
    val allPedidos: LiveData<List<Pedidos>>

    //las inucializo
    init {
        val pedidosDao = PedidosDatabase.getDatabase(application).getPedidosDao()
        mrepository= PedidosRepository(pedidosDao)
        allPedidos=mrepository.listAllPedidos
    }


 fun insertPedidos(mpedidos: Pedidos) = viewModelScope.launch {
     mrepository.insertPedidos(mpedidos) }

    fun deleteAllPedidos() = viewModelScope.launch {
        mrepository.deleteALL()
    }

//Este elemento será observado por la vista cuando le pase el Id
    fun getOnePedidosByID(id:Int): LiveData<Pedidos>{
        return mrepository.getOnePedidosByID(id)
    }
}