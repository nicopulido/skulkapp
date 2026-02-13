package com.me.freeskullkingscorer


//singleton of games
object GameManager {
    private var currentGame: Game? = null

    //initialize an instance of game
    fun createGame() {
        if (currentGame != null) {
            throw IllegalStateException("Ya hay un juego activo")
        }
        currentGame = Game()
    }

    fun getGame(): Game {
        return currentGame ?: throw IllegalStateException("No hay juego creado")
    }
}