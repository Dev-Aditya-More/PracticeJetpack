package com.example.practiceapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            App()
        }
    }
}

// counter app
//@Composable
//fun App(modifier: Modifier = Modifier) {
//
//    val randomDp = Random.nextInt(0, 150).dp
//    var moved by remember { mutableStateOf(false) }
//    val pxToMove = with(LocalDensity.current){
//        randomDp.toPx().roundToInt()
//    }
//
//    var backgroundColor by remember { mutableStateOf(Color.Black) }
//
//    var toggled by remember {
//        mutableStateOf(false)
//    }
//    val boxSize by animateDpAsState(if (toggled) 200.dp else 150.dp)
//
//    val animatedPadding by animateDpAsState(
//        if (toggled) {
//            20.dp
//        } else {
//            0.dp
//        },
//    )
//    val animatedOuterPadding by animateDpAsState(if (toggled) 40.dp else 20.dp)
//
//    fun getRandomColor() : Color {
//
//        return Color(
//
//            Random.nextFloat(),
//            Random.nextFloat(),
//            Random.nextFloat(),
//            1f
//        )
//    }
//
//    val offset by animateIntOffsetAsState(
//        targetValue = if (moved) {
//            IntOffset(pxToMove, pxToMove)
//        }
//        else{
//            IntOffset.Zero
//        }
//    )
//
//    Box(
//        modifier
//            .fillMaxSize()
//            .padding(20.dp)
//            .background(backgroundColor)
//            .clickable(
//                interactionSource = remember { MutableInteractionSource() },
//                indication = null
//            ){
//                toggled = !toggled
//                backgroundColor = getRandomColor()
//
//            }
//            .padding(animatedOuterPadding)
//            .animateContentSize(),
//        contentAlignment = Alignment.Center
//    ){
//
//        var count by remember { mutableIntStateOf(0) }
//
//        Button(
//            onClick = {
//                count += 1
//                moved = !moved
//            },
//            colors = ButtonDefaults.buttonColors(
//                Color.White,
//                Color.Black
//            ),
//            modifier = Modifier
//                .offset { offset },
//            interactionSource = remember {
//                MutableInteractionSource()
//            },
//            shape = CircleShape
//
//        ) {
//            Text(text = "$count")
//        }
//    }
//
//
//}

@Composable
fun App(modifier: Modifier = Modifier) {

    var toggled by remember {
        mutableStateOf(false)
    }
    val animatedPadding by animateDpAsState(
        if (toggled) {
            0.dp
        } else {
            20.dp
        }
    )
    val animateVerticalPadding by animateDpAsState(
        if (toggled) {
            20.dp
        } else {
            0.dp
        }
    )
    fun getRandomColor() : Color {

        return Color(

            Random.nextFloat(),
            Random.nextFloat(),
            Random.nextFloat(),
            1f
        )
    }
    val backgroundColor by animateColorAsState(
        if (toggled) {
            Color(0xff53D9A1)
        } else {
            getRandomColor()
        }
    )
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Box(
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxSize()
                .padding(animatedPadding, vertical = animateVerticalPadding)
                .background(backgroundColor)
                .clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = null
                ) {
                    toggled = !toggled
                }
        )

    }

}
