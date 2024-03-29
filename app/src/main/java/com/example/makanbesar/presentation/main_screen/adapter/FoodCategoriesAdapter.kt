package com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bcasyariah.com.example.makanbesar.data.model.Categories
import com.example.makanbesar.databinding.ItemMainBinding


class FoodCategoriesAdapter (
    private val data:List<Categories>
): RecyclerView.Adapter<FoodCategoriesAdapter.MainViewHolder> () {


    inner class MainViewHolder(
        val binding: ItemMainBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(mainModel: Categories){
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(mainModel.strCategoryThumb)
                    .centerCrop()
                    .into(binding.ivhome)
            };
            binding.tvhome.text = mainModel.strCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            ItemMainBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(data[position])

    }

}