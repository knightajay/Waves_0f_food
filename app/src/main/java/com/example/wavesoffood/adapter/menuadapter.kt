package com.example.wavesoffood.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.MenuItemBinding
import com.example.wavesoffood.detailActivity

class menuadapter(private val menuItemsname: List<String>, private val menuprice:MutableList<String>, private val MenuImage:MutableList<Int>,private val requiredcontext:Context):RecyclerView.Adapter<menuadapter.MenuViewHolder>() {

private val itemsclickListener:OnClickListener?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): menuadapter.MenuViewHolder {
       val binding=MenuItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
return MenuViewHolder(binding)}
    override fun onBindViewHolder(holder: menuadapter.MenuViewHolder, position: Int) {
     holder.bind(position)
    }

    override fun getItemCount(): Int =menuItemsname.size
    inner class MenuViewHolder(private val binding: MenuItemBinding):RecyclerView.ViewHolder(binding.root){
        init {
            binding.root.setOnClickListener{
                val position=adapterPosition
                if(position!=RecyclerView.NO_POSITION){
                    itemsclickListener?.onItemsClick(position)
                }
                //set on click listener for open food detail;

                val intent =Intent(requiredcontext,detailActivity::class.java)
                intent.putExtra("MenuItemName",menuItemsname.get(position))
                intent.putExtra("Menuitemimage",MenuImage.get(position))
                requiredcontext.startActivity(intent)
            }
        }
        fun bind(position: Int) {
            binding.apply {
                menufoodNamePopular.text=menuItemsname[position]
                menuPricePopular.text=menuprice[position]
                menuimage.setImageResource(MenuImage[position])


            }
        }

    }
interface OnClickListener{
    fun onItemsClick(position: Int)

}
}



