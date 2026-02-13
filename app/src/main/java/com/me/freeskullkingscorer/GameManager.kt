package com.me.freeskullkingscorer


//singleton of games
object GameManager {
    private var currentGame: Game = Game()

    //initialize an instance of game

    fun canStartGame(): Boolean{
        return currentGame.players.size >= 2
    }

    fun getPlayers(): List<Player>{
        return currentGame.players
    }

    fun addPlayer(player: Player){
        currentGame.addPlayer(player)
    }
}