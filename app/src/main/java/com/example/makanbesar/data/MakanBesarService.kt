package com.example.makanbesar.data

import com.example.bcasyariah.com.example.makanbesar.data.response_model.BeefResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.DetailListFoodCategoriesResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.FavoriteMealsResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.FoodCategoriesResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.JapaneseResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.ListFoodCategories
import com.example.bcasyariah.com.example.makanbesar.data.response_model.ListFoodCategoriesResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.RecommendedResponseModel

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MakanBesarService {
    @GET("/api/json/v1/1/categories.php")
    suspend fun getFoodCategories() : Response<FoodCategoriesResponseModel>

    @GET("/api/json/v1/1/filter.php?a=Canadian")
    suspend fun getFavoriteMeals() : Response<FavoriteMealsResponseModel>

    @GET("/api/json/v1/1/filter.php?a=Japanese")
    suspend fun getJapanese() : Response<JapaneseResponseModel>

    @GET("/api/json/v1/1/search.php?f=a")
    suspend fun getRecommended() : Response<RecommendedResponseModel>

    @GET("/api/json/v1/1/search.php?s=Mustard%20Pie")
    suspend fun getBeef() : Response<BeefResponseModel>

    @GET("/api/json/v1/1/filter.php?")
    suspend fun  getListFoodCategories(
        @Query ("c") categories: String
    ) : Response<ListFoodCategoriesResponseModel>

    @GET("api/json/v1/1/lookup.php?")
    suspend fun getDetailListFoodCategories(
        @Query ("i") ingredient: String
    ) : Response<DetailListFoodCategoriesResponseModel>
}