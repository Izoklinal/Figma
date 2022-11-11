package com.example.figmafirst

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
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
import com.example.figmafirst.ui.theme.FigmaFirstTheme
import com.example.figmafirst.ui.theme.Green

class RegistrationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanelReg("Регистрация")
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.Center)) {
                    TextFieldPnl(txt = "Имя пользователя")
                    Spacer(modifier = Modifier.height(8.dp))
                    TextFieldPnl(txt = "Адрес электронной почты")
                    Spacer(modifier = Modifier.height(8.dp))
                    TextFieldPnl(txt = "Пароль")
                    Spacer(modifier = Modifier.height(8.dp))
                    GreenButton(text = "Регистрация")
                }
            }
        }
    }
}

@Composable
fun TopPanelReg(text: String) {
    val context = LocalContext.current
    Row(modifier = Modifier.padding(all = 16.dp)) {
        Column(modifier = Modifier.padding(top = 4.dp)) {
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
            IconButton(onClick = {context.startActivity(Intent(context, ProfileActivity::class.java))}) {
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