package com.example.data.di

import com.example.data.repository.Temp.TempRemoteDataSource
import com.example.data.repository.TempRepositoryImpl
import com.example.data.repository.User.UserLocalDataSource
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.TempRepository
import com.example.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun provideTempRepository(
        tempRemoteDataSource: TempRemoteDataSource
    ): TempRepository {
        return TempRepositoryImpl(tempRemoteDataSource)
    }

    @Provides
    @Singleton
    fun provideUserRepository(
        userLocalDataSource: UserLocalDataSource
    ): UserRepository {
        return UserRepositoryImpl(userLocalDataSource)
    }
}