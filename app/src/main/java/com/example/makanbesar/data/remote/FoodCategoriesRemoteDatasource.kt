package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.model.FoodCategoriesResponseModel
import retrofit2.Response

interface FoodCategoriesRemoteDatasource {
    suspend fun getFoodCategories() : Response<FoodCategoriesResponseModel>
}