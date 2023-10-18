package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hst_smartfarm.Models.LahanModel
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.adapters.ManajemenLahanAdapter
import com.example.hst_smartfarm.databinding.ActivityManajemenLahanBinding

class ManajemenLahanActivity : AppCompatActivity(), View.OnClickListener {
    private  lateinit var binding : ActivityManajemenLahanBinding
    private lateinit var adapter: ManajemenLahanAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManajemenLahanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvManajemen.layoutManager = LinearLayoutManager(this@ManajemenLahanActivity)
        setLahanAdapter()

        binding.ivBack.setOnClickListener(this)
        binding.ivAdd.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_back ->{
                val intent = Intent(this@ManajemenLahanActivity, HomeActivity::class.java)
                startActivity(intent)
            }
            R.id.iv_add ->{
                val intent = Intent(this@ManajemenLahanActivity, TambahModulActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setLahanAdapter() {
        val dataList:MutableList<LahanModel> = mutableListOf()

        namaLahan().forEachIndexed { index, nama ->
            dataList.add(
                LahanModel(gambarLahan().get(index), nama, tanggalTanam()[index], tanggalPanen()[index],
                luasLahan()[index], namaModul()[index], versiModul()[index], kelembabanTanah()[index],
                unsurHara()[index], phTanah()[index], temperatur()[index])
            )
        }

        adapter = ManajemenLahanAdapter(dataList)
        binding.rvManajemen.adapter = adapter
    }

    private fun namaLahan() : Array<String> {
        return resources.getStringArray(R.array.namaLahan)
    }
    private fun tanggalTanam() : Array<String> {
        return resources.getStringArray(R.array.tanggalTanam)
    }
    private fun gambarLahan() : List<Int> {
        return listOf(
            R.drawable.lahan_padi,
            R.drawable.lahan_tomat
        )
    }
    private fun tanggalPanen() : Array<String> {
        return resources.getStringArray(R.array.tanggalPanen)
    }
    private fun luasLahan() : Array<String> {
        return resources.getStringArray(R.array.luasLahan)
    }
    private fun namaModul() : Array<String> {
        return resources.getStringArray(R.array.namaModul)
    }
    private fun versiModul() : Array<String> {
        return resources.getStringArray(R.array.versiModul)
    }
    private fun kelembabanTanah() : Array<String> {
        return resources.getStringArray(R.array.kelembabanTanah)
    }
    private fun unsurHara() : Array<String> {
        return resources.getStringArray(R.array.unsurHara)
    }
    private fun phTanah() : Array<String> {
        return resources.getStringArray(R.array.phTanah)
    }
    private fun temperatur() : Array<String> {
        return resources.getStringArray(R.array.temperatur)
    }
}