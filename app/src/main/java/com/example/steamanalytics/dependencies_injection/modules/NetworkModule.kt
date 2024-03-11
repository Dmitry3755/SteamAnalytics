package com.example.steamanalytics.dependencies_injection.modules

import com.example.data.api.InventoryApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule {

    @Provides
    @ViewModelScoped
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://steamcommunity.com/inventory/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    @Provides
    @ViewModelScoped
    fun provideInventoryApi(retrofit: Retrofit) : InventoryApi {
        return retrofit.create(InventoryApi::class.java)
    }
}