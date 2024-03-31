package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.response_model.FavoriteMealsResponseModel
import retrofit2.Response

interface FavoriteMealsRemoteDatasource {
    suspend fun getFavoriteMeals() : Response<FavoriteMealsResponseModel>
}