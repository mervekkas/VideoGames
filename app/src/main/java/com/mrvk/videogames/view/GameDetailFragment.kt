package com.mrvk.videogames.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.mrvk.videogames.R
import com.mrvk.videogames.viewmodel.GameDetailViewModel
import com.mrvk.videogames.viewmodel.GameListViewModel

class GameDetailFragment : Fragment() {

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
    }

    fun observeLiveData() {
        viewModelDetail.gameDetailErroMessage.observe(viewLifecycleOwner, Observer {
            it?.let {

            }
        })
        viewModelDetail.loadingDetail.observe(viewLifecycleOwner, Observer {
            it?.let {

            }
        })
    }
}