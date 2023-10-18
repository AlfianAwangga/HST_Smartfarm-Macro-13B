package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.databinding.ActivitySupportBinding

class SupportActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivitySupportBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySupportBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivBack.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_back -> {
                val intent = Intent(this@SupportActivity, HomeActivity::class.java)
                startActivity(intent)
            }
        }
    }
}