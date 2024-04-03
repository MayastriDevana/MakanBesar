package com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bcasyariah.com.example.makanbesar.data.response_model.ListFoodCategories
import com.example.makanbesar.databinding.ItemListFoodCategoriesBinding


class ListFoodCategoriesBeefAdapter (
    private val data:List<ListFoodCategories>
): RecyclerView.Adapter<ListFoodCategoriesBeefAdapter. ListFoodCategoriesViewHolder> () {


    inner class  ListFoodCategoriesViewHolder(
        val binding: ItemListFoodCategoriesBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind( listFoodCategoriesModel: ListFoodCategories){
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(listFoodCategoriesModel.strMealThumb)
                    .centerCrop()
                    .into(binding.ivListFC)
            };
            binding.tvListFC.text = listFoodCategoriesModel.strMeal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListFoodCategoriesViewHolder {
        return ListFoodCategoriesViewHolder(
            ItemListFoodCategoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: ListFoodCategoriesViewHolder, position: Int) {
        holder.bind(data[position])

    }

}