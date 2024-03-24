package com.example.wavesoffood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RemoteViews.RemoteCollectionItems
import androidx.recyclerview.widget.RecyclerView
import com.denzcoskun.imageslider.ImageSlider
import com.example.wavesoffood.databinding.PopularItemBinding
import com.example.wavesoffood.detailActivity

class popularadapter(private val items:List<String>,private val price:List<String>,private val image:List<Int>,private val requiredcontext:Context ) : RecyclerView.Adapter<popularadapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        return PopularViewHolder(PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }



    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
       val item=items[position]
        val price=price[position]
        val images=image[position]
        holder.bind(item,price,images)
        holder.itemView.setOnClickListener{
            val intent = Intent(requiredcontext, detailActivity::class.java)
            intent.putExtra("MenuItemName",item)
            intent.putExtra("Menuitemimage",images)
            requiredcontext.startActivity(intent)
        }
    }
    override fun getItemCount(): Int {
       return items.size
    }
class PopularViewHolder (private val binding: PopularItemBinding):RecyclerView.ViewHolder(binding.root){
  private  val imagesView =binding.imagepopular
    fun bind(item: String,price: String, images: Int) {
        binding.foodNamePopular.text=item
        binding.PricePopular.text=price
        imagesView.setImageResource(images)
    }

}
}