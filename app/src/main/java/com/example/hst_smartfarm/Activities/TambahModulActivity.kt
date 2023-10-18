package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.databinding.ActivityTambahModulBinding

class TambahModulActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityTambahModulBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTambahModulBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.modulTambah.setOnClickListener(this)
        binding.ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.modul_tambah -> {
                val bundle = Bundle()
                bundle.putString("modul", binding.tvModul.text.toString())
                val intent = Intent(this@TambahModulActivity, TambahLahanActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
            R.id.iv_back -> {
                val intent = Intent(this@TambahModulActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}