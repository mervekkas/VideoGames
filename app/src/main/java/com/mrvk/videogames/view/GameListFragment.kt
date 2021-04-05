package com.mrvk.videogames.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrvk.videogames.R
import com.mrvk.videogames.adapter.GameRecyclerAdapter
import com.mrvk.videogames.viewmodel.GameListViewModel
import kotlinx.android.synthetic.main.fragment_game_list.*

class GameListFragment : Fragment() {

    private lateinit var viewModel: GameListViewModel
    private val recyclerGameAdapter = GameRecyclerAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(GameListViewModel::class.java)
        viewModel.refreshListData()

        rv_game_list.layoutManager = LinearLayoutManager(context)
        rv_game_list.adapter = recyclerGameAdapter

        observeLiveData()
    }
    fun observeLiveData() {

        viewModel.gameList.observe(viewLifecycleOwner, Observer {
            it?.let {
                rv_game_list.visibility = View.VISIBLE
                recyclerGameAdapter.gameListRefresh(it)
            }
        })
        viewModel.gameErroMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it)
                    errorVisible()
                else
                    listVisible()
            }
        })
        viewModel.loading.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it)
                    loadingVisible()
            }
        })
    }

    private fun errorVisible() {
        rv_game_list.visibility = View.GONE
        tv_game_list_error_message.visibility = View.VISIBLE
        progress_game_list.visibility = View.GONE
    }

    private fun loadingVisible() {
        rv_game_list.visibility = View.GONE
        progress_game_list.visibility = View.VISIBLE
    }

    private fun listVisible() {
        rv_game_list.visibility = View.VISIBLE
        progress_game_list.visibility = View.GONE
        tv_game_list_error_message.visibility = View.GONE
    }
}