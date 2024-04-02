package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.response_model.RecommendedResponseModel
import com.example.makanbesar.data.MakanBesarService
import retrofit2.Response
import javax.inject.Inject

class RecommendedRemoteDatasourceImpl  @Inject constructor(
    val service: MakanBesarService
) :
    RecommendedRemoteDatasource {
    override suspend fun getRecommended(): Response<RecommendedResponseModel> {
        return service.getRecommended()
    }


}