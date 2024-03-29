package com.example.makanbesar.data

import com.example.bcasyariah.com.example.makanbesar.data.model.FoodCategoriesResponseModel

import retrofit2.Response
import retrofit2.http.GET

interface MakanBesarService {
    @GET("/api/json/v1/1/categories.php")
    suspend fun getFoodCategories() : Response<FoodCategoriesResponseModel>
}