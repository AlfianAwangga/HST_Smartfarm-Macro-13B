package com.example.hst_smartfarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Models.TokoModel
import com.example.hst_smartfarm.databinding.ListTokoBinding

class TokoAdapter (private val list: List<TokoModel>) : RecyclerView.Adapter<TokoAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListTokoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListTokoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivGambarToko.setImageResource(this.gambar)
                binding.tvNamaToko.text = this.nama
                binding.tvAlamatToko.text = this.alamat
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}