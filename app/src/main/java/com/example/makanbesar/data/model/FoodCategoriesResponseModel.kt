package com.example.bcasyariah.com.example.makanbesar.data.model

import com.google.gson.annotations.SerializedName

data class FoodCategoriesResponseModel(
    @SerializedName("categories")
    val categories: List<Categories>
)

data class Categories(
    @SerializedName("idCategory")
    val idCategory : String?,
    @SerializedName("strCategory")
    val strCategory: String?,
    @SerializedName("strCategoryThumb")
    val strCategoryThumb: String?,
    @SerializedName("strCategoryDescription")
    val strCategoryDescription: String?
)