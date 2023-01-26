package com.example.shoppinglist.domain

class GetItemByIdUseCase(private val shopItemRepository: ShopListRepository) {

    fun getItemById(shopItemId:Int):ShopItem{
        return shopItemRepository.getItemById(shopItemId)

    }
}
