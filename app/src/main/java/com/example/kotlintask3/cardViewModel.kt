package com.example.kotlintask3

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.setValue

class cardViewModel : ViewModel() {
    private var _expanded = mutableStateMapOf<String, Boolean>()

    fun toggleExpanded(id:String){
        _expanded[id] =!(_expanded[id]?:false)
    }
    fun isExpanded(id:String):Boolean{
        return _expanded[id]?:false
    }
}
