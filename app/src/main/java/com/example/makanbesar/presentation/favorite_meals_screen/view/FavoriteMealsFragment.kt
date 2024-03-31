package com.example.bcasyariah.com.example.makanbesar.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bcasyariah.com.example.makanbesar.base.BaseFragment
import com.example.bcasyariah.com.example.makanbesar.data.response_model.Japanese
import com.example.bcasyariah.com.example.makanbesar.data.response_model.Meals
import com.example.bcasyariah.com.example.makanbesar.presentation.favorite_screen.adapter.FavoriteMealsAdapter
import com.example.bcasyariah.com.example.makanbesar.presentation.favorite_screen.adapter.JapaneseAdapter
import com.example.bcasyariah.com.example.makanbesar.presentation.favorite_screen.view_model.FavoriteMealsViewModel
import com.example.makanbesar.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FavoriteMealsFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val viewModel: FavoriteMealsViewModel by viewModels()
    private lateinit var favoriteMealsAdapter: FavoriteMealsAdapter
    private lateinit var japaneseAdapter: JapaneseAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

        viewModel.getFavoriteMeals()
        viewModel.getJapanese()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.favoriteMeals.observe(viewLifecycleOwner){
            setupViewFavoriteMeals(it.meals)
        }

        viewModel.japanese.observe(viewLifecycleOwner){
            setupViewJapanese(it.japanese)
        }

    }

    private fun setupViewFavoriteMeals(favoritedata: List<Meals>){
        favoriteMealsAdapter = FavoriteMealsAdapter(
            data = favoritedata ?: listOf()
        )

        binding.componentFavorite.rvFavoriteMeals.adapter = favoriteMealsAdapter

    }
    private fun setupViewJapanese(data: List<Japanese>){
        japaneseAdapter = JapaneseAdapter(
            data = data ?: listOf()
        )
        binding.componentJapanese.rvJapanese.adapter = japaneseAdapter

    }

}

