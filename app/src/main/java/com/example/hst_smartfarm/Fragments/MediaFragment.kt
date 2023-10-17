package com.example.hst_smartfarm.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hst_smartfarm.adapters.ViewPagerAdapter
import com.example.hst_smartfarm.databinding.FragmentMediaBinding

class MediaFragment : Fragment() {
    private lateinit var binding : FragmentMediaBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentMediaBinding.inflate(inflater, container, false)

        binding.viewpagerMedia.adapter = ViewPagerAdapter(childFragmentManager)
        binding.tabsMedia.setupWithViewPager(binding.viewpagerMedia)

        return binding.root
    }
}