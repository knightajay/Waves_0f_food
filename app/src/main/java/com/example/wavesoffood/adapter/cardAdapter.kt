package com.example.wavesoffood.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.CardItemBinding

class cardAdapter(private val carditems:MutableList<String>,private val carditemsprice:MutableList<String>,private val cardimage:MutableList<Int>): RecyclerView.Adapter<cardAdapter.CardViewHolder>() {
private val itemQuantities=IntArray(carditems.size){1}
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val binding=CardItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        holder.bind(position)
    }
    override fun getItemCount(): Int=carditems.size

    inner class CardViewHolder(private val binding: CardItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
          binding.apply {
              val quantity =itemQuantities[position]
            cardFoodName.text=carditems[position]
          cardItemPrice.text=carditemsprice[position]
cardImage.setImageResource(cardimage[position])
              carditemquantity.text=quantity.toString()
negativeButton.setOnClickListener {
   decreasequantity(position)
}
              plusButton.setOnClickListener {
                  increasequantity(position)
              }
              deleteButton.setOnClickListener {
                  val itemposition=adapterPosition
                  if(itemposition!=RecyclerView.NO_POSITION){
                      deleteitems(itemposition)
                  }
              }
          }
        }
       private fun decreasequantity(position: Int){
            if(itemQuantities[position]>1){
                itemQuantities[position]--
                binding.carditemquantity.text=itemQuantities[position].toString()
            }
        }
        private fun increasequantity(position: Int){
            if(itemQuantities[position]<10){
                itemQuantities[position]++
                binding.carditemquantity.text=itemQuantities[position].toString()
            }
        }
        private fun deleteitems(position: Int){
            carditems.removeAt(position)
            cardimage.removeAt(position)
            carditemsprice.removeAt(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(position,carditems.size)
        }
    }

}