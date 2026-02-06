package com.me.freeskullkingscorer


//This is the class that contains the player data
data class Player(
    //immutable player name
    val playerName: String,
    //mutable player score
    var playerScore: Int = 0,

){

    //methods to add or substract points to the player

    fun addPoints(points : Int){
        playerScore += points
    }

    fun substractPoints(points : Int){
        playerScore -= points
    }
}
