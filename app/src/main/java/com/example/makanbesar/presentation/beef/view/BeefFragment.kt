package com.example.bcasyariah.com.example.makanbesar.presentation.beef.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.bcasyariah.com.example.makanbesar.base.BaseFragment
import com.example.bcasyariah.com.example.makanbesar.data.response_model.BeefResponseModel
import com.example.bcasyariah.com.example.makanbesar.presentation.beef.view_model.BeefViewModel
import com.example.makanbesar.databinding.FragmentBeefBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BeefFragment : BaseFragment<FragmentBeefBinding>() {
    private val viewModelBeef: BeefViewModel by viewModels()
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBeefBinding {
        return FragmentBeefBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        viewModelBeef.getBeef()
        observeViewModel()

    }

    private fun observeViewModel() {
        viewModelBeef.beef.observe(viewLifecycleOwner) {
            setupViewBeef(it)
        }
    }

    private fun setupViewBeef(data: BeefResponseModel) {
        binding.itemBeef.tvBeef.text = data.beef[0].strMeal
        Glide
            .with(this)
            .load(data.beef[0].strMealThumb)
            .centerCrop()
            .into(binding.itemBeef.ivBeef)
        binding.itemBeef.tvIngredientDetail1.text = data.beef[0].strIngredient1
        binding.itemBeef.tvIngredientDetail2.text = data.beef[0].strIngredient2
        binding.itemBeef.tvIngredientDetail3.text = data.beef[0].strIngredient3
        binding.itemBeef.tvInstructionBeef.text = data.beef[0].strInstructions
    }

}