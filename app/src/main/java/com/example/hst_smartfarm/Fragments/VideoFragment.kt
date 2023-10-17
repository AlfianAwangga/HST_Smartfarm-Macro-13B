package com.example.hst_smartfarm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.hst_smartfarm.Models.VideoModel
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.adapters.VideoAdapter
import com.example.hst_smartfarm.databinding.FragmentVideoBinding

class VideoFragment : Fragment() {
    private lateinit var binding: FragmentVideoBinding
    private lateinit var adapterVideo: VideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        binding = FragmentVideoBinding.inflate(inflater, container, false)

        binding.rvVideo.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        setVideoAdapter()
        return binding.root
    }

    private fun setVideoAdapter() {
        val dataList:MutableList<VideoModel> = mutableListOf()

        judulVideo().forEachIndexed { index, judul ->
            dataList.add(
                VideoModel(gambarVideo().get(index), judul)
            )
        }

        adapterVideo = VideoAdapter(dataList)
        binding.rvVideo.adapter = adapterVideo
    }

    private fun judulVideo() : Array<String> {
        return resources.getStringArray(R.array.judulVideo)
    }
    private fun gambarVideo() : List<Int> {
        return listOf(
            R.drawable.lahan_padi,
            R.drawable.lahan_tomat,
            R.drawable.lahan_tomat,
            R.drawable.lahan_padi,
            R.drawable.lahan_padi
        )
    }
}