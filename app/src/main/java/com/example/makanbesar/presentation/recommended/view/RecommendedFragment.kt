package com.example.bcasyariah.com.example.makanbesar.presentation.home_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.bcasyariah.com.example.makanbesar.base.BaseFragment
import com.example.bcasyariah.com.example.makanbesar.data.response_model.Recommended
import com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.adapter.RecommendedAdapter
import com.example.bcasyariah.com.example.makanbesar.presentation.recommended.view_model.RecommendedViewModel
import com.example.makanbesar.databinding.FragmentRecommendedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecommendedFragment : BaseFragment<FragmentRecommendedBinding>() {

    private val viewModel: RecommendedViewModel by viewModels()
    private lateinit var recommendedAdapter: RecommendedAdapter
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRecommendedBinding {
        return FragmentRecommendedBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

        viewModel.getRecommended()
        observeViewModel()
    }

    private fun observeViewModel(){
        viewModel.recommended.observe(viewLifecycleOwner){
            setupViewRecommended(it.recommended)
        }
    }
    private fun setupViewRecommended(data: List<Recommended>){
        binding.componentRecommended.rvRecommended.adapter = RecommendedAdapter(data)
    }

}

