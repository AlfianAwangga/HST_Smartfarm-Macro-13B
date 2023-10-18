package com.example.hst_smartfarm.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hst_smartfarm.Activities.ManajemenLahanActivity
import com.example.hst_smartfarm.Activities.ModulActivity
import com.example.hst_smartfarm.Activities.NotifActivity
import com.example.hst_smartfarm.Activities.SupportActivity
import com.example.hst_smartfarm.Activities.TokoActivity
import com.example.hst_smartfarm.Models.CuacaModel
import com.example.hst_smartfarm.Models.LahanModel
import com.example.hst_smartfarm.R
import com.example.hst_smartfarm.adapters.CuacaAdapter
import com.example.hst_smartfarm.adapters.LahanAdapter
import com.example.hst_smartfarm.databinding.FragmentHomeBinding

class HomeFragment : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapterLahan: LahanAdapter
    private lateinit var adapterCuaca: CuacaAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //recyclerView lahan dan cuaca
        binding.rvLahan.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        setLahanAdapter()
        binding.rvCuaca.layoutManager = LinearLayoutManager(activity)
        setCuacaAdapter()

        //onclick ikon
        binding.ivNotif.setOnClickListener(this)
        binding.ivManajemen.setOnClickListener(this)
        binding.ivToko.setOnClickListener(this)
        binding.ivUpdate.setOnClickListener(this)
        binding.ivSupport.setOnClickListener(this)

        return binding.root
    }

    //function onclick ikon
    override fun onClick(v: View) {
        when(v.id) {
            R.id.iv_notif ->{
                val intent = Intent(activity, NotifActivity::class.java)
                startActivity(intent)
            }
            R.id.iv_toko ->{
                val intent = Intent(activity, TokoActivity::class.java)
                startActivity(intent)
            }
            R.id.iv_manajemen ->{
                val intent = Intent(activity, ManajemenLahanActivity::class.java)
                startActivity(intent)
            }
            R.id.iv_update -> {
                val intent = Intent(activity, ModulActivity::class.java)
                startActivity(intent)
            }
            R.id.iv_support -> {
                val intent = Intent(activity, SupportActivity::class.java)
                startActivity(intent)
            }
        }
    }

    //function adapter lahan
    private fun setLahanAdapter() {
        val dataList:MutableList<LahanModel> = mutableListOf()

        namaLahan().forEachIndexed { index, nama ->
            dataList.add(
                LahanModel(gambarLahan().get(index), nama, tanggalTanam()[index], tanggalPanen()[index],
                luasLahan()[index], namaModul()[index], versiModul()[index], kelembabanTanah()[index],
                unsurHara()[index], phTanah()[index], temperatur()[index])
            )
        }

        adapterLahan = LahanAdapter(context,dataList)
        binding.rvLahan.adapter = adapterLahan
    }

    //get data lahan
    private fun namaLahan() : Array<String> {
        return resources.getStringArray(R.array.namaLahan)
    }
    private fun tanggalTanam() : Array<String> {
        return resources.getStringArray(R.array.tanggalTanam)
    }
    private fun gambarLahan() : List<Int> {
        return listOf(
            R.drawable.lahan_padi,
            R.drawable.lahan_tomat
        )
    }
    private fun tanggalPanen() : Array<String> {
        return resources.getStringArray(R.array.tanggalPanen)
    }
    private fun luasLahan() : Array<String> {
        return resources.getStringArray(R.array.luasLahan)
    }
    private fun namaModul() : Array<String> {
        return resources.getStringArray(R.array.namaModul)
    }
    private fun versiModul() : Array<String> {
        return resources.getStringArray(R.array.versiModul)
    }
    private fun kelembabanTanah() : Array<String> {
        return resources.getStringArray(R.array.kelembabanTanah)
    }
    private fun unsurHara() : Array<String> {
        return resources.getStringArray(R.array.unsurHara)
    }
    private fun phTanah() : Array<String> {
        return resources.getStringArray(R.array.phTanah)
    }
    private fun temperatur() : Array<String> {
        return resources.getStringArray(R.array.temperatur)
    }

    //function adapter cuaca
    private fun setCuacaAdapter() {
        val dataList:MutableList<CuacaModel> = mutableListOf()

        hari().forEachIndexed { index, hari ->
            dataList.add(
                CuacaModel(gambarCuaca().get(index), hari,
                perkiraanSuhu1()[index], perkiraanSuhu2()[index])
            )
        }
        adapterCuaca = CuacaAdapter(dataList)
        binding.rvCuaca.adapter = adapterCuaca
    }

    //get data cuaca
    private fun hari() : Array<String> {
        return resources.getStringArray(R.array.hari)
    }
    private fun perkiraanSuhu1() : Array<String> {
        return resources.getStringArray(R.array.perkiraanSuhu1)
    }
    private fun perkiraanSuhu2() : Array<String> {
        return resources.getStringArray(R.array.perkiraanSuhu2)
    }
    private fun gambarCuaca() : List<Int> {
        return listOf(
            R.drawable.cuaca_cerah,
            R.drawable.cuaca_berawan,
            R.drawable.cuaca_hujan,
            R.drawable.cuaca_hujan,
            R.drawable.cuaca_badai,
            R.drawable.cuaca_berawan,
            R.drawable.cuaca_cerah
        )
    }
}