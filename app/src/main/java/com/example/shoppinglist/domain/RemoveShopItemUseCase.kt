package com.example.shoppinglist.domain

class RemoveShopItemUseCase(private val shopItemRepository: ShopListRepository) {
    //Delete item in shop list
    fun removeShopItem(shopItem: ShopItem){
        shopItemRepository.removeShopItem(shopItem)
    }
}