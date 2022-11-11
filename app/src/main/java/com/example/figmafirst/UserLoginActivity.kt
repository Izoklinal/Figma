package com.example.figmafirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Blue
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.figmafirst.ui.theme.FigmaFirstTheme
import com.example.figmafirst.ui.theme.Green

class UserLoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {


            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanelReg("Войти")
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.Center)) {
                    TextFieldPnl(txt = "Имя пользователя")
                    Spacer(modifier = Modifier.height(8.dp))
                    TextFieldPnl(txt = "Пароль")
                    Spacer(modifier = Modifier.height(8.dp))
                    GreenButton(text = "Войти")
                }
            }
        }
    }
}

@Composable
fun TextFieldPnl(txt: String) {
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
                .size(320.dp, 48.dp),
            shape = RoundedCornerShape(8.dp),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = White,
                focusedIndicatorColor =  Color.Transparent, //hide the indicator
                unfocusedIndicatorColor = White,
            textColor = Color.Gray)
        )
    }
}
