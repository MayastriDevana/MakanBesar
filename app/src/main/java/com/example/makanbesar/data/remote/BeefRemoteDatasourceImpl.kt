package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.response_model.BeefResponseModel
import com.example.makanbesar.data.MakanBesarService
import retrofit2.Response
import javax.inject.Inject

class BeefRemoteDatasourceImpl  @Inject constructor(
    val service: MakanBesarService
) :
    BeefRemoteDatasource {
    override suspend fun getBeef(): Response<BeefResponseModel> {
        return service.getBeef()
    }
}