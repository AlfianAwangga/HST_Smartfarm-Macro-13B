package com.example.hst_smartfarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Models.VideoModel
import com.example.hst_smartfarm.databinding.ListVideoBinding

class VideoAdapter (private val list: List<VideoModel>) : RecyclerView.Adapter<VideoAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListVideoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivGambarVideo.setImageResource(this.gambar)
                binding.tvJudulVideo.text = this.judul
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}
