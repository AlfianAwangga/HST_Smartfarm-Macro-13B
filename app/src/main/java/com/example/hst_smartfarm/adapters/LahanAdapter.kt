package com.example.hst_smartfarm.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Activities.DetailLahanActivity
import com.example.hst_smartfarm.Models.LahanModel
import com.example.hst_smartfarm.databinding.ListLahanBinding

class LahanAdapter(private val context: Context?, private val list: List<LahanModel>) :
    RecyclerView.Adapter<LahanAdapter.ViewHolder>() {

    class ViewHolder(val binding: ListLahanBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListLahanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(list[position]) {
                binding.ivLahan.setImageResource(this.gambar)
                binding.tvNamaLahan.text = this.nama
                binding.tvTanggalTanam.text = "tanggal tanam : $tanam"

                binding.list.setOnClickListener{
                    val bundle = Bundle()
                    bundle.putInt("gambar", this.gambar)
                    bundle.putString("nama", this.nama)
                    bundle.putString("tanam", this.tanam)
                    bundle.putString("panen", this.panen)
                    bundle.putString("luas", this.luas)
                    bundle.putString("modul", this.modul)
                    bundle.putString("versi", this.versi)
                    bundle.putString("tanah", this.tanah)
                    bundle.putString("hara", this.hara)
                    bundle.putString("ph", this.ph)
                    bundle.putString("temperatur", this.temperatur)

                    val intent = Intent(context, DetailLahanActivity::class.java)
                    intent.putExtras(bundle)
                    context?.startActivity(intent)
                }
            }
        }
    }
}