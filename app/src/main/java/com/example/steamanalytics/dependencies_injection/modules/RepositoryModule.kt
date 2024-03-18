package com.example.steamanalytics.dependencies_injection.modules

import com.example.data.repositories.InventoryRepositoryImpl
import com.example.data.repositories.ItemMarketRepositoryImpl
import com.example.domain.repositories.InventoryRepository
import com.example.domain.repositories.ItemMarketRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module(includes = [NetworkModule::class])
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindInventoryRepository(inventoryRepositoryImpl: InventoryRepositoryImpl): InventoryRepository

    @Binds
    @ViewModelScoped
    abstract fun bindItemMarketRepository(itemMarketRepositoryImpl: ItemMarketRepositoryImpl): ItemMarketRepository
}

