package com.example.bcasyariah.com.example.makanbesar.module

import com.example.bcasyariah.com.example.makanbesar.data.remote.FoodCategoriesRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.FoodCategoriesRemoteDatasourceImpl
import com.example.bcasyariah.com.example.makanbesar.data.remote.ListFoodCategoriesRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.ListFoodCategoriesRemoteDatasourceImpl
import com.example.makanbesar.data.MakanBesarService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ListFoodCategoriesModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDatasource(service: MakanBesarService):
            ListFoodCategoriesRemoteDatasource {
        return ListFoodCategoriesRemoteDatasourceImpl(service)
    }

}