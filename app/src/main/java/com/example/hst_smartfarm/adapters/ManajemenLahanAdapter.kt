package com.example.hst_smartfarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Models.LahanModel
import com.example.hst_smartfarm.databinding.ListLahanBinding
import com.example.hst_smartfarm.databinding.ListManajemenLahanBinding

class ManajemenLahanAdapter(private val list: List<LahanModel>) :
    RecyclerView.Adapter<ManajemenLahanAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListManajemenLahanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListManajemenLahanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivManajemenLahan.setImageResource(this.gambar)
                binding.tvManajemenLahan.text = this.nama
                binding.tvDeskripsi.text = "Di tanam pada tanggal $tanam dengan kemungkinan panen " +
                        "tanggal $panen, menggunakan Modul $modul"
            }
        }
    }
}