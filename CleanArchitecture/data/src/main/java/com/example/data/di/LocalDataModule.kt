package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.db.UserDao
import com.example.data.db.UserDatabase
import com.example.data.repository.User.UserLocalDataSource
import com.example.data.repository.User.UserLocalDataSourceImpl
import com.example.domain.util.Constants.DB_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

// 내부 DB에 데이터를 저장하기 위해 Room을 사용하는데
// Room 사용시 의존성 주입을 위한 코드들입니다.
@InstallIn(SingletonComponent::class)
@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideUserDatabase(@ApplicationContext context: Context): UserDatabase {
        return Room.databaseBuilder(
            context,
            UserDatabase::class.java,
            DB_NAME
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDatabase: UserDatabase): UserDao {
        return userDatabase.userDao()
    }

    @Provides
    @Singleton
    fun provideUserLocalDataSource(userDao: UserDao): UserLocalDataSource {
        return UserLocalDataSourceImpl(userDao)
    }
}