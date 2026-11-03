package com.example.kopidannyemil.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.kopidannyemil.MenuItem
import com.example.kopidannyemil.databinding.ItemMenuBinding
import com.example.kopidannyemil.viewmodel.MainViewModel

class MenuAdapter(
    private val itemList: List<MenuItem>,
    private val viewModel: MainViewModel
) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    inner class MenuViewHolder(val binding: ItemMenuBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        val item = itemList[position]
        with(holder.binding) {
            tvMenuName.text = item.name
            tvMenuDesc.text = item.description
            tvMenuPrice.text = viewModel.formatRupiah(item.price)

            imgCup.setImageResource(item.imageResId)
        }
    }

    override fun getItemCount(): Int = itemList.size
}