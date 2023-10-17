package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.Models.UserModel
import com.example.hst_smartfarm.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding : ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //get data Parcelable
        val email = intent.getParcelableExtra<UserModel>("user")?.email
        val password = intent.getParcelableExtra<UserModel>("user")?.password

        //set text
        binding.etEmail.setText(email)
        binding.etPassword.setText(password)

        //onclick
        binding.tvDaftar.setOnClickListener(this)
        binding.btnLogin.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
             R.id.tv_daftar -> {
                 val intent = Intent(this@LoginActivity, RegisterActivity::class.java)
                 startActivity(intent)
            }
            R.id.btn_login -> {
                val nama = intent.getParcelableExtra<UserModel>("user")?.nama
                val intent = Intent(this@LoginActivity, HomeActivity::class.java)
                intent.putExtra("nama", nama)
                startActivity(intent)
            }
        }
    }

}