package com.example.registrodeconsumo.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.registrodeconsumo.database.Pedidos

@Dao
interface PedidosDao {
//Insertar un objeto en la tabla utilizando suspend de corroutinas

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend  fun insertOnePedido(mpedidos: Pedidos)  //función al objeto mpedi  le asigno la clase Pedidos
    @Update
    suspend  fun updateOnePedidos(mpedidos: Pedidos)  //función que Modifica

   // @Delete
    //fun deleteOnePedidos(mpedidos: Pedidos) // función delete
    //suspend fun deleteALLPedido()

    @Query ("SELECT * FROM table_pedidos")
    fun getAllPedidosFromDb(): LiveData<List<Pedidos>> //se envuelve el LIST en LiveData

   @Query("SELECT * FROM table_pedidos WHERE id=:mid")//los : es para que sepa que es la variable
    fun getOnePedidosByID(mid:Int): LiveData<Pedidos>     //yo le paso un id y la query me trae el un objeto que encuentre

    //Elimina Toda la Tabla
    @Query ("DELETE FROM table_pedidos")
    suspend fun deleteALLPedidos()



}