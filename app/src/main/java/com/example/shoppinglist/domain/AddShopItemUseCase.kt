package com.example.shoppinglist.domain

class AddShopItemUseCase(private val shopItemRepository: ShopListRepository) {
    //Add item in shop list
    fun addShopItem(shopItem: ShopItem){
        shopItemRepository.addShopItem(shopItem)
    }

}