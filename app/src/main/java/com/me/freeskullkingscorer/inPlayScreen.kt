package com.me.freeskullkingscorer

import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.util.TypedValue

class inPlayScreen : AppCompatActivity() {

    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_in_play_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            //find tableLayout of play screen
            tableLayout = findViewById<TableLayout>(R.id.tableLayoutPlayScreen)

            //hardcode numbers of columns and rows

            createTable(10,8)

            insets
        }
    }

    private fun createTable(rows: Int, columns: Int){
        tableLayout.removeAllViews()
        for(i in 0 until rows){
            val row = TableRow(this)

            for(j in 0 until columns){
                val textView = TextView(this).apply{
                    //this is harcoded temporaly, it will be on strings.xml
                    text = "I$i J$j"
                    //temporal to set textsize
                    setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
                    setPadding(5, 14, 5, 14)
                }
                row.addView(textView)
            }
            tableLayout.addView(row)
        }
    }
}