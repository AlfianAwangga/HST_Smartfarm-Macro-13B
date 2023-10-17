package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hst_smartfarm.Models.NotifModel
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.adapters.NotifAdapter
import com.example.hst_smartfarm.databinding.ActivityNotifBinding

class NotifActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityNotifBinding
    private lateinit var adapter: NotifAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNotifBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener(this)

        binding.rvNotif.layoutManager = LinearLayoutManager(this@NotifActivity)
        setNotifAdapter()
    }
    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_back ->{
                val intent = Intent(this@NotifActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun setNotifAdapter() {
        val dataList:MutableList<NotifModel> = mutableListOf()

        judulNotif().forEachIndexed { index, judul ->
            dataList.add(
                NotifModel(gambarNotif().get(index), judul, keterangan()[index])
            )
        }

        adapter = NotifAdapter(dataList)
        binding.rvNotif.adapter = adapter
    }
    private fun judulNotif() : Array<String> {
        return resources.getStringArray(R.array.judulNotif)
    }
    private fun keterangan() : Array<String> {
        return resources.getStringArray(R.array.keteranganNotif)
    }
    private fun gambarNotif() : List<Int> {
        return listOf(
            R.drawable.notif_1,
            R.drawable.notif_1,
            R.drawable.notif_2,
            R.drawable.notif_2
        )
    }
}