package com.example.practiceapps

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.asComposePath
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.graphics.shapes.CornerRounding
import androidx.graphics.shapes.Morph
import androidx.graphics.shapes.RoundedPolygon
import androidx.graphics.shapes.star
import androidx.graphics.shapes.toPath
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.Density
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Matrix


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

//@Composable
//fun App(modifier: Modifier = Modifier) {
//
//    var toggled by remember {
//        mutableStateOf(false)
//    }
//    val animatedPadding by animateDpAsState(
//        if (toggled) {
//            0.dp
//        } else {
//            20.dp
//        }
//    )
//    val animateVerticalPadding by animateDpAsState(
//        if (toggled) {
//            20.dp
//        } else {
//            0.dp
//        }
//    )
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
//    var randomColor by remember { mutableStateOf(getRandomColor()) }
//
//    LaunchedEffect(toggled) {
//        if (!toggled) {
//            randomColor = getRandomColor()
//        }
//    }
//
//    val backgroundColor by animateColorAsState(
//        targetValue = if (toggled) Color(0xff53D9A1) else randomColor
//    )
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//
//        Box(
//            modifier = Modifier
//                .aspectRatio(1f)
//                .fillMaxSize()
//                .padding(animatedPadding, vertical = animateVerticalPadding)
//                .background(backgroundColor)
//                .clickable(
//                    interactionSource = remember { MutableInteractionSource() },
//                    indication = null
//                ) {
//                    toggled = !toggled
//                }
//        )
//
//    }
//}

//@Composable
//fun App() {
//
//    var pointerOffset by remember {
//        mutableStateOf(Offset(0f, 0f))
//    }
//    var isDragging by remember{
//        mutableStateOf(false)
//    }
//
//    val spotlightRadius by animateFloatAsState(
//        targetValue = if (isDragging) 200f else 80f,
//        label = "SpotlightRadius"
//    )
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .pointerInput("dragging") {
//                detectDragGestures(
//
//                    onDragStart = {
//                        isDragging = true
//                    },
//                    onDragEnd = {
//                        isDragging = false
//                    },
//                    onDragCancel = {
//                        isDragging = false
//                    }
//
//                ) { change, dragAmount ->
//                    pointerOffset += dragAmount
//                }
//            }
//            .onSizeChanged {
//                pointerOffset = Offset(it.width / 2f, it.height / 2f)
//            }
//            .drawWithContent {
//                drawContent()
//                drawRect(
//                    Brush.radialGradient(
//                        colors = listOf(Color.Transparent, Color.Black.copy(alpha = 0.85f)),
//                        center = pointerOffset,
//                        radius = spotlightRadius
//                    ),
//                    blendMode = BlendMode.Multiply
//                )
//            }
//    ){
//
//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//
//            Image(
//
//                painter = painterResource(
//                    R.drawable.ic_launcher_background,
//                ),
//                contentDescription = null,
//                modifier = Modifier
//                    .fillMaxSize(),
//                contentScale = ContentScale.FillBounds
//
//            )
//
//        }
//
//    }
//}

//class CustomRotatingMorphShape(
//    private val morph: Morph,
//    private val percentage: Float,
//    private val rotation: Float
//) : Shape {
//
//    private val matrix = Matrix()
//    override fun createOutline(
//        size: Size,
//        layoutDirection: LayoutDirection,
//        density: Density
//    ): Outline {
//        // Below assumes that you haven't changed the default radius of 1f, nor the centerX and centerY of 0f
//        // By default this stretches the path to the size of the container, if you don't want stretching, use the same size.width for both x and y.
//        matrix.scale(size.width / 2f, size.height / 2f)
//        matrix.translate(1f, 1f)
//        matrix.rotateZ(rotation)
//
//        val path = morph.toPath(progress = percentage).asComposePath()
//        path.transform(matrix)
//
//        return Outline.Generic(path)
//    }
//}

//@Preview
//@Composable
//private fun App() {
//    val shapeA = remember {
//        RoundedPolygon(
//            12,
//            rounding = CornerRounding(0.2f)
//        )
//    }
//    val shapeB = remember {
//        RoundedPolygon.star(
//            12,
//            rounding = CornerRounding(0.2f)
//        )
//    }
//    val morph = remember {
//        Morph(shapeA, shapeB)
//    }
//    val infiniteTransition = rememberInfiniteTransition("infinite outline movement")
//    val animatedProgress = infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = 1f,
//        animationSpec = infiniteRepeatable(
//            tween(2000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        ),
//        label = "animatedMorphProgress"
//    )
//    val animatedRotation = infiniteTransition.animateFloat(
//        initialValue = 0f,
//        targetValue = 360f,
//        animationSpec = infiniteRepeatable(
//            tween(6000, easing = LinearEasing),
//            repeatMode = RepeatMode.Reverse
//        ),
//        label = "animatedMorphProgress"
//    )
//    Box(
//        modifier = Modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Image(
//            painter = painterResource(id = R.drawable.thunder),
//            contentDescription = "A",
//            contentScale = ContentScale.Crop,
//            modifier = Modifier
//                .clip(
//                    CustomRotatingMorphShape(
//                        morph,
//                        animatedProgress.value,
//                        animatedRotation.value
//                    )
//                )
//                .size(200.dp)
//        )
//    }
//}

//class MorphPolygonShape(
//    private val morph: Morph,
//    private val percentage: Float,
//) : Shape {
//
//    private val matrix = Matrix()
//    override fun createOutline(
//        size: Size,
//        layoutDirection: LayoutDirection,
//        density: Density
//    ): Outline {
//        // Below assumes that you haven't changed the default radius of 1f, nor the centerX and centerY of 0f
//        // By default this stretches the path to the size of the container, if you don't want stretching, use the same size.width for both x and y.
//        matrix.scale(size.width / 2f, size.height / 2f)
//        matrix.translate(1f, 1f)
//
//        val path = morph.toPath(progress = percentage).asComposePath()
//        path.transform(matrix)
//        return Outline.Generic(path)
//    }
//}
//
//@Composable
//fun App(modifier: Modifier = Modifier) {
//    val shapeA = remember {
//        RoundedPolygon(
//            6,
//            rounding = CornerRounding(0.2f)
//        )
//    }
//    val shapeB = remember {
//        RoundedPolygon.star(
//            6,
//            rounding = CornerRounding(0.1f)
//        )
//    }
//    val morph = remember {
//        Morph(shapeA, shapeB)
//    }
//    val interactionSource = remember {
//        MutableInteractionSource()
//    }
//    val isPressed by interactionSource.collectIsPressedAsState()
//    val animatedProgress = animateFloatAsState(
//        targetValue = if (isPressed) 1f else 0f,
//        label = "progress",
//        animationSpec = spring(dampingRatio = 0.4f, stiffness = Spring.StiffnessMedium)
//    )
//
//    Box(
//        modifier.fillMaxSize(),
//        contentAlignment = Alignment.Center
//    ) {
//        Box(
//            modifier = Modifier
//                .size(200.dp)
//                .padding(8.dp)
//                .clip(MorphPolygonShape(morph, animatedProgress.value))
//                .background(Color(0xFF80DEEA))
//                .size(200.dp)
//                .clickable(interactionSource = interactionSource, indication = null) {
//                },
//            contentAlignment = Alignment.Center
//        ) {
//            Text("Hello", modifier = Modifier.align(Alignment.Center))
//        }
//
//    }
//
//}

@Composable
fun App(modifier: Modifier = Modifier) {

}