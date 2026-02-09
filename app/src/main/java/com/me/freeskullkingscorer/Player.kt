package com.me.freeskullkingscorer

import java.util.UUID


//This is the class that contains the player data
data class Player(
    //immutable player id
    val playerID: String = UUID.randomUUID().toString(),
    //immutable player name
    val playerName: String,
    //Points of a player per round
    val pointsPerRound: MutableList<Int> = mutableListOf(),
    //mutable player score
    var playerScore: Int = 0,

){

    //methods to add or substract points to the player

    fun addPoints(points : Int){
        pointsPerRound.add(points)
        playerScore += points
    }

    fun substractPoints(points : Int){
        pointsPerRound.add(points)
        playerScore -= points
    }
}
