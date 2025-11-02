package com.example.kotlintask3.screens.screen2

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.kotlintask3.CustomTopBar
import com.example.kotlintask3.R
import com.example.kotlintask3.data.dataof30Day
import com.example.kotlintask3.screens.screen1.CardList


@Composable
fun Screen2(navController: NavController){

    Scaffold(topBar = {
        CustomTopBar(navController , header = "Contact Me" , screen2 = true , screen1 = false , screen3 = false)
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Executing()
        }

    }
}



@Composable
fun Header(title:String ,p:String ,modifier: Modifier =Modifier ){

    Column( modifier = modifier
        .fillMaxWidth()
        .padding(vertical = 16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = R.drawable.logo2),
            null,
            modifier = modifier
                .width(200.dp)
                .height(200.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(10.dp),
            fontSize = 25.sp,
            color=Color.Magenta
        )
        Text(
            text = p,
            color = Color.Blue,
            fontSize = 20.sp
        )
    }
}

@Composable
fun Calling(img: ImageVector, text:String, modifier: Modifier= Modifier){
    Box(modifier = modifier.fillMaxWidth(), contentAlignment = Alignment.Center ,) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(15.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = img,
                null,
                modifier = modifier
                    .width(40.dp)
                    .height(40.dp),
                tint= Color.Blue
            )
            Text(
                text = text,
                modifier = modifier.width(180.dp),
                fontSize = 18.sp,
                color = Color.Magenta
            )
        }
    }
}

@Composable
fun Executing(modifier: Modifier= Modifier){

    Box(modifier
        .fillMaxSize()
        .padding(12.dp),
    ) {
        Header("Malak Sobhy", "Android Developer", modifier = Modifier.align(Alignment.Center))

        Column(
            modifier = modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            Calling(Icons.Default.Call, "01128554899")
            Calling(Icons.Default.Email, "malaaaaak52@gmail.com")
            Calling(Icons.Default.Share, "@AndroidDev")

        }
    }
}

