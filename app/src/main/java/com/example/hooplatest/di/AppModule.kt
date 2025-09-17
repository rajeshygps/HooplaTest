package com.example.hooplatest.di

import android.content.Context
import com.example.hooplatest.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDataRepository(@ApplicationContext context: Context): DataRepository {
        return DataRepository(context)
    }
}
