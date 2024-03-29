package com.example.bcasyariah.com.example.makanbesar.presentation.main_screen.view

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasyariah.com.example.makanbesar.base.BaseFragment
import com.example.makanbesar.databinding.FragmentFavoriteBinding

class FavoriteFragment : BaseFragment<FragmentFavoriteBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoriteBinding {
        return FragmentFavoriteBinding.inflate(inflater, container, false)
    }

    override fun setupView() {

    }
}