package com.christopher.mielitz

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.room.Room
import androidx.room.util.TableInfo
import com.christopher.mielitz.ui.theme.ChrisMielitz_COMP304_FinalTest_F24Theme
import com.christopher.mielitz.*

class Mielitz_Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var mydb = StockDatabase.getInstance(this)
        val myDao = mydb.stockDao()
        var size = mydb.stockDao().showalltheStock().size
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ChrisMielitz_COMP304_FinalTest_F24Theme {
                var gotootherscreen = Intent(this, MainActivity::class.java)


                Column {
                    Text("This Stock Info:")
                    Text(mydb.stockDao().showone().toString())
                    Text("Go back to the main screen")
                    FloatingActionButton(onClick = { startActivity(gotootherscreen) }) {
                        Icon(Icons.Filled.Add, "")
                    }}
                }
            }
        }
    }