package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.response_model.FavoriteMealsResponseModel
import com.example.makanbesar.data.MakanBesarService
import retrofit2.Response
import javax.inject.Inject

class FavoriteMealsRemoteDatasourceImpl  @Inject constructor(
    val service: MakanBesarService
) :
    FavoriteMealsRemoteDatasource {
    override suspend fun getFavoriteMeals(): Response<FavoriteMealsResponseModel> {
        return service.getFavoriteMeals()
    }


}