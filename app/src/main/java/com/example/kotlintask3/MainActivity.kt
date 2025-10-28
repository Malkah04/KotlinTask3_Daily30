package com.example.kotlintask3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.kotlintask3.DataSource.ThirteenDayData
import com.example.kotlintask3.ui.theme.Kotlintask3Theme
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Alignment
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import com.example.kotlintask3.Box.BOX
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Button
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import android.R.attr.left


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlintask3Theme(darkTheme = false) {
                Surface(modifier = Modifier.fillMaxSize()) {
                    App()
                }
            }
        }
    }
}

@Composable
private fun cardButton(expand:Boolean , onclick:()->Unit , modifier: Modifier = Modifier){

    IconButton(
        onClick = onclick,
        modifier = modifier
    ) {
        Icon(
            imageVector = Icons.Filled.ExpandMore,
            contentDescription = stringResource(R.string.expand_more),
            tint = MaterialTheme.colorScheme.secondary

        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.height(300.dp)

            ) {
                Image(
                    modifier = Modifier.clip(CircleShape).width(200.dp),
                    painter = painterResource(R.drawable.logo2),
                    contentScale = ContentScale.Crop,
                    contentDescription = null
                )

                Spacer(modifier.height(20.dp))

            }
        },
        modifier = modifier
    )
}



@Composable
fun ItemCard(modifier: Modifier= Modifier , day : ThirteenDayData){
    var expanded by remember { mutableStateOf(false) }
    Card(shape = RoundedCornerShape(topEnd = 50.dp , topStart = 0.dp , bottomEnd = 50.dp , bottomStart = 50.dp) , modifier = Modifier.padding(10.dp)) {
        Column(modifier.padding(20.dp).animateContentSize(spring(dampingRatio = Spring.DampingRatioLowBouncy, stiffness = Spring.StiffnessLow))) {
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
                    .clickable{expanded=!expanded}
                    ,
                contentScale = ContentScale.Crop
            )

//            cardButton(
//                expand = expanded,
//                onclick = { expanded = !expanded },
//            )


            if(expanded){
                Text(
                    text = stringResource(day.body ),
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize
                )
            }
        }
    }
}

@Composable
fun CardList(days: List<ThirteenDayData>){
    Column {
//        Text(
//            text = "30 days of Challenges",
//            style = MaterialTheme.typography.headlineLarge,
//            modifier = Modifier.padding(20.dp)
//        )
    AppBar()

    LazyColumn {
            items(days) { d ->
                ItemCard(day = d)
            }
        }
    }
}

@Composable
fun App() {
    val layoutDir = LocalLayoutDirection.current
    Surface(
        Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues().calculateStartPadding(layoutDir),
                end = WindowInsets.safeDrawing.asPaddingValues().calculateEndPadding(layoutDir)
            )
    ) {

        CardList(days = BOX.box)
    }
}

