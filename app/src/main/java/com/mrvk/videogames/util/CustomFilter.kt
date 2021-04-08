package com.mrvk.videogames.util

import android.widget.Filter
import com.mrvk.videogames.adapter.GameRecyclerAdapter
import com.mrvk.videogames.model.Result
import java.util.*
import kotlin.collections.ArrayList

class CustomFilter(
    internal val filterList: ArrayList<Result>,
    internal var adapter: GameRecyclerAdapter
) : Filter() {
    override fun performFiltering(charSequence: CharSequence?): FilterResults {
        //mantik ile sorgulama yaparak ver filtrelemeyi saglar
        var char_sequence = charSequence.toString().toLowerCase()
        val results = FilterResults()
        if (char_sequence != null && char_sequence.length > 2) {
            val filteredPlayers = ArrayList<Result>()
            filterList.forEach { _result ->
                _result.name?.let {
                if (it.toLowerCase(Locale.getDefault()).contains(char_sequence)) {
                        filteredPlayers.add(_result)
                    }
                }
            }
            results.values = filteredPlayers
        } else {
            results.values = filterList
        }
        return results
    }

    override fun publishResults(constraint: CharSequence?, results: FilterResults?) {
        adapter.tempGameList = adapter.gameList
        adapter.gameList = results?.values as ArrayList<Result>
        adapter.notifyDataSetChanged()
    }
}