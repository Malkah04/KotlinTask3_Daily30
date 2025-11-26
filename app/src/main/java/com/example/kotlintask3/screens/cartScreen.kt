package com.example.kotlintask3.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlintask3.saveViewModel
import com.example.kotlintask3.screens.screen1.ItemCard


@Composable
fun Cart(navController: NavController ,viewModel: saveViewModel){

    Cat(navController , viewModel)
}
@Composable
fun Cat(navController: NavController,viewModel: saveViewModel){

    var total_price = viewModel.k
    Column {
        Text(text = "total price ${total_price.value}")

        IconButton(
            onClick = {
                viewModel.reset()
            }
        ) {
            Text("REST")
        }

        IconButton(
            onClick = {
                navController.navigate("Home")
            }
        ) {
            Text("Go to home")
        }
        items(viewModel)
    }
}

@Composable
fun items(viewModel: saveViewModel){
    LazyColumn {
        items(viewModel.item) { d ->
            Column {
                Text(text= d.first)
                Text(text = "${d.second}")
            }
        }
    }
}