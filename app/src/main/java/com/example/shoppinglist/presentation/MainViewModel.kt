package com.example.shoppinglist.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImpl
import com.example.shoppinglist.domain.*

class MainViewModel:ViewModel()/*Use ViewModel, because we not use context*/ {
    //Work with domain part
    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val removeShopItemUseCase = RemoveShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()
        /*MutableLiveData<List<ShopItem>>()*/ //LiveData allow interaction vieModel with Activity

    /*fun getShopList(){
        val list = getShopListUseCase.getShopList()
        shopList.value = list   //Get shop list in the UseCase and set it in liveData
    }*/

    fun removeShopItem(shopItem: ShopItem){
        removeShopItemUseCase.removeShopItem(shopItem)
        /*getShopList()*/
    }

    fun changeEnabledItem(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)    //Create copy shopItem
        editShopItemUseCase.editShopItem(newItem)
        /*getShopList()*/
    }
}