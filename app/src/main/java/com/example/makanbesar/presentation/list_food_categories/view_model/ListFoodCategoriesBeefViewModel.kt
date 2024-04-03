package com.example.bcasyariah.com.example.makanbesar.presentation.list_food_categories.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasyariah.com.example.makanbesar.data.remote.ListFoodCategoriesRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.response_model.ListFoodCategoriesResponseModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

// @HiltViewModel: Ini adalah anotasi yang menandakan bahwa kelas HomeViewModel adalah ViewModel yang akan diinjeksikan oleh Hilt. Ketika Anda menggunakan @HiltViewModel, Anda tidak perlu lagi menyediakan ViewModelProvider.Factory karena Hilt secara otomatis akan menangani pembuatan instance ViewModel dan menyediakan dependencies yang diperlukan ke dalam konstruktor ViewModel.

// @Inject: Ini adalah anotasi yang menandai konstruktor kelas HomeViewModel. Hilt akan memastikan bahwa instance dari CurrentWeatherRemote akan disediakan dan disuntikkan ke dalam konstruktor HomeViewModel saat membuat instance ViewModel.

@HiltViewModel
class ListFoodCategoriesBeefViewModel @Inject constructor(
    private val listFoodCategoriesRemoteDatasource: ListFoodCategoriesRemoteDatasource
): ViewModel() {

    // setter
    private val _listFoodCategoriesBeef= MutableLiveData<ListFoodCategoriesResponseModel>()

    val listFoodCategoriesBeef: LiveData<ListFoodCategoriesResponseModel>
        get() = _listFoodCategoriesBeef

    private val _listFoodCategoriesBeefError = MutableLiveData<String>()

    val listFoodCategoriesError: LiveData<String>
        get() = _listFoodCategoriesBeefError

    fun getListFoodCategoriesBeef() = viewModelScope.launch(Dispatchers.IO){
        listFoodCategoriesRemoteDatasource.getListFoodCategoriesBeef().let {
            if (it.isSuccessful){
                _listFoodCategoriesBeef.postValue(it.body())
            } else{
                _listFoodCategoriesBeefError.postValue(it.message())
            }
        }
    }

    private val _listFoodCategoriesChicken= MutableLiveData<ListFoodCategoriesResponseModel>()

    val listFoodCategoriesChicken: LiveData<ListFoodCategoriesResponseModel>
        get() = _listFoodCategoriesChicken

    private val _listFoodCategoriesChickenError = MutableLiveData<String>()

    val listFoodCategoriesChickenError: LiveData<String>
        get() = _listFoodCategoriesChickenError

    fun getListFoodCategoriesChicken() = viewModelScope.launch(Dispatchers.IO){
        listFoodCategoriesRemoteDatasource.getListFoodCategoriesChicken().let {
            if (it.isSuccessful){
                _listFoodCategoriesChicken.postValue(it.body())
            } else{
                _listFoodCategoriesChickenError.postValue(it.message())
            }
        }
    }

    private val _listFoodCategoriesGoat= MutableLiveData<ListFoodCategoriesResponseModel>()

    val listFoodCategoriesGoat: LiveData<ListFoodCategoriesResponseModel>
        get() = _listFoodCategoriesGoat

    private val _listFoodCategoriesGoatError = MutableLiveData<String>()

    val listFoodCategoriesGoatError: LiveData<String>
        get() = _listFoodCategoriesGoatError

    fun getListFoodCategoriesGoat() = viewModelScope.launch(Dispatchers.IO){
        listFoodCategoriesRemoteDatasource.getListFoodCategoriesGoat().let {
            if (it.isSuccessful){
                _listFoodCategoriesGoat.postValue(it.body())
            } else{
                _listFoodCategoriesGoatError.postValue(it.message())
            }
        }
    }






}