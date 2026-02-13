package com.me.freeskullkingscorer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

//singleton of games
object GameManager {
    private var currentGame: Game = Game()

    //get players live data
    // LiveData
    private val _playersLiveData = MutableLiveData<List<Player>>(currentGame.players)
    fun getPlayersLiveData(): LiveData<List<Player>> = _playersLiveData

    fun canStartGame(): Boolean{
        return currentGame.players.size >= 2
    }

    fun getPlayerByPosition(position: Int): Player {
        return currentGame.players.get(position)
    }

    fun getPlayers(): List<Player>{
        return currentGame.players
    }

    fun addPlayer(player: Player){
        currentGame.addPlayer(player)
        //refresh live data
        _playersLiveData.value = currentGame.players.toList()
    }

    fun removePlayerByPosition(position: Int){
        currentGame.removePlayerByPosition(position)
        //refresh live data
        _playersLiveData.value = currentGame.players.toList()
    }
}