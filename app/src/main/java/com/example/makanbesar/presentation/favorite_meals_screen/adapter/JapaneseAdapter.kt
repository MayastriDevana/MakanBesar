package com.example.bcasyariah.com.example.makanbesar.presentation.favorite_screen.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.bcasyariah.com.example.makanbesar.data.response_model.Japanese
import com.example.makanbesar.databinding.ItemJapaneseBinding


class JapaneseAdapter (
    private val data:List<Japanese>
): RecyclerView.Adapter<JapaneseAdapter.JapaneseViewHolder> () {


    inner class JapaneseViewHolder(
        val binding: ItemJapaneseBinding
    ): RecyclerView.ViewHolder(binding.root){
        fun bind(japanese: Japanese){
            binding.root.context?.let {
                Glide
                    .with(it)
                    .load(japanese.strMealThumb)
                    .centerCrop()
                    .into(binding.ivJapanese)
            };
            binding.tvJapanese.text = japanese.strMeal
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JapaneseViewHolder {
        return JapaneseViewHolder(
            ItemJapaneseBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: JapaneseViewHolder, position: Int) {
        holder.bind(data[position])

    }

}