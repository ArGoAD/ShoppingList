package com.example.shoppinglist.domain

class EditShopItemUseCase(private val shopItemRepository: ShopListRepository) {
    //Edit shop list
    fun editShopItem(shopItem: ShopItem){
        shopItemRepository.editShopItem(shopItem)
    }
}