package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.BuyAgainItemBinding

class BuyAgainAdapter(private val buyAgainFoodname:ArrayList<String>,
                      private val buyagainFoodPrice:ArrayList<String>,
                      private val buyagainfoodimage:ArrayList<Int>):RecyclerView.Adapter<BuyAgainAdapter.BuyAgainViewHolder>() {

    override fun onBindViewHolder(holder: BuyAgainViewHolder, position: Int) {
holder.bind(buyAgainFoodname[position],buyagainFoodPrice[position],buyagainfoodimage[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BuyAgainViewHolder {
        val binding=BuyAgainItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BuyAgainViewHolder(binding)
    }

    override fun getItemCount(): Int =buyAgainFoodname.size

    class BuyAgainViewHolder(private val binding: BuyAgainItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(foodname: String, foodprice:String, foodimage: Int) {
            binding.buyAginFoodNmae.text=foodname
            binding.buyAgainFoodPrice.text=foodprice
            binding.buyAgainFoodImage.setImageResource(foodimage)
        }

    }



}