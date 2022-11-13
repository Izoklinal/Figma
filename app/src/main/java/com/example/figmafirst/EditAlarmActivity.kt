package com.example.figmafirst

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmafirst.ui.theme.*

class EditAlarmActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanelAlarm("Изменить будильник")

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
                    RedButton(text = "Удалить будильник")
                    Spacer(modifier = Modifier.height(16.dp))
                    GreenButton(text = "Создать будильник")
                }

            }
        }
    }
}

@Composable
fun RedButton(text: String) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = Red),
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
fun CheckBoxPanel(text: String)
{
    val checkedState = remember { mutableStateOf(true) }
    Row (modifier = Modifier
        .padding(start = 16.dp)){
        Checkbox(
            checked = checkedState.value,
            onCheckedChange = { checkedState.value = it },
            colors  = CheckboxDefaults.colors(
                checkedColor = Color.White,
                uncheckedColor = Color.Yellow
            )
        )
        Column(modifier = Modifier
            .padding(top = 12.dp)) {
            SimpleText(text)
        }
    }
}

@Composable
fun TopPanelAlarm(text: String) {
    val context = LocalContext.current
    Row(modifier = Modifier.padding(all = 16.dp)) {
        Column(modifier = Modifier.padding(top = 8.dp)) {
            Text(
                text = text,
                color = MaterialTheme.colors.surface,
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)) {
            IconButton(onClick = {context.startActivity(Intent(context, AlarmActivity::class.java))}) {
                Image(
                    painter = painterResource(R.drawable.back_btn),
                    contentDescription = "Back Button",
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                )
            }
        }
    }
}

@Composable
fun SimpleText(text: String) {
    Text(
        text = text,
        fontWeight = FontWeight.Light,
        color = Color.White,
        fontSize = 18.sp
    )
}


@Composable
fun DateTimePanel(time: String, date: String)
{
    Row(modifier = Modifier
        .fillMaxWidth()) {
        Column(modifier = Modifier
            .padding(start = 32.dp, end = 32.dp)
            .width(152.dp)) {
            val text = remember{mutableStateOf(time)}
            TextField(
                text.value,
                {text.value = it},
                textStyle = TextStyle(fontSize = 14.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .size(320.dp, 48.dp),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(painterResource(R.drawable.clock_gray),
                        contentDescription = "Clock",
                        modifier = Modifier
                            .size(20.dp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor =  Color.Transparent, //hide the indicator
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.Gray
                )
            )
        }
        Column(modifier = Modifier
            .padding(end = 32.dp)
            .fillMaxWidth()) {
            val text = remember{mutableStateOf(date)}
            TextField(
                text.value,
                {text.value = it},
                textStyle = TextStyle(fontSize = 15.sp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
                    .size(320.dp, 48.dp),
                shape = RoundedCornerShape(8.dp),
                leadingIcon = {
                    Icon(painterResource(R.drawable.calendar_gray),
                        contentDescription = "Clock",
                        modifier = Modifier
                            .size(20.dp)
                    )
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                    focusedIndicatorColor =  Color.Transparent, //hide the indicator
                    unfocusedIndicatorColor = Color.White,
                    textColor = Color.Gray
                )
            )
        }
    }


}
