package com.example.kotlintask3.screens.screen1

import android.content.Context
import android.content.Intent
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.kotlintask3.CustomTopBar
import com.example.kotlintask3.cardViewModel
import com.example.kotlintask3.data.dataof30Day
import com.example.kotlintask3.model.ThirteenDayData
import com.example.kotlintask3.R

@Composable
fun Screen1(navController: NavController) {
    Scaffold(topBar = {
        CustomTopBar(navController)
    }) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            CardList(navController, days = dataof30Day.box)
        }

    }
}

fun shareCard(context : Context ,title:String ,body:String){
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, title)
        putExtra(Intent.EXTRA_TEXT, body)
    }
        context.startActivity(
            Intent.createChooser(
                intent ,
                context.getString(R.string.a1)
            )
        )

}


@Composable
fun ItemCard(modifier: Modifier= Modifier , day : ThirteenDayData ,viewModel: cardViewModel ,context: Context){
    val expand =viewModel.isExpanded(day.day.toString())


    Card(shape = RoundedCornerShape(topEnd = 50.dp , topStart = 0.dp , bottomEnd = 50.dp , bottomStart = 50.dp) , modifier = Modifier.padding(10.dp)) {
        Column(modifier
            .padding(20.dp)
            .animateContentSize(
                spring(
                    dampingRatio = Spring.DampingRatioLowBouncy,
                    stiffness = Spring.StiffnessLow
                )
            )) {
            Text(
                text = stringResource(day.day ),
                color =MaterialTheme.colorScheme.primary,
                fontSize = MaterialTheme.typography.headlineMedium.fontSize
            )
            Text(
                text = stringResource(day.title),
                color = MaterialTheme.colorScheme.secondary,
                fontSize = MaterialTheme.typography.headlineSmall.fontSize

            )
            Image(
                painter = painterResource(day.imageRecourse),
                contentDescription = stringResource(day.day),
                modifier
                    .fillMaxWidth()
                    .width(200.dp)
                    .height(250.dp)
                    .padding(10.dp)
                    .clickable { viewModel.toggleExpanded(day.day.toString()) }
                ,
                contentScale = ContentScale.Crop
            )
            if(expand){
                Text(
                    text = stringResource(day.body ),
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            }

            Row{
                Spacer(modifier = Modifier.weight(1f))

                IconButton(
                    onClick = {
                        shareCard(
                            context,
                            context.getString(day.title),
                            context.getString(day.body)
                        )
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "share",
                    )
                }

            }
        }
    }
}

@Composable
fun CardList(navController: NavController,days: List<ThirteenDayData>) {
    val viewModel: cardViewModel = viewModel()
    val context = LocalContext.current

    LazyColumn {
        items(days) { d ->
            ItemCard(day = d, viewModel = viewModel ,context =context)
        }
    }
}

