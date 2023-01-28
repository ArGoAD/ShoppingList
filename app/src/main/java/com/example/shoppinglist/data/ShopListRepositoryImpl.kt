package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.RemoveShopItemUseCase
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopListRepository

object ShopListRepositoryImpl:ShopListRepository {
    //Allow implementation domain interface


    private val shopList = mutableListOf<ShopItem>()
    private var autoIncrementId = 0

    //Create object LiveData, which we must return
    private val shopListLiveData = MutableLiveData<List<ShopItem>>()


    init{ //This test method, which allow testing and add item in list
        for(i in 0 until 10){
            val item = ShopItem("Name", 1, true)
            addShopItem(item)
        }
    }

    override fun addShopItem(shopItem: ShopItem) {
        if(shopItem.id == ShopItem.UNDEFINED_ID){
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldItem = getItemById(shopItem.id)
        removeShopItem(oldItem)
        addShopItem(shopItem)
    }

    override fun getItemById(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        }?: throw RuntimeException("not") //Use how exception and allow throw message
    }

    override fun removeShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    //Return LiveData
    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLiveData
    }


    private fun updateList(){
        shopListLiveData.value = shopList.toList() //Set value for auto update list
    }

}