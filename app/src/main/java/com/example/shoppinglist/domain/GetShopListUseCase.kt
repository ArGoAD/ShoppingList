package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopItemRepository: ShopListRepository) {
    //Get all shop list
    fun getShopList(): LiveData<List<ShopItem>>
    /*Change on LiveData to auto return getShopList in viewModel, also add LiveData in Repository*/
    {
        return shopItemRepository.getShopList()
    }

}