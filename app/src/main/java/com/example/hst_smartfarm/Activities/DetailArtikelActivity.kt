package com.example.hst_smartfarm.Activities

import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.databinding.ActivityDetailArtikelBinding

class DetailArtikelActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityDetailArtikelBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailArtikelBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get data dari bundle
        val bundle = intent.extras

        bundle?.let { binding.ivDetailArtikel.setImageResource(it.getInt("gambar")) }
        binding.tvJudulDetailArtikel.text = bundle?.getString("judul")
        binding.tvTanggalDetailArtikel.text = bundle?.getString("tanggal")
        binding.tvDetailPenulis.text = bundle?.getString("penulis")
        binding.tvDeskripsiArtikel.text = bundle?.getString("deskripsi")

        //onclick back
        binding.ivBack.setOnClickListener(this)

        //set image exposure
        val exposure = 0.5f
        adjustExposure(binding.ivDetailArtikel, exposure)
    }

    private fun adjustExposure(iv: ImageView, value: Float) {
        val colorMatrix = ColorMatrix()
        colorMatrix.set(
            floatArrayOf(
                value, 0f, 0f, 0f, 0f,
                0f, value, 0f, 0f, 0f,
                0f, 0f, value, 0f, 0f,
                0f, 0f, 0f, 1f, 0f
            )
        )
        val colorFilter = ColorMatrixColorFilter(colorMatrix)
        iv.colorFilter = colorFilter
    }

    override fun onClick(v: View?) {
        TODO("Not yet implemented")
    }
}