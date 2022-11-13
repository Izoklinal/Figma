package com.example.figmafirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.figmafirst.ui.theme.*

class CreateAlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanelAlarm("Добавить будильник")

                DateTimePanel("16:30", "14.01.2021")

                Column(modifier = Modifier
                    .padding(all = 32.dp)) {
                    SimpleText(text = "Повторять каждый")
                }
                CheckBoxPanel("Понедельник")
                CheckBoxPanel("Вторник")
                CheckBoxPanel("Среда")
                CheckBoxPanel("Четверг")
                CheckBoxPanel("Пятница")
                CheckBoxPanel("Суббота")
                CheckBoxPanel("Воскресенье")

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)) {
                    GreenButton(text = "Создать будильник")
                }
            }
        }
    }
}

@Composable
fun TimeFieldPnl(txt: String) {
    var text by remember { mutableStateOf(txt) }
    Column(modifier = Modifier
        .padding(start = 32.dp, end = 32.dp)) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .size(168.dp, 48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor =  Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = Color.White,
                textColor = Color.Gray)
        )
    }
}

@Composable
fun DateFieldPnl(txt: String) {
    var text by remember { mutableStateOf(txt) }
    Column(modifier = Modifier
        .padding(start = 32.dp, end = 32.dp)) {
        TextField(
            value = text,
            onValueChange = {
                text = it
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .size(168.dp, 48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
                focusedIndicatorColor =  Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = Color.White,
                textColor = Color.Gray)
        )
    }
}

@Composable
fun DeleteAlarmBtn(text: String) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Red),
            modifier = Modifier
                .size(148.dp, 40.dp)
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
fun SaveAlarmBtn(text: String) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Button(onClick = { /*TODO*/ },
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