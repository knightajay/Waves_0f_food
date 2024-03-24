package com.example.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.databinding.ActivityPlayOutActitvityBinding

class PlayOutActitvity : AppCompatActivity() {
    private lateinit var binding:ActivityPlayOutActitvityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityPlayOutActitvityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.placemyorder.setOnClickListener{
            val bottomsheetdialog=ConcarateBottomShheet()
            bottomsheetdialog.show(supportFragmentManager,"Test")
        }
    }
}