package com.example.hst_smartfarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Models.ModulModel
import com.example.hst_smartfarm.databinding.ListModulBinding

class ModulAdapter (private val list: List<ModulModel>) : RecyclerView.Adapter<ModulAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListModulBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListModulBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.tvNamaModul.text = this.nama
                binding.tvVersiModul.text = "pembaruan ke versi $versi"
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}