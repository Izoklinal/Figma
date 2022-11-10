package com.example.figmafirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmafirst.ui.theme.FigmaFirstTheme
import com.example.figmafirst.ui.theme.Green

class AlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanel("Будильник")
                Spacer(modifier = Modifier.height(100.dp))
                TimePanel(time = "17:30")
                Spacer(modifier = Modifier.height(100.dp))
                SwitchTime()
                Spacer(modifier = Modifier.height(100.dp))
                BottomPanel()
                
            }
        }
    }
}

@Composable
fun TimePanel(time: String){
    Text(
        text = time,
        color = MaterialTheme.colors.surface,
        fontSize = 48.sp,
        fontWeight = FontWeight.ExtraLight
    )
}

@Composable
fun SwitchTime()
{
    val checkedState = remember { mutableStateOf(true) }
    Switch(
        checked = checkedState.value,
        onCheckedChange = { checkedState.value = it }
    )
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
