package com.example.bcasyariah.com.example.makanbesar.data.response_model

import com.google.gson.annotations.SerializedName

data class RecommendedResponseModel(
    @SerializedName("meals")
    val recommended: List<Recommended>
)

data class Recommended(
    @SerializedName("strMealThumb")
    val strMealThumb : String?,
    @SerializedName("strMeal")
    val strMeal: String?,
)