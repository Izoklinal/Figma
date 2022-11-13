package com.example.figmafirst


import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmafirst.ui.theme.*

class AlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanel("Будильник")
                Spacer(modifier = Modifier.height(40.dp))
                TimeAndSwitch("07:30")
                Spacer(modifier = Modifier.height(8.dp))
                TimeAndSwitch("08:00")
                Spacer(modifier = Modifier.height(100.dp))
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.BottomCenter))
                    {
                        AddAlarmBtn("Добавить будильник")
                        Spacer(modifier = Modifier.height(16.dp))
                        BottomPanel(false, true, false, false)
                }
            }
        }
    }
}

@Composable
fun AddAlarmBtn(text: String) {
    val context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Button(onClick = { context.startActivity(Intent(context, CreateAlarmActivity::class.java)) },
            colors = ButtonDefaults.buttonColors(backgroundColor = LightGreen),
            modifier = Modifier
                .size(340.dp, 40.dp)
                .clip(RoundedCornerShape(10))
        ) {
            Text(
                text = text,
                color = MaterialTheme.colors.background
            )
        }
    }
}

@Composable
fun TimeAndSwitch(time: String) {
    Row {
        Column(
            modifier = Modifier
                .padding(all = 8.dp)
        ) {

        }
        TimePanel(time)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(Alignment.CenterEnd)
                .padding(end = 48.dp, top = 24.dp)
        ) {
            SwitchTime()
        }
    }
}

@Composable
fun TimePanel(time: String){
    val context = LocalContext.current
    Text(
        text = time,
        color = MaterialTheme.colors.surface,
        fontSize = 48.sp,
        fontWeight = FontWeight.ExtraLight,
        modifier = Modifier
            .clickable { context.startActivity(Intent(context, EditAlarmActivity::class.java)) }
    )
}

@Composable
fun SwitchTime(
    scale: Float = 2f,
    width: Dp = 36.dp,
    height: Dp = 20.dp,
    checkedTrackColor: Color = LightGreen,
    uncheckedTrackColor: Color = LightRed,
    thumbColor: Color = White,
    gapBetweenThumbAndTrackEdge: Dp = 4.dp
) {
    val switchON = remember {
        mutableStateOf(true)
    }
    val thumbRadius = (height / 2) - gapBetweenThumbAndTrackEdge
    val animatePosition = animateFloatAsState(
        targetValue = if (switchON.value)
            with(LocalDensity.current) { (width - thumbRadius - gapBetweenThumbAndTrackEdge).toPx() }
        else
            with(LocalDensity.current) { (thumbRadius + gapBetweenThumbAndTrackEdge).toPx() }
    )
    Canvas(
        modifier = Modifier
            .size(width = width, height = height)
            .scale(scale = scale)
            .pointerInput(Unit) {
                detectTapGestures(
                    onTap = {
                        // This is called when the user taps on the canvas
                        switchON.value = !switchON.value
                    }
                )
            }
    ) {

        // Track
        drawRoundRect(
            color = if (switchON.value) checkedTrackColor else uncheckedTrackColor,
            cornerRadius = CornerRadius(x = 10.dp.toPx(), y = 10.dp.toPx())
        )

        // Thumb
        drawCircle(
            color = thumbColor,
            radius = thumbRadius.toPx(),
            center = Offset(
                x = animatePosition.value,
                y = size.height / 2
            )
        )
    }
}

@Preview
@Composable
fun PreviewTimePanel() {
    FigmaFirstTheme() {
        Surface {
            TimePanel(time = "17:30")
        }
    }
}
