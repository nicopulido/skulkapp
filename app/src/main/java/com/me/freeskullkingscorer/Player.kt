package com.me.freeskullkingscorer


//This is the class that contains the player data
data class Player(
    //immutable player name
    val playerName: String,
    //mutable player score
    var playerScore: Int = 0,
    //mutable player position of the game
)
