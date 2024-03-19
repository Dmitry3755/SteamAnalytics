package com.example.steamanalytics.dependencies_injection.modules

import com.example.data.repositories.db.InventoryRepositoryDbImpl
import com.example.data.repositories.InventoryRepositoryImpl
import com.example.data.repositories.ItemMarketRepositoryImpl
import com.example.domain.repositories.InventoryRepository
import com.example.domain.repositories.ItemMarketRepository
import com.example.domain.repositories.InventoryRepositoryDb
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Qualifier

@Qualifier
annotation class SteamRepository

@Qualifier
annotation class DatabaseRepository

@SteamRepository
@Module(includes = [NetworkModule::class])
@InstallIn(ViewModelComponent::class)
abstract class SteamRepositoryModule {


    @Binds
    @ViewModelScoped
    abstract fun bindSteamInventoryRepository(inventoryRepositoryImpl: InventoryRepositoryImpl): InventoryRepository

    @Binds
    @ViewModelScoped
    abstract fun bindSteamPriceRepository(itemMarketRepositoryImpl: ItemMarketRepositoryImpl): ItemMarketRepository
}

@DatabaseRepository
@Module(includes = [DatabaseModule::class])
@InstallIn(ViewModelComponent::class)
abstract class DatabaseRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindDatabaseInventoryRepository(inventoryRepositoryDbImpl: InventoryRepositoryDbImpl): InventoryRepositoryDb
}