package com.example.figmafirst

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.figmafirst.ui.theme.FigmaFirstTheme
import com.example.figmafirst.ui.theme.Green

class EditTaskActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(modifier = Modifier
                .background(Green)
                .fillMaxSize()) {
                TopPanelTask("Изменить задачу")

                TextFieldPnl(txt = "Заголовок задачи")
                Spacer(modifier = Modifier.height(8.dp))
                DateTimePanel("16:30", "14.01.2021")
                Spacer(modifier = Modifier.height(8.dp))
                BigTextFieldPnl("Описание задачи")

                Column(modifier = Modifier
                    .fillMaxHeight()
                    .wrapContentSize(Alignment.BottomCenter)
                    .padding(bottom = 32.dp)) {
                    RedButton(text = "Удалить задачу")
                    Spacer(modifier = Modifier.height(16.dp))
                    GreenButton(text = "Записать задачу")
                }

            }
        }
    }
}
