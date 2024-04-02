package com.example.bcasyariah.com.example.makanbesar.presentation.recommended.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasyariah.com.example.makanbesar.data.response_model.FoodCategoriesResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.remote.FoodCategoriesRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.RecommendedRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.response_model.RecommendedResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel: Ini adalah anotasi yang menandakan bahwa kelas HomeViewModel adalah ViewModel yang akan diinjeksikan oleh Hilt. Ketika Anda menggunakan @HiltViewModel, Anda tidak perlu lagi menyediakan ViewModelProvider.Factory karena Hilt secara otomatis akan menangani pembuatan instance ViewModel dan menyediakan dependencies yang diperlukan ke dalam konstruktor ViewModel.

// @Inject: Ini adalah anotasi yang menandai konstruktor kelas HomeViewModel. Hilt akan memastikan bahwa instance dari CurrentWeatherRemote akan disediakan dan disuntikkan ke dalam konstruktor HomeViewModel saat membuat instance ViewModel.

@HiltViewModel
class RecommendedViewModel @Inject constructor(
    private val recommendedRemoteDatasource: RecommendedRemoteDatasource
): ViewModel() {

    // setter
    private val _recommended= MutableLiveData<RecommendedResponseModel>()
    private val _recommendedError = MutableLiveData<String>()
    // getter
    val recommended: LiveData<RecommendedResponseModel>
        get() = _recommended


    val recommendedError: LiveData<String>
        get() = _recommendedError


    fun getRecommended() = viewModelScope.launch(Dispatchers.IO){
        recommendedRemoteDatasource.getRecommended().let {
            if (it.isSuccessful){
                _recommended.postValue(it.body())
            } else{
                _recommendedError.postValue(it.message())
            }
        }
    }

}