package com.example.logindi.di

import com.example.logindi.repository.MainRepo
import com.example.logindi.repository.MainRepoImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideMainRepo() : MainRepo = MainRepoImpl()
}