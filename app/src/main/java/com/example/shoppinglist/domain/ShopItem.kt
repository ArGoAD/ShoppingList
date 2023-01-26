package com.example.shoppinglist.domain

data class ShopItem(
    var id: Int,
    var name: String,
    var count: Int,
    var enabled: Boolean
)
