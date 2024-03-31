package com.example.bcasyariah.com.example.makanbesar.presentation.favorite_screen.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasyariah.com.example.makanbesar.data.remote.FavoriteMealsRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.JapaneseRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.response_model.FavoriteMealsResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.JapaneseResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel: Ini adalah anotasi yang menandakan bahwa kelas HomeViewModel adalah ViewModel yang akan diinjeksikan oleh Hilt. Ketika Anda menggunakan @HiltViewModel, Anda tidak perlu lagi menyediakan ViewModelProvider.Factory karena Hilt secara otomatis akan menangani pembuatan instance ViewModel dan menyediakan dependencies yang diperlukan ke dalam konstruktor ViewModel.

// @Inject: Ini adalah anotasi yang menandai konstruktor kelas HomeViewModel. Hilt akan memastikan bahwa instance dari CurrentWeatherRemote akan disediakan dan disuntikkan ke dalam konstruktor HomeViewModel saat membuat instance ViewModel.

@HiltViewModel
class FavoriteMealsViewModel @Inject constructor(
    private val favoriteMealsRemoteDatasource: FavoriteMealsRemoteDatasource,
    private val japaneseRemoteDatasource: JapaneseRemoteDatasource

): ViewModel() {

    // setter
    private val _favoriteMeals= MutableLiveData<FavoriteMealsResponseModel>()
    private val _favoriteMealsError = MutableLiveData<String>()
    private val _japanese= MutableLiveData<JapaneseResponseModel>()
    private val _japaneseError = MutableLiveData<String>()
    // getter
    val favoriteMeals: LiveData<FavoriteMealsResponseModel>
        get() = _favoriteMeals


    val foodCategoriesError: LiveData<String>
        get() = _favoriteMealsError

    val japanese: LiveData<JapaneseResponseModel>
        get() = _japanese


    val japaneseError: LiveData<String>
        get() = _japaneseError
    fun getFavoriteMeals() = viewModelScope.launch(Dispatchers.IO){
        favoriteMealsRemoteDatasource.getFavoriteMeals().let {
            if (it.isSuccessful){
                _favoriteMeals.postValue(it.body())
            } else{
                _favoriteMealsError.postValue(it.message())
            }
        }
    }
    fun getJapanese() = viewModelScope.launch(Dispatchers.IO){
        japaneseRemoteDatasource.getJapanese().let {
            if (it.isSuccessful){
                _japanese.postValue(it.body())
            } else{
                _japaneseError.postValue(it.message())
            }
        }
    }

}