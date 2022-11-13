package com.example.figmafirst

import android.bluetooth.le.AdvertiseSettings
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmafirst.ui.theme.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanel("Список дел")
                Spacer(modifier = Modifier.height(40.dp))
                AllCards()
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.BottomCenter)) {
                    AddTaskBtn("Добавить задачу")
                    Spacer(modifier = Modifier.height(40.dp))
                    BottomPanel(true, false, false, false)
                }

            }
        }
    }
}

@Composable
fun AllCards() {
    DealCard(Deal("Вечерний поход в кино",
        "Идем в кино с коллегами!",
        "10.02.2021",
        "19:40"))
    Spacer(modifier = Modifier.height(16.dp))
    DealCard(Deal("Забрать заказ Ozon",
        "Пункт выдачи на ул. Ленина, 103",
        "10.02.2021",
        "19:40"))
    Spacer(modifier = Modifier.height(16.dp))
    DealCard(Deal("Запись в автосервис",
        "Сдать автомобиль в автосервис на ул.\n" +
                "Бисертская, д. 14. Замена масла",
        "10.02.2021",
        "19:40"))
}

@Composable
fun BottomPanel(list: Boolean, clock: Boolean, calendar: Boolean, settings: Boolean) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Card(modifier = Modifier
            .size(340.dp, 80.dp)
            .clip(
                RoundedCornerShape(
                    topStart = 30.dp,
                    topEnd = 30.dp,
                    bottomEnd = 0.dp,
                    bottomStart = 0.dp,
                )
            ),
            backgroundColor = LightGreen) {
            Row(modifier = Modifier.padding(all = 8.dp)) {
                val context = LocalContext.current
                if (list) {
                    Column (modifier = Modifier.padding(start = 24.dp)) {
                        IconButton(
                            onClick = {context.startActivity(Intent(context, MainActivity::class.java))}){
                            Image(
                                painter = painterResource(
                                    R.drawable.list_green
                                ),
                                contentDescription = "list",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "List",
                            color = Green,
                            modifier = Modifier
                                .width(50.dp)
                                .wrapContentSize(Alignment.Center),
                            fontSize = 10.sp
                        )
                    }
                } else {
                    Column (modifier = Modifier.padding(start = 24.dp)) {
                        IconButton(
                            onClick = {context.startActivity(Intent(context, MainActivity::class.java))}){
                            Image(
                                painter = painterResource(
                                    R.drawable.list_red
                                ),
                                contentDescription = "list",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "List",
                            color = Red,
                            modifier = Modifier
                                .width(50.dp)
                                .wrapContentSize(Alignment.Center),
                            fontSize = 10.sp
                        )
                    }
                }

                if (clock) {
                    Column (modifier = Modifier.padding(start = 24.dp)) {
                        IconButton(
                            onClick = {context.startActivity(Intent(context, AlarmActivity::class.java))}){
                            Image(
                                painter = painterResource(
                                    R.drawable.clock_green
                                ),
                                contentDescription = "clock",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "Clock",
                            color = Green,
                            modifier = Modifier
                                .width(50.dp)
                                .wrapContentSize(Alignment.Center),
                            fontSize = 10.sp
                        )
                    }
                } else {
                    Column (modifier = Modifier.padding(start = 24.dp)) {
                        IconButton(
                            onClick = {context.startActivity(Intent(context, AlarmActivity::class.java))}){
                            Image(
                                painter = painterResource(
                                    R.drawable.clock_red
                                ),
                                contentDescription = "clock",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "Clock",
                            color = Red,
                            modifier = Modifier
                                .width(50.dp)
                                .wrapContentSize(Alignment.Center),
                            fontSize = 10.sp
                        )
                    }
                }

                if (calendar) {
                    Column (modifier = Modifier.padding(start = 24.dp)) {
                        IconButton(
                            onClick = {context.startActivity(Intent(context, CalendarActivity::class.java))}){
                            Image(
                                painter = painterResource(
                                    R.drawable.calendar_green
                                ),
                                contentDescription = "calendar",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "Calendar",
                            color = Green,
                            modifier = Modifier
                                .width(50.dp)
                                .wrapContentSize(Alignment.Center),
                            fontSize = 10.sp
                        )
                    }
                } else {
                    Column (modifier = Modifier.padding(start = 24.dp)) {
                        IconButton(
                            onClick = {context.startActivity(Intent(context, CalendarActivity::class.java))}){
                            Image(
                                painter = painterResource(
                                    R.drawable.calendar_red
                                ),
                                contentDescription = "calendar",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "Calendar",
                            color = Red,
                            modifier = Modifier
                                .width(50.dp)
                                .wrapContentSize(Alignment.Center),
                            fontSize = 10.sp
                        )
                    }
                }

                if (settings) {
                    Column (modifier = Modifier.padding(start = 24.dp)) {
                        IconButton(
                            onClick = {context.startActivity(Intent(context, SettingsActivity::class.java))}){
                            Image(
                                painter = painterResource(
                                    R.drawable.settings_green
                                ),
                                contentDescription = "settings",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "Settings",
                            color = Green,
                            modifier = Modifier
                                .width(50.dp)
                                .wrapContentSize(Alignment.Center),
                            fontSize = 10.sp
                        )
                    }
                } else {
                    Column (modifier = Modifier.padding(start = 24.dp)) {
                        IconButton(
                            onClick = {context.startActivity(Intent(context, SettingsActivity::class.java))}){
                            Image(
                                painter = painterResource(
                                    R.drawable.settings_red
                                ),
                                contentDescription = "settings",
                                modifier = Modifier
                                    .size(40.dp)
                            )
                        }
                        Text(
                            text = "Settings",
                            color = Red,
                            modifier = Modifier
                                .width(50.dp)
                                .wrapContentSize(Alignment.Center),
                            fontSize = 10.sp
                        )
                    }
                }

            }
        }
    }
}

@Composable
fun GreenButton(text: String) {
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

@Composable
fun AddTaskBtn(text: String) {
    val context = LocalContext.current
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        Button(onClick = { context.startActivity(Intent(context, AddTaskActivity::class.java)) },
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
fun TopPanel(text: String) {
    Row(modifier = Modifier.padding(all = 16.dp)) {
        Text(
            text = text,
            color = MaterialTheme.colors.surface,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp
        )

        val context = LocalContext.current
        Column(modifier = Modifier
            .fillMaxWidth()
            .wrapContentSize(Alignment.CenterEnd)) {
            IconButton(
                onClick = {context.startActivity(Intent(context, ProfileActivity::class.java))}) {
                Image(
                    painter = painterResource(R.drawable.avatar1),
                    contentDescription = "Avatar",
                    modifier = Modifier
                        .size(50.dp))
            }
        }

    }
}

data class Deal(val title: String,
                val description: String,
                val date: String,
                val time: String
)

@Composable
fun DealCard(deal: Deal) {
    val context = LocalContext.current
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center))
    {
        Card(
            modifier = Modifier
                .size(340.dp, 80.dp)
                .clickable { context.startActivity(Intent(context, EditTaskActivity::class.java)) }
                .clip(
                    RoundedCornerShape(
                        topStart = 30.dp,
                        topEnd = 0.dp,
                        bottomEnd = 30.dp,
                        bottomStart = 0.dp,
                    )
                ),
            backgroundColor = Yellow
        ){
            Row(modifier = Modifier.padding(all = 16.dp)) {
                Column (modifier = Modifier.width(220.dp)) {
                    Text(
                        text = deal.title,
                        color = MaterialTheme.colors.background,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = deal.description,
                        color = MaterialTheme.colors.background,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Column {
                    Text(
                        text = deal.date,
                        color = MaterialTheme.colors.background,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                    Text(
                        text = deal.time,
                        color = MaterialTheme.colors.background,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }

        }
    }
}

@Preview
@Composable
fun PreviewDealCard() {
    FigmaFirstTheme() {
        Surface {
            AllCards()
        }
    }
}

