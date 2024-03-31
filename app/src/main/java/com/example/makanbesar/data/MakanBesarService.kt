package com.example.makanbesar.data

import com.example.bcasyariah.com.example.makanbesar.data.response_model.FavoriteMealsResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.FoodCategoriesResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.JapaneseResponseModel

import retrofit2.Response
import retrofit2.http.GET

interface MakanBesarService {
    @GET("/api/json/v1/1/categories.php")
    suspend fun getFoodCategories() : Response<FoodCategoriesResponseModel>

    @GET("/api/json/v1/1/filter.php?a=Canadian")
    suspend fun getFavoriteMeals() : Response<FavoriteMealsResponseModel>

    @GET("/api/json/v1/1/filter.php?a=Japanese")
    suspend fun getJapanese() : Response<JapaneseResponseModel>
}