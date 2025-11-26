package com.example.kotlintask3.screens.screen3

import android.provider.MediaStore
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.kotlintask3.CustomTopBar
import com.example.kotlintask3.R
import androidx.compose.runtime.getValue


@Composable
fun Screen3(navController: NavController) {
    Scaffold(topBar = {
        CustomTopBar(
            navController,
            header = "Gallery",
            screen2 = false,
            screen1 = false,
            screen3 = true
        )
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Images(navController)
        }


    }
}
// task2

@Composable
fun Images(navController: NavController,
    modifier: Modifier = Modifier){

    var res by remember { mutableStateOf(1) }
    var img = R.drawable.i1
    var title =""
    var owner =""
    var date = ""

    when (res){
        1 ->{
            img =R.drawable.i1
            title = "Yellow Lemon Squeeze"
            owner ="Malak Sobhy "
            date ="2025"
        }
        2 -> {
            img =R.drawable.i9
            title = "Lemon Tree"
            owner ="Malak Sobhy"
            date ="2025"
        }
        3->{
            img =R.drawable.i2
            title = "Lemon Drink"
            owner ="public"
            date ="2025"
        }
        4 ->{
            img =R.drawable.i2
            title = "Lemon Restart"
            owner ="Malak Sobhy"
            date ="2025"
        }
        else ->{
            img =R.drawable.i1
            title = "Lemon Squeeze"
            owner ="Malak Sobhy"
            date ="2025"
        }
    }

    Column(modifier
        .fillMaxWidth()
        .padding(10.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(
            painter = painterResource(img),
            contentDescription = res.toString(),
            modifier
                .width(350.dp)
                .height(350.dp)
        )

        Spacer(modifier.height(200.dp))

        Column(
            modifier
                .padding(30.dp)
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxWidth()
                .height(100.dp).align(Alignment.End)
        ) {
            Text(
                text = title,
                modifier.padding( 10.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Row {
                Text(text = owner,
                    modifier.padding( 10.dp),
                    fontWeight = FontWeight.Bold,
                    color = Color.Black

                )
                Text(
                    text = date,
                    modifier.padding( 10.dp),
                    color = Color.Blue

                )
            }
        }

        Row(modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center) {

            Button(onClick = {

                 if (res > 1) {
                    res--
                } else if (res == 1) {
                    res = 1
                }

            }) {
                Text(
                    text = "Back"
                )
            }

            Spacer(modifier.width(50.dp))
            Button(onClick = {
                if (res == 4) {
                    res = 1
                } else if (res < 4) {
                    res++
                }
            }) {
                Text(
                    text = "Next"
                )
            }
        }
    }
}
