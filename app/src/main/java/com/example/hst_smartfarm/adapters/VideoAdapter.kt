package com.example.hst_smartfarm.adapters

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
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

                //set image exposure
                val exposure = 0.75f
                adjustExposure(binding.ivGambarVideo, exposure)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun adjustExposure(iv: ImageView, value: Float) {
        val colorMatrix = ColorMatrix()
        colorMatrix.set(
            floatArrayOf(
                value, 0f, 0f, 0f, 0f,
                0f, value, 0f, 0f, 0f,
                0f, 0f, value, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )
        )
        val colorFilter = ColorMatrixColorFilter(colorMatrix)
        iv.colorFilter = colorFilter
    }
}
