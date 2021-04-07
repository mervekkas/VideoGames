package com.mrvk.videogames.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.mrvk.videogames.R
import com.mrvk.videogames.adapter.GameRecyclerAdapter
import com.mrvk.videogames.viewmodel.GameListViewModel
import kotlinx.android.synthetic.main.fragment_game_list.*
import kotlinx.android.synthetic.main.tool_bar_layout.*

class GameListFragment : Fragment(), GameRecyclerAdapter.GameAdapterListener {

    private lateinit var viewModel: GameListViewModel
    private val recyclerGameAdapter = GameRecyclerAdapter(arrayListOf(), this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(GameListViewModel::class.java)
        viewModel.refreshListData()

        setToolBar()
        rv_game_list.layoutManager = LinearLayoutManager(context)
        rv_game_list.adapter = recyclerGameAdapter

        setListener()
        observeLiveData()
    }
    private fun setToolBar() {
        tool_bar_title.setText(R.string.list_title)
        img_tool_bar_back.visibility = View.GONE
        tool_bar_search_view.visibility = View.VISIBLE
        //getQueryTextListener()
    }

    private fun getQueryTextListener() {
        tool_bar_search_view.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                TODO("Not yet implemented")
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                TODO("Not yet implemented")
            }

        })
    }

    fun setListener() {
        swipeRefreshLayout.setOnRefreshListener {
            progress_game_list.visibility = View.VISIBLE
            tv_game_list_error_message.visibility = View.GONE
            rv_game_list.visibility = View.GONE
            viewModel.refreshListData()
            swipeRefreshLayout.isRefreshing = false
        }
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

    override fun onClicked(id: Int) {
        val fragment = GameDetailFragment.newInstance(id)
        fragmentManager?.beginTransaction()?.replace(R.id.container_main, fragment)
            ?.addToBackStack("Tag")?.commit()
    }
}