package com.example.shoppinglist.domain

class GetShopListUseCase(private val shopItemRepository: ShopListRepository) {

    fun getShopList(): List<ShopItem>{
        return shopItemRepository.getShopList()
    }

}