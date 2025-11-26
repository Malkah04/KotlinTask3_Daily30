package com.example.kotlintask3.navagation
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.kotlintask3.saveViewModel
import com.example.kotlintask3.screens.Cart
import com.example.kotlintask3.screens.Home
import com.example.kotlintask3.screens.screen1.Screen1
import com.example.kotlintask3.screens.screen2.Screen2
import com.example.kotlintask3.screens.screen3.Screen3


@Composable
fun ApplicationNavigation(){
    val navController = rememberNavController()
    val view : saveViewModel = viewModel()
    NavHost(navController=navController ,
//      start destination -> each app must have start destination
        startDestination = ApplicationScreens.Screen1.name
        ){

        composable(ApplicationScreens.Screen1.name) {
            Screen1(navController)
        }
        composable(ApplicationScreens.Screen2.name) {
            Screen2(navController)
        }
        composable(ApplicationScreens.Screen3.name) {
            Screen3(navController)
        }
        composable(ApplicationScreens.Home.name){
            Home(navController,view)
        }
        composable(ApplicationScreens.Cart.name){
            Cart(navController ,view)
        }

    }
}