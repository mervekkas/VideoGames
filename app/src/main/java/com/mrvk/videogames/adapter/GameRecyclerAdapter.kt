package com.mrvk.videogames.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrvk.videogames.R
import com.mrvk.videogames.model.Result

class GameRecyclerAdapter(val gameList : ArrayList<Result>) : RecyclerView.Adapter<GameRecyclerAdapter.GameViewHolder>() {
    class GameViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fragment_game_detail,parent,false)
        return GameViewHolder(view)
    }
    override fun getItemCount(): Int {
        return gameList.size
    }
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
    }

}