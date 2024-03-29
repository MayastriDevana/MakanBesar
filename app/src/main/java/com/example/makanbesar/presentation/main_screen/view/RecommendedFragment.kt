package com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasyariah.com.example.makanbesar.base.BaseFragment
import com.example.makanbesar.databinding.FragmentFavoriteBinding
import com.example.makanbesar.databinding.FragmentRecomendedBinding

class RecommendedFragment : BaseFragment<FragmentRecomendedBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRecomendedBinding {
        return FragmentRecomendedBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }
}