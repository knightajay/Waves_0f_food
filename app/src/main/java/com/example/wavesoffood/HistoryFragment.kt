package com.example.wavesoffood

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.adapter.BuyAgainAdapter
import com.example.wavesoffood.databinding.FragmentHistoryBinding


class HistoryFragment : Fragment() {

private lateinit var binding: FragmentHistoryBinding
private lateinit var buyAgainAdapter: BuyAgainAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentHistoryBinding.inflate(layoutInflater,container,false)
        setupRecyclerView()
        return binding.root
    }
    private fun setupRecyclerView() {
        val buyAgainFoodName = arrayListOf("food 1", "food2", "Food3","food4")
        val buyAgainfoodprice= arrayListOf("$4","$10","$11","$12")
        val buyAgainfoodimage= arrayListOf(R.drawable.menup,R.drawable.menupp,R.drawable.menupppp,R.drawable.menuppp)
        buyAgainAdapter= BuyAgainAdapter(buyAgainFoodName,buyAgainfoodprice,buyAgainfoodimage)
        binding.buyAgainRecylerView.adapter=buyAgainAdapter
        binding.buyAgainRecylerView.layoutManager=LinearLayoutManager(requireContext())
    }

    companion object {

                }
            }

