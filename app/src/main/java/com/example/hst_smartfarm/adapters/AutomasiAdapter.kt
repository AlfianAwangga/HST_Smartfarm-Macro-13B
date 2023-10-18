package com.example.hst_smartfarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Models.AutomasiModel
import com.example.hst_smartfarm.databinding.ListAutomasiBinding

class AutomasiAdapter (private val list: List<AutomasiModel>) : RecyclerView.Adapter<AutomasiAdapter.ViewHolder>(){

    class ViewHolder(val binding: ListAutomasiBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListAutomasiBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivAutomasi1.setImageResource(this.gambar1)
                binding.tvJudulAutomasi.text = this.judul
                binding.tvTugas.text = this.tugas
                binding.ivAutomasi2.setImageResource(this.gambar2)
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}