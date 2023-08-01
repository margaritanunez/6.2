package com.example.a62.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1) //Para declarar que esta clase es una BD de room, especifica la lista de entidades usadas y número de versión
abstract class ItemDataBase : RoomDatabase() {
    // Room: biblioteca de persostencia de Android, que simplifica el manejo de bases de datos

    abstract fun getItemsDao(): ItemDao
    // fx abstracta que declara un método para obtener el DAO, relacionado con la entidad.

    companion object { //define miembros estáticos de la clase ItemDataBase
        @Volatile
        private var INSTANCE: ItemDataBase? = null

        fun getDatabase(context: Context): ItemDataBase { // Busca una instancia de la base de datos, si existe, la devuelve, en caso contrario la genera una única vez.
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder( // construye la base de datos
                    context.applicationContext,
                    ItemDataBase::class.java,
                    "item_database" // es el nombre de la BD, no tienes que buscarlo Margarita, sólo créalo.
                ).build() // finaliza la construcción de la BD

                INSTANCE = instance
                return instance
                //devuelve una instancia que estará lista para su uso
            }
        }
    }
}

