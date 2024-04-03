package com.example.bcasyariah.com.example.makanbesar.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bcasyariah.com.example.makanbesar.base.BaseFragment
import com.example.bcasyariah.com.example.makanbesar.data.response_model.ListFoodCategories
import com.example.bcasyariah.com.example.makanbesar.presentation.list_food_categories.view_model.ListFoodCategoriesBeefViewModel
import com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.adapter.ListFoodCategoriesBeefAdapter
import com.example.makanbesar.databinding.FragmentListFoodCategoriesBeefBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ListFoodCategoriesBeefFragment : BaseFragment<FragmentListFoodCategoriesBeefBinding>() {

    private val viewModel: ListFoodCategoriesBeefViewModel by viewModels()
    private lateinit var listFoodCategoriesBeefAdapter: ListFoodCategoriesBeefAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentListFoodCategoriesBeefBinding {
        return FragmentListFoodCategoriesBeefBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

        viewModel.getListFoodCategoriesBeef()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.listFoodCategoriesBeef.observe(viewLifecycleOwner) {
            setupViewListFoodCategoriesBeef(it.meals)
        }


    }

    private fun setupViewListFoodCategoriesBeef(data: List<ListFoodCategories>) {
        binding.componentListFCBeef.rvListFC.adapter = ListFoodCategoriesBeefAdapter(data)
    }


}

