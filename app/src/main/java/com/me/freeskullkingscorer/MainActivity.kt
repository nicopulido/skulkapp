package com.me.freeskullkingscorer

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private var listItems = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,listItems)
        val listView = findViewById<ListView>(R.id.listOfPlayers)
        listView.adapter = adapter

        val button = findViewById<ImageButton>(R.id.addPlayersButton)
        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.enterNameEditText)
            val text = editText.text.toString()
            if(text.isNotEmpty()){
                listItems.add(text)
                adapter.notifyDataSetChanged()
                editText.text.clear()
            }
        }


    }
}