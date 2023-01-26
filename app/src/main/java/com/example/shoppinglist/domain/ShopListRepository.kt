package com.example.shoppinglist.domain

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getItemById(shopItemId:Int):ShopItem

    fun removeShopItem(shopItem: ShopItem)

    fun getShopList(): List<ShopItem>

}