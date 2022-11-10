package com.example.figmafirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                Spacer(modifier = Modifier.height(108.dp))
                ButtonAdd()
                Spacer(modifier = Modifier.height(40.dp))
                BottomPanel()
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
fun BottomPanel() {
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
                Column (modifier = Modifier.padding(start = 24.dp, top = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.list),
                        contentDescription = "List",
                        modifier = Modifier
                            .size(40.dp)
                    )
                    Text(
                        text = "List",
                        color = Green,
                        modifier = Modifier
                            .width(40.dp)
                            .wrapContentSize(Alignment.Center),
                        fontSize = 10.sp
                    )
                }
                Column (modifier = Modifier.padding(start = 32.dp, top = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.clock),
                        contentDescription = "Alarm",
                        modifier = Modifier
                            .size(40.dp)
                    )
                    Text(
                        text = "Red",
                        color = Red,
                        modifier = Modifier
                            .width(40.dp)
                            .wrapContentSize(Alignment.Center),
                        fontSize = 10.sp
                    )
                }
                Column (modifier = Modifier.padding(start = 32.dp, top = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.calendar),
                        contentDescription = "List",
                        modifier = Modifier
                            .size(40.dp)
                    )
                    Text(
                        text = "Calendar",
                        color = Red,
                        modifier = Modifier
                            .width(40.dp)
                            .wrapContentSize(Alignment.Center),
                        fontSize = 10.sp
                    )
                }
                Column (modifier = Modifier.padding(start = 32.dp, top = 8.dp)) {
                    Image(
                        painter = painterResource(R.drawable.settings),
                        contentDescription = "Settings",
                        modifier = Modifier
                            .size(40.dp)
                    )
                    Text(
                        text = "Red",
                        color = Red,
                        modifier = Modifier
                            .width(40.dp)
                            .wrapContentSize(Alignment.Center),
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonAdd() {
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
                text = "Добавить задачу",
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
            fontSize = 32.sp
        )

        Spacer(modifier = Modifier.width(160.dp))

        Image(
            painter = painterResource(R.drawable.avatar),
            contentDescription = "Avatar",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
    }
}

data class Deal(val title: String,
                val description: String,
                val date: String,
                val time: String
)

@Composable
fun DealCard(deal: Deal) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center))
    {
        Card(
            modifier = Modifier
                .size(340.dp, 80.dp)
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

@Preview
@Composable
fun PreviewButtonAdd() {
    FigmaFirstTheme() {
        Surface {
            ButtonAdd()
        }
    }
}

@Preview
@Composable
fun PreviewBottomPanel() {
    FigmaFirstTheme() {
        Surface {
            BottomPanel()
        }
    }
}
