package com.mrvk.videogames.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.mrvk.videogames.R
import com.mrvk.videogames.model.Result
import com.mrvk.videogames.util.downloadImage
import com.mrvk.videogames.util.placeHolderCreated
import com.mrvk.videogames.util.CustomFilter
import com.mrvk.videogames.view.GameListFragmentDirections
import kotlinx.android.synthetic.main.item_game_list.view.*

class GameRecyclerAdapter(var gameList : ArrayList<Result>) :
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
        gameList.get(position).id?.let { clickItem(holder.itemView, it) }
        holder.itemView.tv_game_item_name.text = gameList.get(position).name
        holder.itemView.tv_game_item_rating.text = gameList.get(position).rating.toString()
        holder.itemView.tv_game_item_released.text = " - " +gameList.get(position).released
        holder.itemView.img_game_item.downloadImage(gameList.get(position).backgroundImage, placeHolderCreated(holder.itemView.context))
    }

    private fun clickItem(itemView: View, id: Int) {
        itemView.setOnClickListener {
            val action = GameListFragmentDirections.actionGameListFragmentToGameDetailFragment(id)
            Navigation.findNavController(it).navigate(action)
        }
    }

    fun gameListRefresh(newGameList : List<Result>){
        gameList.addAll(newGameList)
        notifyDataSetChanged()
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