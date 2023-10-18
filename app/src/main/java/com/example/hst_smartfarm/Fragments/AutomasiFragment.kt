package com.example.hst_smartfarm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hst_smartfarm.Models.AutomasiModel
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.adapters.AutomasiAdapter
import com.example.hst_smartfarm.databinding.FragmentAutomasiBinding

class AutomasiFragment : Fragment() {
    private lateinit var binding: FragmentAutomasiBinding
    private lateinit var adapterAutomasi : AutomasiAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAutomasiBinding.inflate(inflater, container, false)

        binding.rvAutomasi.layoutManager = LinearLayoutManager(activity)
        setAutomasiAdapter()

        return binding.root
    }

    private fun setAutomasiAdapter() {
        val dataList:MutableList<AutomasiModel> = mutableListOf()

        judulAutomasi().forEachIndexed { index, judul ->
            dataList.add(
                AutomasiModel(judul, jumlahTugas()[index], gambar1().get(index), gambar2().get(index))
            )
        }

        adapterAutomasi = AutomasiAdapter(dataList)
        binding.rvAutomasi.adapter = adapterAutomasi
    }

    private fun judulAutomasi() : Array<String> {
        return resources.getStringArray(R.array.judulAutomasi)
    }
    private fun jumlahTugas() : Array<String> {
        return resources.getStringArray(R.array.jumlahTugas)
    }
    private fun gambar1() : List<Int> {
        return listOf(
            R.drawable.icon_automasi1,
            R.drawable.icon_automasi3,
            R.drawable.icon_automasi1
        )
    }
    private fun gambar2() : List<Int> {
        return listOf(
            R.drawable.icon_automasi2,
            R.drawable.icon_automasi4,
            R.drawable.icon_automasi2
        )
    }
}