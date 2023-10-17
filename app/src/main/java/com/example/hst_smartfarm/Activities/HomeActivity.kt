package com.example.hst_smartfarm.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.hst_smartfarm.Fragments.HomeFragment
import com.example.hst_smartfarm.Fragments.MediaFragment
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras

//        if (bundle != null) {
//            bindingHomeFragment.tvHomeNama.setText(bundle.getString("nama"))
//        }
        //bottom navigation
        binding.bottomNavigation.setOnItemSelectedListener {menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> {
                    replaceFragment(HomeFragment())
                    true
                }
                R.id.bottom_media -> {
                    replaceFragment(MediaFragment())
                    true
                }
                R.id.bottom_otomasi -> {
                    replaceFragment(MediaFragment())
                    true
                }
                R.id.bottom_pengaturan -> {
                    replaceFragment(MediaFragment())
                    true
                }
                else -> false
            }
        }
        replaceFragment(HomeFragment())
    }

    //replace fragment
    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        fragmentTransaction.commit()
    }
}