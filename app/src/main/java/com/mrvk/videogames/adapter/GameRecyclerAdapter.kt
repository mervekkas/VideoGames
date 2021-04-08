package com.mrvk.videogames.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.recyclerview.widget.RecyclerView
import com.mrvk.videogames.R
import com.mrvk.videogames.model.Result
import com.mrvk.videogames.util.downloadImage
import com.mrvk.videogames.util.placeHolderCreated
import com.mrvk.videogames.util.CustomFilter
import kotlinx.android.synthetic.main.item_game_list.view.*

class GameRecyclerAdapter(var gameList : ArrayList<Result>, val listener : GameAdapterListener) :
    RecyclerView.Adapter<GameRecyclerAdapter.GameViewHolder>(), Filterable {
    var filter: CustomFilter? = null
    var tempGameList: ArrayList<Result> = arrayListOf()
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
        clickItem(holder.itemView,gameList,position)
        holder.itemView.tv_game_item_name.text = gameList.get(position).name
        holder.itemView.tv_game_item_rating.text = gameList.get(position).rating.toString()
        holder.itemView.tv_game_item_released.text = " - " +gameList.get(position).released
        holder.itemView.img_game_item.downloadImage(gameList.get(position).backgroundImage, placeHolderCreated(holder.itemView.context))
    }

    private fun clickItem(itemView: View, gameList: List<Result>, position: Int) {
        itemView.setOnClickListener {
            gameList.get(position).id?.let { it1 ->
                listener.onClicked(it1) }
        }
    }

    fun gameListRefresh(newGameList : List<Result>){
        gameList.addAll(newGameList)
        notifyDataSetChanged()
    }

    interface GameAdapterListener {
        fun onClicked(id : Int)
    }

    override fun getFilter(): Filter {
        if (filter == null) {
            filter = CustomFilter(
                gameList as ArrayList<Result>,
                this
            )
        }
        return filter as CustomFilter
    }
}