package com.me.freeskullkingscorer


//singleton of games
object GameManager {
    var currentGame: Game? = null
            private set

    //initialize an instance of game
    fun startGame(game: Game){
        currentGame = game
    }
}