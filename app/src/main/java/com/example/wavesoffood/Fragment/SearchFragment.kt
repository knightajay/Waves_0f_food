package com.example.wavesoffood.Fragment

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.menuadapter
import com.example.wavesoffood.databinding.FragmentSearchBinding
//import com.google.android.material.search.SearchView
import android.widget.SearchView
class SearchFragment : Fragment() {
    private lateinit var binding:FragmentSearchBinding
    private lateinit var adapter:menuadapter
    private val originalmenufoodname:List<String> = listOf("burger","sandwitch","momos","Items","samosaa","burger","sandwitch","momos","Items","samosaa")
    private val originalmenuitemprice :List<String> = listOf("$5","$6","$8","$9","$3","$5","$6","$8","$9","$3")
    private val originalmenuimage:List<Int> = listOf(
        R.drawable.menup,
        R.drawable.menupppp,
        R.drawable.menuppppp,
        R.drawable.menupp,
        R.drawable.menuppp,
        R.drawable.menup,
        R.drawable.menupppp,
        R.drawable.menuppppp,
        R.drawable.menupp,
        R.drawable.menuppp,
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filterMenuFoodName= mutableListOf<String>()
    private val filterMenuFoodprice= mutableListOf<String>()
    private val filterMenuFoodimage= mutableListOf<Int>()

    //
    @SuppressLint("RestrictedApi")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=FragmentSearchBinding.inflate(inflater,container,false)
        adapter= menuadapter(filterMenuFoodName,filterMenuFoodprice,filterMenuFoodimage,requireContext())
        binding.menurecyclerview.layoutManager=LinearLayoutManager(requireContext())
        binding.menurecyclerview.adapter=adapter
        //setup for search view
        setupSearchView()
        //show all menu item
        showAllMenu()
        return binding.root
    }

    private fun showAllMenu() {
        filterMenuFoodName.clear()
        filterMenuFoodprice.clear()
        filterMenuFoodimage.clear()
        filterMenuFoodName.addAll(originalmenufoodname)
        filterMenuFoodprice.addAll(originalmenuitemprice)
        filterMenuFoodimage.addAll(originalmenuimage)
        adapter.notifyDataSetChanged()
    }
    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(/* listener = */ object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    filterMenuItems(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    filterMenuItems(it)
                }
                return true
            }
        })
    }
    private fun filterMenuItems(query: String) {
        filterMenuFoodName.clear()
        filterMenuFoodprice.clear()
        filterMenuFoodimage.clear()
        originalmenufoodname.forEachIndexed{index, foodName -> if(foodName.contains(query, ignoreCase = true)) {
            filterMenuFoodName.add(foodName)
            filterMenuFoodprice.add(originalmenuitemprice[index])
            filterMenuFoodimage.add(originalmenuimage[index])
        } }
        adapter.notifyDataSetChanged()
    }


    companion object {

    }

}
