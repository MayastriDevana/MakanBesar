package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.response_model.JapaneseResponseModel
import com.example.makanbesar.data.MakanBesarService
import retrofit2.Response
import javax.inject.Inject

class JapaneseRemoteDatasourceImpl  @Inject constructor(
    val service: MakanBesarService
) :
   JapaneseRemoteDatasource {
    override suspend fun getJapanese(): Response<JapaneseResponseModel> {
        return service.getJapanese()
    }


}