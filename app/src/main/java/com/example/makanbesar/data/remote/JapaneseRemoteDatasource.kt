package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.response_model.JapaneseResponseModel
import retrofit2.Response

interface JapaneseRemoteDatasource {
    suspend fun getJapanese() : Response<JapaneseResponseModel>
}