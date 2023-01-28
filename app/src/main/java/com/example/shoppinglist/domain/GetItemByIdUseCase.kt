package com.example.shoppinglist.domain

class GetItemByIdUseCase(private val shopItemRepository: ShopListRepository) {
    //Allow find Item by id
    fun getItemById(shopItemId:Int):ShopItem{
        return shopItemRepository.getItemById(shopItemId)

    }
}
