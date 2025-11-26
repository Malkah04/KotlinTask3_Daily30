package com.example.kotlintask3.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlintask3.move
import com.example.kotlintask3.saveViewModel
import com.example.kotlintask3.screens.screen1.shareCard
import java.nio.file.WatchEvent


@Composable
fun Home(navController: NavController ,viewModel: saveViewModel){

    Hom(navController , viewModel)
}

@Composable
fun Hom(navController: NavController,viewModel: saveViewModel){
    var number = viewModel.numberOfItem



    Column(modifier = Modifier.height(500.dp).padding(10.dp) ,
        verticalArrangement = Arrangement.Center ,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = "${number.value} of items added")


        Row(modifier = Modifier.fillMaxWidth().height(100.dp) , horizontalArrangement = Arrangement.Center , verticalAlignment = Alignment.CenterVertically) {
            Card(modifier = Modifier.clickable {
                viewModel.increment()
                viewModel.addPrice(3)
                viewModel.addItem("potato" ,3)
            }.width(150.dp).height(100.dp).padding(10.dp)
            ) {
                Text(text = "potato")
                Text(text = "3$")
            }
            Spacer(modifier = Modifier.width(50.dp))
            Card(
                modifier = Modifier.clickable {
                    viewModel.increment()
                    viewModel.addPrice(5)
                    viewModel.addItem("tomato" ,5)

                }.width(150.dp).height(100.dp).padding(10.dp)
            ) {
                Text(text = "tomato")
                Text(text = "5$")
            }
        }
        Spacer(modifier = Modifier.width(50.dp))


        Card(modifier = Modifier.fillMaxWidth().padding(20.dp).background(Color.Blue)) {
        IconButton(
            onClick = {
                navController.navigate("Cart")

            },
            modifier = Modifier.background(Color.Blue).fillMaxWidth()
        ) {
            Text(text="Go to cart", modifier = Modifier.fillMaxWidth())
        }
    }
        }


}


