package com.example.bcasyariah.com.example.makanbesar.data.response_model

import com.google.gson.annotations.SerializedName

data class FavoriteMealsResponseModel(
    @SerializedName("meals")
    val meals: List<Meals>
)

data class Meals(
    @SerializedName("strMeal")
    val strMeal : String?,
    @SerializedName("strMealThumb")
    val strMealThumb: String?,
    @SerializedName("idMeal")
    val idMeal: String?
)