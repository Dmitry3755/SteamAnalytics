package com.example.domain.use_case.db

import com.example.domain.repositories.InventoryRepository
import com.example.domain.repositories.InventoryRepositoryDb
import javax.inject.Inject
import javax.inject.Singleton

class GetInventoryDbUseCase @Inject constructor(private val inventoryRepositoryDb: InventoryRepositoryDb) {
    suspend operator fun invoke() = inventoryRepositoryDb.getAllItems()
}