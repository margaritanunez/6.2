package com.example.a62.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ItemDao {
    @Insert
    suspend fun insertItem(item: Item) // inserta un objeto: item, en la base de datos, se ejecuta de manera asíncrona a través de la corrutina

    @Query ("SELECT * FROM table_item order by id ASC") //consulta a través de la Query a la BD. Selecciona todos los elementos de la table_item, ordenándolos por el id de manera ascendente.
    fun getAllItems(): LiveData<List<Item>>
    // Live Data proporciona datos actualizados a medida que cambian en la BD.

    @Delete
    fun deleteItems(items: List<Item>) // para eliminar una lista de objetos de una base de datos
}