package com.example.hst_smartfarm.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hst_smartfarm.Activities.HomeActivity
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.databinding.FragmentBlankBinding

class BlankFragment : Fragment(), View.OnClickListener {
    private lateinit var binding : FragmentBlankBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentBlankBinding.inflate(inflater, container, false)

        binding.abc.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.abc->{
                val intent = Intent(activity, HomeActivity::class.java)
            }
        }
    }


}