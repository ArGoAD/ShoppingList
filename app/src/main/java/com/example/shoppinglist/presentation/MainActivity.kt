package com.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.ShopItem

class MainActivity : AppCompatActivity() {

    lateinit var llShopList: LinearLayout
    private lateinit var viewModel: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Subscribe viewModel for Activity
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            //init shopList
            showList(it)
        }
        /*viewModel.getShopList()*/

        //Bind elements from layout with Activity
        llShopList = findViewById(R.id.ll_shop_list)


    }


    //Create and connect layout with RCView
    private fun showList(list: List<ShopItem>){
        for(shopItem in list){
            val layoutId = if(shopItem.enabled){
                R.layout.item_shop_enabled
            }else{
                R.layout.item_shop_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutId, llShopList, false)
            val tvName = findViewById<TextView>(R.id.name)
            val tvCount = findViewById<TextView>(R.id.count)
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
            llShopList.addView(view)

        }

    }



}