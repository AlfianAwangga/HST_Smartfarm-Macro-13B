package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hst_smartfarm.Models.ModulModel
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.adapters.ModulAdapter
import com.example.hst_smartfarm.databinding.ActivityModulBinding

class ModulActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityModulBinding
    private lateinit var adapter: ModulAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityModulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener(this)

        binding.rvModul.layoutManager = LinearLayoutManager(this@ModulActivity)
        setModulAdapter()
    }
    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_back ->{
                val intent = Intent(this@ModulActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }

    private fun setModulAdapter() {
        val dataList:MutableList<ModulModel> = mutableListOf()

        namaModul().forEachIndexed { index, nama ->
            dataList.add(
                ModulModel(nama, versi()[index])
            )
        }

        adapter = ModulAdapter(dataList)
        binding.rvModul.adapter = adapter
    }
    private fun namaModul() : Array<String> {
        return resources.getStringArray(R.array.modul)
    }
    private fun versi() : Array<String> {
        return resources.getStringArray(R.array.versi)
    }
}