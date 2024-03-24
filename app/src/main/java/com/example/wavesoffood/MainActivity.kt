package com.example.wavesoffood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.example.wavesoffood.databinding.ActivityMainBinding
import com.example.wavesoffood.databinding.NotificationItemBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var NavController:NavController=findNavController(R.id.fragmentContainerView)
        var botomav=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        botomav.setupWithNavController(NavController)
        binding.notifications.setOnClickListener{
            val bottomSheetDialog=notificationbottom_fragment()
            bottomSheetDialog.show(supportFragmentManager,"Test")
        }
    }
}