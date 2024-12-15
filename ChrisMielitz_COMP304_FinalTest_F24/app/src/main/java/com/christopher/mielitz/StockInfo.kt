package com.christopher.mielitz

import androidx.room.Entity
import androidx.room.*

//Code retrieved from https://e.centennialcollege.ca/d2l/lms/dropbox/user/folders_list.d2l?ou=1187018&isprv=0
@Entity(tableName = "stock_info")
data class StockInfo(
    @PrimaryKey val stockSymbol: String,
    val companyNote: String,
    val stockQuote: Double
)





