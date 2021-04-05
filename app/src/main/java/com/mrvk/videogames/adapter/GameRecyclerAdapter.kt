package com.mrvk.videogames.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mrvk.videogames.R
import com.mrvk.videogames.model.Result
import kotlinx.android.synthetic.main.item_game_list.view.*

class GameRecyclerAdapter(val gameList : ArrayList<Result>) : RecyclerView.Adapter<GameRecyclerAdapter.GameViewHolder>() {
    class GameViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val inflater =LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_game_list,parent,false)
        return GameViewHolder(view)
    }
    override fun getItemCount(): Int {
        return gameList.size
    }
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.itemView.tv_game_item_name.text = gameList.get(position).name
        holder.itemView.tv_game_item_rating.text = gameList.get(position).rating.toString()
        holder.itemView.tv_game_item_released.text = gameList.get(position).released
    }
    fun gameListRefresh(newGameList : List<Result>){
        gameList.clear()
        gameList.addAll(newGameList)
        notifyDataSetChanged()
    }
}