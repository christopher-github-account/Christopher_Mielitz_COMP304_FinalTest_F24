package com.christopher.mielitz

import androidx.lifecycle.ViewModel
import androidx.room.Insert
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

//Stock view model
class StockViewModel: ViewModel() {

    private val myState = MutableStateFlow(StockInfo("a", "a", 1.1))
    val thisstate: StateFlow<StockInfo> = myState.asStateFlow()
    fun InsertaStockhere(thisstockInfo: StockInfo) {
        InsertaStockhere(thisstockInfo)
    }
    //This gets the stock symbol
    fun GetStockSymbol(stockInfo: StockInfo): String
    {
        return stockInfo.stockSymbol
    }
}