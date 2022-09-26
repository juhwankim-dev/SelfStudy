package com.example.data.di

import com.example.data.api.TempApi
import com.example.data.repository.Temp.TempRemoteDataSource
import com.example.data.repository.Temp.TempRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDataModule {
    @Provides
    @Singleton
    fun provideTempRemoteDataSource(tempApi: TempApi): TempRemoteDataSource {
        return TempRemoteDataSourceImpl(tempApi)
    }
}