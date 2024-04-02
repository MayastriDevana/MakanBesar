package com.example.bcasyariah.com.example.makanbesar.data.response_model

import com.google.gson.annotations.SerializedName

data class JapaneseResponseModel(
    @SerializedName("meals")
    val japanese: List<Japanese>
)

data class Japanese(
    @SerializedName("strMeal")
    val strMeal : String?,
    @SerializedName("strMealThumb")
    val strMealThumb: String?,
    @SerializedName("idMeal")
    val idMeal: String?
)