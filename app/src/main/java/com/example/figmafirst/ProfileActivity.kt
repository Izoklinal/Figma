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
import androidx.compose.runtime.Composable
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
import com.example.figmafirst.ui.theme.LightGreen

class ProfileActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanelUser("Профиль пользователя")

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.BottomCenter)) {

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)) {
                        Picture()
                    }

                    Column(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(Alignment.Center)) {
                        Spacer(modifier = Modifier.height(72.dp))
                        SmallText(text = "Вход не выполнен")
                    }

                    Spacer(modifier = Modifier.height(72.dp))
                    EnterBtn(text = "Войти")
                    Spacer(modifier = Modifier.height(16.dp))
                    RegBtn(text = "Регистрация")
                    Spacer(modifier = Modifier.height(80.dp))
                }
            }
        }
    }
}

@Composable
fun Picture() {
    Image(
        painter = painterResource(R.drawable.avatar),
        contentDescription = "Avatar",
        modifier = Modifier
            .size(160.dp)
            .clip(CircleShape)
    )
}

@Composable
fun SmallText(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontWeight = FontWeight.Light
    )
}

@Composable
fun TopPanelUser(text: String) {
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
            IconButton(onClick = { /*TODO*/ }) {
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
fun EnterBtn(text: String) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        val context = LocalContext.current
        Button(onClick = {context.startActivity(Intent(context, UserLoginActivity::class.java))},
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
fun RegBtn(text: String) {
    Column (modifier = Modifier
        .fillMaxWidth()
        .wrapContentSize(Alignment.Center)) {
        val context = LocalContext.current
        Button(onClick = {context.startActivity(Intent(context, RegistrationActivity::class.java))},
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