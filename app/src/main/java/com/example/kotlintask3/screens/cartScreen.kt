package com.example.kotlintask3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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

        Card(modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color.Blue)) {
            IconButton(
                onClick = {
                    viewModel.reset()
                },
                modifier = Modifier.background(Color.Blue).fillMaxWidth()
            ) {
                Text("REST")
            }
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