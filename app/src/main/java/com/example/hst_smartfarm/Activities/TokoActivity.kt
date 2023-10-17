package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hst_smartfarm.Models.NotifModel
import com.example.hst_smartfarm.Models.TokoModel
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.adapters.NotifAdapter
import com.example.hst_smartfarm.adapters.TokoAdapter
import com.example.hst_smartfarm.databinding.ActivityNotifBinding
import com.example.hst_smartfarm.databinding.ActivityTokoBinding

class TokoActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityTokoBinding
    private lateinit var adapter: TokoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTokoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener(this)

        binding.rvToko.layoutManager = LinearLayoutManager(this@TokoActivity)
        setTokoAdapter()
    }
    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_back ->{
                val intent = Intent(this@TokoActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun setTokoAdapter() {
        val dataList:MutableList<TokoModel> = mutableListOf()

        namaToko().forEachIndexed { index, nama ->
            dataList.add(
                TokoModel(gambarToko().get(index), nama, alamat()[index])
            )
        }

        adapter = TokoAdapter(dataList)
        binding.rvToko.adapter = adapter
    }
    private fun namaToko() : Array<String> {
        return resources.getStringArray(R.array.namaToko)
    }
    private fun alamat() : Array<String> {
        return resources.getStringArray(R.array.alamatToko)
    }
    private fun gambarToko() : List<Int> {
        return listOf(
            R.drawable.toko,
            R.drawable.toko,
            R.drawable.toko,
            R.drawable.toko
        )
    }
}