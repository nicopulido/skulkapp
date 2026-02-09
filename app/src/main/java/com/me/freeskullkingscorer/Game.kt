package com.me.freeskullkingscorer

import java.util.Date
import java.util.UUID


data class Game(
    //immutable game id
    val gameID: String = UUID.randomUUID().toString(),
    //players of the game
    val players : MutableList<Player> = mutableListOf(),
    //Time and date of the game
    val date: Date = Date(),

    ){

    //methods to add and remove players

    fun addPlayer(player: Player){
        players.add(0,player)
    }

    fun removePlayerByPosition(position: Int){
        players.removeAt(position)
    }

}
