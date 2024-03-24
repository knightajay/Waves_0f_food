package com.example.wavesoffood

import android.app.Notification
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.adapter.notificationAdapter
import com.example.wavesoffood.databinding.FragmentNotificationbottomFragmentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class notificationbottom_fragment : BottomSheetDialogFragment(){
    private lateinit var binding:FragmentNotificationbottomFragmentBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentNotificationbottomFragmentBinding.inflate(layoutInflater,container,false)
        // Inflate the layout for this fragment
        val notifications= listOf("Your order has been Canceled Succesfully","Order has been taken by the driver","Congrate your order placed")
        val notificationimages= listOf(R.drawable.sademoji,R.drawable.icon__10_,R.drawable.illustration)
        val aadapter=notificationAdapter(
            ArrayList(notifications),
            ArrayList(notificationimages)

        )
binding.notificationrecycler.layoutManager=LinearLayoutManager(requireContext())
        binding.notificationrecycler.adapter=aadapter
        return binding.root
    }

    companion object {

                }
            }

