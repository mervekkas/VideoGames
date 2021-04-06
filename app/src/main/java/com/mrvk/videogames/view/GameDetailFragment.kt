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

class GameDetailFragment : Fragment() {
    private var gameDetailId = -1
    private lateinit var viewModelDetail : GameDetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModelDetail = ViewModelProviders.of(this).get(GameDetailViewModel::class.java)
        arguments?.let {
            gameDetailId = it.getInt(GAME_ID)
        }
        viewModelDetail.refreshDetailData(gameDetailId)
        observeLiveData()
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
    }

    private fun errorVisible() {
        tv_game_detail_error_message.visibility = View.VISIBLE
        progress_game_detail.visibility = View.GONE
    }

    private fun loadingVisible() {
        progress_game_detail.visibility = View.VISIBLE
    }

    companion object{
        private val GAME_ID = "GAME_ID"
        fun newInstance(gameId:Int) : GameDetailFragment {
            val fragment = GameDetailFragment()
            val bundle = Bundle()
            bundle.putInt(GAME_ID, gameId)
            fragment.arguments = bundle
            return fragment
        }
    }
}