package com.christopher.mielitz

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query


//This is just the stock dao
@Dao
public class MyStockDao {
    @Dao
    interface stockDao {
        //This shows all stock
        @Query("SELECT * from stock_info")
        fun showalltheStock(): List<StockInfo>
        //Only shows one stock
        @Query("SELECT * from stock_info ORDER BY StockSymbol LIMIT 1")
        fun showone(): StockInfo
        //Inserts a stock
        @Insert
        fun InsertaStockhere(vararg s: StockInfo)
    }
}