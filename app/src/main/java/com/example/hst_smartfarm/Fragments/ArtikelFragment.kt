package com.example.hst_smartfarm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hst_smartfarm.Models.ArtikelModel
import com.example.hst_smartfarm.Models.LahanModel
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.adapters.ArtikelAdapter
import com.example.hst_smartfarm.adapters.LahanAdapter
import com.example.hst_smartfarm.databinding.FragmentArtikelBinding

class ArtikelFragment : Fragment() {
    private lateinit var binding: FragmentArtikelBinding
    private lateinit var adapterArtikel : ArtikelAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentArtikelBinding.inflate(inflater, container, false)

        binding.rvArtikel.layoutManager = LinearLayoutManager(activity)
        setArtikelAdapter()
        return binding.root
    }

    private fun setArtikelAdapter() {
        val dataList:MutableList<ArtikelModel> = mutableListOf()

        judulArtikel().forEachIndexed { index, judul ->
            dataList.add(
                ArtikelModel(gambarArtikel().get(index), judul, tanggalUpload()[index], deskripsi()[index], penulis()[index]))
        }

        adapterArtikel = ArtikelAdapter(context, dataList)
        binding.rvArtikel.adapter = adapterArtikel
    }

    private fun judulArtikel() : Array<String> {
        return resources.getStringArray(R.array.judulArtikel)
    }
    private fun tanggalUpload() : Array<String> {
        return resources.getStringArray(R.array.tanggalUpload)
    }
    private fun gambarArtikel() : List<Int> {
        return listOf(
            R.drawable.artikel,
            R.drawable.artikel2,
            R.drawable.artikel3,
            R.drawable.artikel4
        )
    }
    private fun deskripsi() : Array<String> {
        return resources.getStringArray(R.array.deskripsiArtikel)
    }
    private fun penulis() : Array<String> {
        return resources.getStringArray(R.array.penulisArtikel)
    }
}