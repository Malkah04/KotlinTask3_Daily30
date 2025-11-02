package com.example.kotlintask3.navagation
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlintask3.screens.screen1.Screen1
import com.example.kotlintask3.screens.screen2.Screen2
import com.example.kotlintask3.screens.screen3.Screen3


@Composable
fun ApplicationNavigation(){
    val navController = rememberNavController()
    NavHost(navController=navController ,
        startDestination = ApplicationScreens.Screen1.name
        ){
        composable(ApplicationScreens.Screen1.name){
            Screen1(navController)
        }
        composable(ApplicationScreens.Screen2.name){
            Screen2(navController)
        }
        composable(ApplicationScreens.Screen3.name){
            Screen3(navController)


        }

    }
}