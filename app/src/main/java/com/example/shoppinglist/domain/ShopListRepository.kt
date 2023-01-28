package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    //Allow works domain with others parts(presentation and data)
    fun addShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getItemById(shopItemId:Int):ShopItem

    fun removeShopItem(shopItem: ShopItem)

    fun getShopList(): LiveData<List<ShopItem>>

}