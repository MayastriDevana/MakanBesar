package com.example.bcasyariah.com.example.makanbesar.module

import com.example.bcasyariah.com.example.makanbesar.data.remote.FavoriteMealsRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.FavoriteMealsRemoteDatasourceImpl
import com.example.bcasyariah.com.example.makanbesar.data.remote.JapaneseRemoteDatasource
import com.example.bcasyariah.com.example.makanbesar.data.remote.JapaneseRemoteDatasourceImpl
import com.example.makanbesar.data.MakanBesarService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object JapaneseModule {

    @Singleton
    @Provides
    fun provideMenuDashboardRemoteDatasource(service: MakanBesarService):
            JapaneseRemoteDatasource {
        return JapaneseRemoteDatasourceImpl(service)
    }

}