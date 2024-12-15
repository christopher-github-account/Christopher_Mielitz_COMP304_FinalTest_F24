//301220844
package com.christopher.mielitz

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.christopher.mielitz.ui.theme.ChrisMielitz_COMP304_FinalTest_F24Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //This gets the database, gets the DAO and viewmodel
        var mydb = StockDatabase.getInstance(this)
        val myDao = mydb.stockDao()
        var myViewModel = StockViewModel()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var gotootherscreen = Intent(this, Mielitz_Activity::class.java)
            ChrisMielitz_COMP304_FinalTest_F24Theme {


                var StockSymbolhere by remember { mutableStateOf("") }
                var CompanyNotevar by remember {mutableStateOf("")}
                var Pricevar by remember { mutableStateOf("0.0") }
                //Program does not allow the user to insert duplicate stocks
                Column {
                    TextField(value = StockSymbolhere, onValueChange = {StockSymbolhere = it}, label = { Text("Stock Symbol") })
                    TextField(value = CompanyNotevar, onValueChange = {CompanyNotevar = it}, label =  { Text("Company Note") })
                    TextField(value = Pricevar, onValueChange = {Pricevar = it}, label = { Text("Price") })
                    //Pricevar is converted to Double on insert
                    Text("Insert")
                    FloatingActionButton(onClick = {
                        var thisstock = StockInfo(StockSymbolhere, CompanyNotevar, Pricevar.toDouble())
                        mydb.stockDao().InsertaStockhere(thisstock)
                    }) {
                        Icon(Icons.Filled.Add, "")
                    }

                    Text("Go to Display Stock")
                    FloatingActionButton(onClick = {startActivity(gotootherscreen)}) {
                        Icon(Icons.Filled.Add, "")
                    }

                    //This shows all stock symbols
                    LazyColumn {
                        for (StockInfo in mydb.stockDao().showalltheStock()) {
                            item{(Text(myViewModel.GetStockSymbol(StockInfo)))}
                        }
                    }
                }

                }
            }
        }
    }
