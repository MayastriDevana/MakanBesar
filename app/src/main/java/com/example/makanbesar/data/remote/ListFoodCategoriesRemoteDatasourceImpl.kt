package com.example.bcasyariah.com.example.makanbesar.data.remote

import com.example.bcasyariah.com.example.makanbesar.data.response_model.ListFoodCategoriesResponseModel
import com.example.makanbesar.data.MakanBesarService
import retrofit2.Response
import javax.inject.Inject

class ListFoodCategoriesRemoteDatasourceImpl  @Inject constructor(
    val service: MakanBesarService
) :
    ListFoodCategoriesRemoteDatasource {
    override suspend fun getListFoodCategoriesBeef(): Response<ListFoodCategoriesResponseModel> {
        return service.getListFoodCategories("Beef")
    }

    override suspend fun getListFoodCategoriesChicken(): Response<ListFoodCategoriesResponseModel> {
        return service.getListFoodCategories("Chicken")
    }

    override suspend fun getListFoodCategoriesGoat(): Response<ListFoodCategoriesResponseModel> {
        return service.getListFoodCategories("Goat")
    }

}