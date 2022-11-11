package com.example.figmafirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmafirst.ui.theme.FigmaFirstTheme
import com.example.figmafirst.ui.theme.Green

class SettingsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanel("Настройки")
                Spacer(modifier = Modifier.height(40.dp))
                AllTextArrows()
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.BottomCenter))
                {
                    BottomPanel(false, false, false, true)
                }
            }
        }
    }
}

@Composable
fun AllTextArrows() {
    Column {
        TextArrows(text = "Профиль пользователя")
        Spacer(modifier = Modifier.height(8.dp))
        TextArrows(text = "Дата и время")
        Spacer(modifier = Modifier.height(8.dp))
        TextArrows(text = "Настройки звука")
        Spacer(modifier = Modifier.height(8.dp))
        TextArrows(text = "Проверить обновления")
    }

}


@Composable
fun TextArrows(text: String) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, end = 18.dp)) {
        Column {
            Text(
                text = text,
                fontSize = 24.sp,
                color = Color.White
            )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)
            .padding(end = 24.dp, top = 8.dp)) {
            Image(
                painter = painterResource(R.drawable.vector),
                contentDescription = "Vector",
                modifier = Modifier
                    .size(20.dp)
            )
        }
    }
}

@Preview
@Composable
fun PrevTextArrows() {
    FigmaFirstTheme() {
        Surface(modifier = Modifier
            .background(Color.Black)) {
            TextArrows(text = "Профиль пользователя")
        }
    }
}