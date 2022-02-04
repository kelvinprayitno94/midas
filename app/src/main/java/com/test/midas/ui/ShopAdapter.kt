package com.test.midas.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.test.midas.databinding.AdapterMenuBinding
import com.test.midas.model.Menus

class ShopAdapter: RecyclerView.Adapter<ShopViewHolder>() {

    private val menus: MutableList<Menus> = mutableListOf()

    fun updateList(_menu: List<Menus>){
        menus.clear()
        menus.addAll(_menu)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopViewHolder {
        val binding = AdapterMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ShopViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShopViewHolder, position: Int) {
        holder.bindView(menus[position])
    }

    override fun getItemCount(): Int = menus.size
}

class ShopViewHolder(private val binding: AdapterMenuBinding): RecyclerView.ViewHolder(binding.root){
    fun bindView(menu: Menus){
        binding.textViewInd.text = menu.ind
        binding.textViewPrice.text = "${menu.price}"
        binding.textViewTitle.text = menu.title
        binding.textViewDiscPrice.text = "${menu.discPrice}"

    }
}
