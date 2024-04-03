package com.example.bcasyariah.com.example.makanbesar.module

import com.example.bcasyariah.com.example.makanbesar.data.remote.BeefRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.BeefRemoteDatasourceImpl
import com.example.bcasyariah.com.example.makanbesar.data.remote.FoodCategoriesRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.FoodCategoriesRemoteDatasourceImpl
import com.example.bcasyariah.com.example.makanbesar.data.remote.RecommendedRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.RecommendedRemoteDatasourceImpl
import com.example.makanbesar.data.MakanBesarService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object BeefModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDatasource(service: MakanBesarService):
            BeefRemoteDatasource {
        return BeefRemoteDatasourceImpl(service)
    }

}