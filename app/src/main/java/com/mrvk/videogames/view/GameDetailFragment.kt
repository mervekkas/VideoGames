package com.mrvk.videogames.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mrvk.videogames.R
import com.mrvk.videogames.model.GameDetail
import com.mrvk.videogames.util.downloadImage
import com.mrvk.videogames.util.placeHolderCreated
import com.mrvk.videogames.viewmodel.GameDetailViewModel
import com.mrvk.videogames.viewmodel.GameListViewModel
import kotlinx.android.synthetic.main.fragment_game_detail.*
import kotlinx.android.synthetic.main.fragment_game_list.*
import kotlinx.android.synthetic.main.tool_bar_layout.*

class GameDetailFragment : Fragment() {
    private var gameDetailId = -1
    private lateinit var viewModelDetail : GameDetailViewModel
    private lateinit var gameName: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelDetail = ViewModelProviders.of(this).get(GameDetailViewModel::class.java)
        arguments?.let {
            gameDetailId = GameDetailFragmentArgs.fromBundle(it).id
        }
        viewModelDetail.refreshDetailData(gameDetailId)
        observeLiveData()
    }
    private fun setToolBar() {
        tool_bar_title.text = gameName
        tool_bar_search_view.visibility = View.GONE
        line_tool_bar.visibility = View.GONE
        img_tool_bar_back.visibility = View.VISIBLE
        backClick()
    }
    fun observeLiveData() {
        viewModelDetail.gameDetail.observe(viewLifecycleOwner, Observer {
            it?.let {
                detailVisible(it)
            }
        })
        viewModelDetail.gameDetailErroMessage.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it)
                    errorVisible()

            }
        })
        viewModelDetail.loadingDetail.observe(viewLifecycleOwner, Observer {
            it?.let {
                if (it)
                    loadingVisible()
            }
        })
    }

    private fun detailVisible(it: GameDetail) {
        gameName = it.name.toString()
        line.visibility = View.VISIBLE
        line_second.visibility = View.VISIBLE
        tv_detail_game_name.text = it.name
        tv_detail_game_release.text = it.released
        tv_detail_game_metacritic.text = "Metacritic : " + it.metacritic.toString()
        tv_detail_game_description.text = it.description
        context?.let { it1 -> placeHolderCreated(it1) }?.let { it2 ->
            img_game_detail.downloadImage(it.backgroundImage,
                it2
            )
        }
        progress_game_detail.visibility = View.GONE
        tv_game_detail_error_message.visibility = View.GONE
        setToolBar()
    }

    private fun errorVisible() {
        tv_game_detail_error_message.visibility = View.VISIBLE
        progress_game_detail.visibility = View.GONE
    }

    private fun loadingVisible() {
        progress_game_detail.visibility = View.VISIBLE
    }

    private fun backClick() {
        img_tool_bar_back.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }
}