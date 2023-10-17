package com.example.hst_smartfarm.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.Models.UserModel
import com.example.hst_smartfarm.databinding.ActivityRegistrasiBinding

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    //deklarasi
    private lateinit var binding : ActivityRegistrasiBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrasiBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //button "buat akun"
        binding.btnRegist.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_regist -> {
                //get inputan editText
                val nama = binding.etNama.text.toString()
                val email = binding.etRegistEmail.text.toString()
                val telp = binding.etNotelp.text.toString()
                val password = binding.etRegistPassword.text.toString()
                val konfirmasi = binding.etKonfirmasi.text.toString()

                //cek konfirmasi password
                if (konfirmasi == password) {
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    intent.putExtra("user", UserModel(nama, email, telp, password))
                    startActivity(intent)
                }
                else {
                    val notif = Toast.makeText(this@RegisterActivity, "konfirmasi password anda salah", Toast.LENGTH_SHORT)
                    notif.show()
                }
            }
        }
    }
}