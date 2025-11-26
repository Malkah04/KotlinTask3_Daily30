package com.example.kotlintask3

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.remember

import kotlin.collections.set

class saveViewModel: ViewModel() {

    var item = mutableStateListOf<Pair<String ,Int>>()
//   total price
    var k = mutableStateOf(0)


    var numberOfItem = mutableStateOf(0)

    fun increment(){
        numberOfItem.value ++
    }

    fun addPrice(price:Int){
        k.value = k.value +price
    }
    fun reset(){
        k.value =0
        numberOfItem.value=0
    }

    fun addItem(name:String ,price :Int){
        var q=Pair(name ,price)
        item.add(q)
    }


}