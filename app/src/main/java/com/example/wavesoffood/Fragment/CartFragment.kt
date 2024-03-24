package com.example.wavesoffood.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.ConcarateBottomShheet
import com.example.wavesoffood.PlayOutActitvity
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.cardAdapter
import com.example.wavesoffood.databinding.CardItemBinding
import com.example.wavesoffood.databinding.FragmentCartBinding


class CartFragment : Fragment() {

private lateinit var binding: FragmentCartBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentCartBinding.inflate(inflater,container,false)



        val cartfoodname= listOf("burger","sandwitch","momos","Items","samosaa")
        val carditemprice= listOf("$5","$6","$8","$9","$3")
        val cartimage= listOf(
            R.drawable.menup,
            R.drawable.menupppp,
            R.drawable.menuppppp,
            R.drawable.menupp,
            R.drawable.menuppp,
        )
        val adapter=cardAdapter(ArrayList(cartfoodname),ArrayList(carditemprice),ArrayList(cartimage))
        binding.cardRecyclerView.layoutManager=LinearLayoutManager(requireContext())
        binding.cardRecyclerView.adapter=adapter
        binding.proceedButton.setOnClickListener{
            val intent=Intent(requireContext(),PlayOutActitvity::class.java)
            startActivity(intent)
        }



       return binding.root
    }

    companion object {

    }
}
