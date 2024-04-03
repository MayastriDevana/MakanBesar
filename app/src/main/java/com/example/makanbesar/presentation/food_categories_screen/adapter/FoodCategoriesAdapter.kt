package com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bcasyariah.com.example.makanbesar.data.response_model.Categories
import com.example.makanbesar.databinding.ItemFoodCategoriesBinding


class FoodCategoriesAdapter (
    private val data:List<Categories>,
    private val itemClickListener: OnFoodCategoriesClickListener

): RecyclerView.Adapter<FoodCategoriesAdapter.FoodCategoriesViewHolder> () {


    inner class FoodCategoriesViewHolder(
        val binding: ItemFoodCategoriesBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(foodCategoriesModel: Categories){
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(foodCategoriesModel.strCategoryThumb)
                    .centerCrop()
                    .into(binding.ivhome)
            };
            binding.tvhome.text = foodCategoriesModel.strCategory
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodCategoriesViewHolder {
        return FoodCategoriesViewHolder(
            ItemFoodCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: FoodCategoriesViewHolder, position: Int) {
        val currentItem = data[position]
        holder.bind(currentItem)

        holder.itemView.setOnClickListener{
            itemClickListener.onItemClick(currentItem)
        }


    }
    interface OnFoodCategoriesClickListener{
        fun onItemClick(categories: Categories)
    }



}