package com.me.freeskullkingscorer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageButton
import android.widget.TextView

class PlayerAdapter(
    context: Context,

) : ArrayAdapter<Player>(context, 0) {

    override fun getItem(position: Int): Player {
        return GameManager.getPlayerByPosition(position)
    }

    override fun getCount(): Int {
        return GameManager.getPlayers().size
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val view = convertView ?: LayoutInflater.from(context)
            .inflate(R.layout.list_item_player, parent, false)

        val player = getItem(position)

        val nameText = view.findViewById<TextView>(R.id.playerNameListText)
        nameText.text = player.playerName

        val removeButton = view.findViewById<ImageButton>(R.id.remove_player_button)


        removeButton.setOnClickListener {
            GameManager.removePlayerByPosition(position)
            notifyDataSetChanged()
        }

        //returning my own view
        return view
    }

}