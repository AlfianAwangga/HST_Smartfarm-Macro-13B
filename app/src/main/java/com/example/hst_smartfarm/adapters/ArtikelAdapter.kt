package com.example.hst_smartfarm.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hst_smartfarm.Activities.DetailArtikelActivity
import com.example.hst_smartfarm.Models.ArtikelModel
import com.example.hst_smartfarm.databinding.ListArtikelBinding

class ArtikelAdapter (private val context: Context?, private val list: List<ArtikelModel>) : RecyclerView.Adapter<ArtikelAdapter.ViewHolder>(){

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

                binding.listArtikel.setOnClickListener{
                    val bundle = Bundle()
                    bundle.putInt("gambar",this.gambar)
                    bundle.putString("judul", this.judul)
                    bundle.putString("tanggal", this.tanggal)
                    bundle.putString("deskripsi", this.deskripsi)
                    bundle.putString("penulis", this.penulis)

                    val intent = Intent(context, DetailArtikelActivity::class.java)
                    intent.putExtras(bundle)
                    context?.startActivity(intent)
                }
            }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}