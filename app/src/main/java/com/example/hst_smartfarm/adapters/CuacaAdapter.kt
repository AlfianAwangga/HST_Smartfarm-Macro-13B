package com.example.hst_smartfarm.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Models.CuacaModel
import com.example.hst_smartfarm.databinding.ListPerkiraanCuacaBinding

class CuacaAdapter (private val list: List<CuacaModel>) : RecyclerView.Adapter<CuacaAdapter.ViewHolder>(){

    class ViewHolder(val binding: ListPerkiraanCuacaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListPerkiraanCuacaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivPerkiraanCuaca.setImageResource(this.gambar)
                binding.tvHari.text = this.hari
                binding.tvPerkiraanSuhu.text = this.suhu1
                binding.tvPerkiraanSuhu2.text = this.suhu2
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}