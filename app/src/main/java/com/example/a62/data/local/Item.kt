package com.example.a62.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity (tableName =  "table_item") //Representa una entidad de room , creando una nueva BD . table_item es el nombre de la tabla en este caso.
data class Item(val nombre: String, val precio: Int, val cantidad: Int){//atributos de la clase
    @PrimaryKey (autoGenerate = true) var id : Long = 0
    // cada fila de la tabla se identifica con un valor único e irrepetible a través de la PK, el valor de id se genera automáticamente en ROOM.
    // LONG, tipo de dato, abarca más espacio que el String, y empieza siempre en cero

}


