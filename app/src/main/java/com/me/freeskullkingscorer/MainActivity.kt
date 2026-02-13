package com.me.freeskullkingscorer

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton


/*
Principal screen of the app
Allows:
    create the players of the game
    show the players on a list
    move to the game screen
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //creating the game of the instance

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Configuration of listview and adapter
        //val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1,GameManager.getPlayers())
        val adapter = PlayerAdapter(this)
        val listView = findViewById<ListView>(R.id.listOfPlayers)
        listView.adapter = adapter


        //button to start the game
        val startButton = findViewById<MaterialButton>(R.id.buttonStart)
        startButton.isEnabled = GameManager.canStartGame()
        //button to add a new player to the list
        val addPlayersButton = findViewById<ImageButton>(R.id.addPlayersButton)
        //button to remove players from the list


        startButton.setOnClickListener {
            val intent = Intent(this, inPlayScreen::class.java)
            startActivity(intent)
        }


        addPlayersButton.setOnClickListener {
            val editText = findViewById<EditText>(R.id.enterNameEditText)
            val text = editText.text.toString()
            if(text.isNotEmpty()){
                //adds a new player to the beginning of the list
                val player = Player(playerName = text)
                GameManager.addPlayer(player)
                adapter.notifyDataSetChanged()
                editText.text.clear()
                startButton.isEnabled = GameManager.canStartGame()
            }
        }

        GameManager.getPlayersLiveData().observe(this){
            startButton.isEnabled = GameManager.canStartGame()
            adapter.notifyDataSetChanged()
        }


    }
}