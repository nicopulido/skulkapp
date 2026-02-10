package com.me.freeskullkingscorer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class PlayerAdapter(
    context: Context,
    //source of real data
    private val players: MutableList<Player>

) : ArrayAdapter<Player>(context, 0, players) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_player, parent, false)

        val player = players[position]

        val nameText = view.findViewById<TextView>(R.id.playerNameListText)
        nameText.text = player.playerName

        //returning my own view
        return view
    }

}