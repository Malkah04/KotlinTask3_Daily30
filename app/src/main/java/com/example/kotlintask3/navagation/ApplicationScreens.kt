package com.example.kotlintask3.navagation

enum class ApplicationScreens{
    Screen1 ,
    Screen2,
    Screen3 ,
    Home,
    Cart
    ;
    companion object {
        fun fromRoute(route:String?):ApplicationScreens =
            when(route?.substringBefore("/")){
                Screen1.name -> Screen1
                Screen2.name -> Screen2
                Screen3.name -> Screen3
                Home.name -> Home
                Cart.name -> Cart
                null -> Screen1
                else -> throw IllegalArgumentException("Route $route is not recognized")

            }
    }
}