package com.example.hst_smartfarm.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.hst_smartfarm.Fragments.ArtikelFragment
import com.example.hst_smartfarm.Fragments.VideoFragment

class ViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getCount(): Int {
        return 2
    }

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ArtikelFragment()
            }
            else -> {
                VideoFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            0 -> "Artikel"
            else -> {
                return "Video"
            }
        }
    }
}