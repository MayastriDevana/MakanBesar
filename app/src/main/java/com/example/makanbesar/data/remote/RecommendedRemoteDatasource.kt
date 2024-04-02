package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.response_model.FavoriteMealsResponseModel
import com.example.bcasyariah.com.example.makanbesar.data.response_model.RecommendedResponseModel
import retrofit2.Response

interface RecommendedRemoteDatasource {
    suspend fun getRecommended() : Response<RecommendedResponseModel>
}