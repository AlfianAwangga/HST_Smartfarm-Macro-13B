package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.databinding.ActivityDetailLahanBinding

class DetailLahanActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityDetailLahanBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailLahanBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

        binding.tvKelembaban.text = bundle?.getString("tanah")
        binding.tvHara.text = bundle?.getString("hara")
        binding.tvPh.text = bundle?.getString("ph")
        binding.tvTemperatur.text = bundle?.getString("temperatur")
        binding.tvDetailNama.text = bundle?.getString("nama")
        binding.tvDetailLuas.text = bundle?.getString("luas")
        binding.tvDetailTanam.text = bundle?.getString("tanam")
        binding.tvDetailPanen.text = bundle?.getString("panen")
        binding.tvDetailModul.text = bundle?.getString("modul")
        binding.tvDetailVersi.text = bundle?.getString("versi")
        bundle?.getInt("gambar")?.let { binding.ivDetailGambar.setImageResource(it) }

        //onclick back
        binding.ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_back ->{
                val intent = Intent(this@DetailLahanActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}