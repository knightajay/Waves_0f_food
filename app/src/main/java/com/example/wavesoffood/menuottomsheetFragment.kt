package com.example.wavesoffood


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.adapter.menuadapter
import com.example.wavesoffood.databinding.FragmentMenuottomsheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class menuottomsheetFragment : BottomSheetDialogFragment(){
    private lateinit var binding: FragmentMenuottomsheetBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
    binding=FragmentMenuottomsheetBinding.inflate(inflater,container,false)
binding.buttonback.setOnClickListener{
    dismiss()
}
        val menufoodname= listOf("burger","sandwitch","momos","Items","samosaa","burger","sandwitch","momos","Items","samosaa")
        val menuitemprice= listOf("$5","$6","$8","$9","$3","$5","$6","$8","$9","$3")
        val menuimage= listOf(
            R.drawable.menup,
            R.drawable.menupppp,
            R.drawable.menuppppp,
            R.drawable.menupp,
            R.drawable.menuppp,
            R.drawable.menup,
            R.drawable.menupppp,
            R.drawable.menuppppp,
            R.drawable.menupp,
            R.drawable.menuppp,
        )
        val adapter= menuadapter(ArrayList(menufoodname),ArrayList(menuitemprice),ArrayList(menuimage),requireContext())
        binding.menurecyclerview.layoutManager= LinearLayoutManager(requireContext())
        binding.menurecyclerview.adapter=adapter
        return binding.root

    }

    companion object {

    }
}