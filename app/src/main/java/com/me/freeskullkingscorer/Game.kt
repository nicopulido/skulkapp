package com.me.freeskullkingscorer

import java.util.Date
import java.util.UUID


data class Game(
    //immutable game id
    val gameID: String = UUID.randomUUID().toString(),
    //players of the game
    private val _players: MutableList<Player> = mutableListOf<Player>(),
    //Time and date of the game
    val date: Date = Date()

    ){

    val players: List<Player>
        get() = _players.toList()

    //methods to add and remove players

    fun addPlayer(player: Player){
        _players.add(0,player)

    }

    fun removePlayerByPosition(position: Int){
        _players.removeAt(position)
    }

}
