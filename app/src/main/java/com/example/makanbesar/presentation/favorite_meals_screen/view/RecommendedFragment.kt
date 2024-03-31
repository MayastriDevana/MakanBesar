package com.example.bcasyariah.com.example.makanbesar.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bcasyariah.com.example.makanbesar.base.BaseFragment
import com.example.bcasyariah.com.example.makanbesar.data.response_model.Categories
import com.example.bcasyariah.com.example.makanbesar.data.response_model.Meals
import com.example.bcasyariah.com.example.makanbesar.presentation.favorite_screen.adapter.FavoriteMealsAdapter
import com.example.bcasyariah.com.example.makanbesar.presentation.favorite_screen.view_model.FavoriteMealsViewModel
import com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.adapter.FoodCategoriesAdapter
import com.example.makanbesar.databinding.FragmentFavoriteBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendedFragment : BaseFragment<FragmentFavoriteBinding>() {

    private val viewModel: FavoriteMealsViewModel by viewModels()
    private lateinit var favoriteMealsAdapter: FavoriteMealsAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

        viewModel.getFavoriteMeals()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.favoriteMeals.observe(viewLifecycleOwner){
            setupViewFavoriteMeals(it.meals)
        }
    }
    private fun setupViewFavoriteMeals(data: List<Meals>){
        binding.componentFavorite.rvFavoriteMeals.adapter = FavoriteMealsAdapter(data)

    }

}

