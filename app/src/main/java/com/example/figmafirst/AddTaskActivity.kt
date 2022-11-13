package com.example.figmafirst

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.figmafirst.ui.theme.FigmaFirstTheme
import com.example.figmafirst.ui.theme.Green

class AddTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanelTask("Добавить задачу")

                TextFieldPnl(txt = "Заголовок задачи")
                Spacer(modifier = Modifier.height(8.dp))
                DateTimePanel("16:30", "14.01.2021")
                Spacer(modifier = Modifier.height(8.dp))
                BigTextFieldPnl("Описание задачи")

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)) {
                    GreenButton(text = "Записать задачу")
                }

            }
        }
    }
}

@Composable
fun BigTextFieldPnl(txt: String) {
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
                .size(320.dp, 80.dp),
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
fun TopPanelTask(text: String) {
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
            IconButton(onClick = {context.startActivity(Intent(context, AddTaskActivity::class.java))}) {
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