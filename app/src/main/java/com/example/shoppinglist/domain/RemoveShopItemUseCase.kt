package com.example.shoppinglist.domain

class RemoveShopItemUseCase(private val shopItemRepository: ShopListRepository) {

    fun removeShopItem(shopItem: ShopItem){
        shopItemRepository.removeShopItem(shopItem)
    }
}