package com.example.bcasyariah.com.example.makanbesar.data.response_model

import com.google.gson.annotations.SerializedName

data class ListFoodCategoriesResponseModel(
    @SerializedName("meals")
    val meals: List<ListFoodCategories>
)

data class ListFoodCategories(
    @SerializedName("strMealThumb")
    val strMealThumb: String?,
    @SerializedName("strMeal")
    val strMeal: String?,
    @SerializedName("idMeal")
    val idMeal: String?
)
