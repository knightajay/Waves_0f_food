package com.example.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wavesoffood.databinding.ActivityDetailBinding

class detailActivity : AppCompatActivity() {
    private lateinit var binding:ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val foodname=intent.getStringExtra("MenuItemName")
        val foodimage=intent.getIntExtra("Menuitemimage",0)
        binding.Nameoffood.text=foodname
        binding.imagefooddetail.setImageResource(foodimage)
        binding.imagebuttondetail.setOnClickListener{
            finish()
        }
    }
}