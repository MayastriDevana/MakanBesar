package com.example.bcasyariah.com.example.makanbesar.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bcasyariah.com.example.makanbesar.base.BaseFragment
import com.example.bcasyariah.com.example.makanbesar.data.response_model.Categories
import com.example.bcasyariah.com.example.makanbesar.presentation.beef.view.BeefFragment
import com.example.bcasyariah.com.example.makanbesar.presentation.beef.view_model.BeefViewModel
import com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.adapter.FoodCategoriesAdapter
import com.example.makanbesar.R
import com.example.makanbesar.databinding.FragmentFoodCategoriesBinding
import com.example.makanbesar.presentation.food_categories_screen.view_model.FoodCategoriesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FoodCategoriesFragment : BaseFragment<FragmentFoodCategoriesBinding>() {

    private val viewModel: FoodCategoriesViewModel by viewModels()


    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFoodCategoriesBinding {
        return FragmentFoodCategoriesBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

        viewModel.getFoodCategories()

        observeViewModel()

    }

    private fun observeViewModel() {
        viewModel.foodCategories.observe(viewLifecycleOwner) {
            setupViewFoodCategories(it.categories)
        }

    }

    private fun setupViewFoodCategories(data: List<Categories>) {
        val itemClickListener = object : FoodCategoriesAdapter.OnFoodCategoriesClickListener {
            override fun onItemClick(categories: Categories) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.fragmentContainer, BeefFragment())
                    .addToBackStack(null)
                    .commit()
            }
        }
        binding.componentAllCategoriesHome.gridMenu.adapter =
            FoodCategoriesAdapter(data, itemClickListener)
    }

}

