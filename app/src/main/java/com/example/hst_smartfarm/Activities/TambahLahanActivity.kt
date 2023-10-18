package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.databinding.ActivityTambahLahanBinding

class TambahLahanActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTambahLahanBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahLahanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val data = intent.extras
        binding.etModulTambah.setText(data?.getString("modul"))

        binding.ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_back -> {
                val intent = Intent(this@TambahLahanActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}