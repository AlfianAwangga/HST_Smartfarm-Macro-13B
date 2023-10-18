package com.example.hst_smartfarm.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.hst_smartfarm.Fragments.HomeFragment
import com.example.hst_smartfarm.Fragments.MediaFragment
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.databinding.ActivityHomeBinding
import com.google.android.material.navigation.NavigationBarView

class HomeActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val bundle = intent.extras

//        if (bundle != null) {
//            bindingHomeFragment.tvHomeNama.setText(bundle.getString("nama"))
//        }
        binding.bottomNavigation.setOnItemSelectedListener(this)
        replaceFragment(HomeFragment())
    }

    //replace fragment
    private fun replaceFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.bottom_home -> {
                replaceFragment(HomeFragment())
                return true
            }
            R.id.bottom_media -> {
                replaceFragment(MediaFragment())
                return true
            }
            R.id.bottom_automasi -> {
                replaceFragment(MediaFragment())
                return true
            }
            R.id.bottom_pengaturan -> {
                replaceFragment(MediaFragment())
                return true
            }
            else -> return false
        }
    }
}