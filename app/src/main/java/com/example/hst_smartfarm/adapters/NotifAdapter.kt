package com.example.hst_smartfarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Models.NotifModel
import com.example.hst_smartfarm.databinding.ListNotifBinding

class NotifAdapter(private val list: List<NotifModel>) : RecyclerView.Adapter<NotifAdapter.ViewHolder>(){

    class ViewHolder(val binding: ListNotifBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListNotifBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivGambarNotif.setImageResource(this.gambar)
                binding.tvJudulNotif.text = this.judul
                binding.tvKeteranganNotif.text = this.keterangan
            }
        }
    }


}