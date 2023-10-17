package com.example.hst_smartfarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Models.ArtikelModel
import com.example.hst_smartfarm.databinding.ListArtikelBinding

class ArtikelAdapter (private val list: List<ArtikelModel>) : RecyclerView.Adapter<ArtikelAdapter.ViewHolder>(){

    class ViewHolder(val binding: ListArtikelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListArtikelBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivArtikel.setImageResource(this.gambar)
                binding.tvJudulArtikel.text = this.judul
                binding.tvTanggalArtikel.text = this.tanggal
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}