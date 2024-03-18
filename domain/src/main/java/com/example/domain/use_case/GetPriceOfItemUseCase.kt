package com.example.domain.use_case

import com.example.domain.repositories.ItemMarketRepository
import javax.inject.Inject

class GetPriceOfItemUseCase @Inject constructor(private val itemMarketRepository: ItemMarketRepository) {
    suspend operator fun invoke(marketName: String) = itemMarketRepository.getPriceMarketAboutItem(marketName)
}