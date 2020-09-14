package com.example.registrodeconsumo

import androidx.lifecycle.LiveData
import com.example.registrodeconsumo.database.Pedidos
import com.example.registrodeconsumo.database.PedidosDao

class PedidosRepository (private val mPedidosDao:PedidosDao){
    //necesita la interface DAO

//estoy creando la variable,contendrá todos datos DB
    val listAllPedidos: LiveData<List<Pedidos>> = mPedidosDao.getAllPedidosFromDb()

    suspend fun insertPedidos(mpedidos: Pedidos){
        mPedidosDao.insertOnePedido(mpedidos)  //llama a la  función del Dao, Inserta información
    }

    //va al DAO y trae el objeto encontrado por ID envuelto en LiveData

    fun getOnePedidosByID(id : Int): LiveData<Pedidos> {
       return mPedidosDao.getOnePedidosByID(id)
    }

    //Esta función Delete la tabla entera
    suspend fun deleteALL(){
        mPedidosDao.deleteALLPedidos()
    }

}
