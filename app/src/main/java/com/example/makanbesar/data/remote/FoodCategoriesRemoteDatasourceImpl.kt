package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.model.FoodCategoriesResponseModel
import com.example.makanbesar.data.MakanBesarService
import retrofit2.Response
import javax.inject.Inject

class FoodCategoriesRemoteDatasourceImpl  @Inject constructor(
    val service: MakanBesarService
) :
    FoodCategoriesRemoteDatasource {
    override suspend fun getFoodCategories(): Response<FoodCategoriesResponseModel> {
        return service.getFoodCategories()
    }


}