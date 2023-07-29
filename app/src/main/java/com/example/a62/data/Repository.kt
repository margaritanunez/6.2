package com.example.a62.data

import androidx.lifecycle.LiveData
import com.example.a62.data.local.Item
import com.example.a62.data.local.ItemDao

class Repository(private val itemDao: ItemDao) {
    suspend fun insertItem(item: Item){
        itemDao.insertItem(item)
    }

    fun getItem():
            LiveData<List<Item>> {
        return itemDao.getAllItems()
    }
}
