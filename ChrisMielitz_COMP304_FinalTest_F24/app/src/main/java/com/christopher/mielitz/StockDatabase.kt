package com.christopher.mielitz

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.internal.synchronized

//Database of stock
@Database(entities = [StockInfo::class], version = 1)
abstract class StockDatabase : RoomDatabase() {
    abstract fun stockDao(): MyStockDao.stockDao

    companion object {
        private var instance: StockDatabase? = null

        @OptIn(InternalCoroutinesApi::class)
        //This creates DB instance
        fun getInstance(con: Context): StockDatabase {
            synchronized(this)
            {
                val instance = Room.databaseBuilder(con, StockDatabase::class.java, "hello").allowMainThreadQueries().build()
                return instance
            }
        }
    }
}
