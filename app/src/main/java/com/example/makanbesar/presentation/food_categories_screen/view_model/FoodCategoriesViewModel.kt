package com.example.makanbesar.presentation.food_categories_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasyariah.com.example.makanbesar.data.response_model.FoodCategoriesResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.remote.FoodCategoriesRemoteDatasource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel: Ini adalah anotasi yang menandakan bahwa kelas HomeViewModel adalah ViewModel yang akan diinjeksikan oleh Hilt. Ketika Anda menggunakan @HiltViewModel, Anda tidak perlu lagi menyediakan ViewModelProvider.Factory karena Hilt secara otomatis akan menangani pembuatan instance ViewModel dan menyediakan dependencies yang diperlukan ke dalam konstruktor ViewModel.

// @Inject: Ini adalah anotasi yang menandai konstruktor kelas HomeViewModel. Hilt akan memastikan bahwa instance dari CurrentWeatherRemote akan disediakan dan disuntikkan ke dalam konstruktor HomeViewModel saat membuat instance ViewModel.

@HiltViewModel
class FoodCategoriesViewModel @Inject constructor(
    private val foodCategoriesRemoteDatasource: FoodCategoriesRemoteDatasource
): ViewModel() {

    // setter
    private val _foodCategories= MutableLiveData<FoodCategoriesResponseModel>()
    private val _foodCategoriesError = MutableLiveData<String>()
    // getter
    val foodCategories: LiveData<FoodCategoriesResponseModel>
        get() = _foodCategories


    val foodCategoriesError: LiveData<String>
        get() = _foodCategoriesError


    fun getFoodCategories() = viewModelScope.launch(Dispatchers.IO){
        foodCategoriesRemoteDatasource.getFoodCategories().let {
            if (it.isSuccessful){
                _foodCategories.postValue(it.body())
            } else{
                _foodCategoriesError.postValue(it.message())
            }
        }
    }

}