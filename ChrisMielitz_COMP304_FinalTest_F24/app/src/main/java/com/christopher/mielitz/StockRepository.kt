package com.christopher.mielitz

import androidx.lifecycle.ViewModel

//Stock repository
open class StockRepository(db: MyStockDao.stockDao) {
    interface StockRepository {
        suspend fun showalltheStock(): List<StockInfo>
        suspend fun InsertaStockhere(s: StockInfo)
    }
}
