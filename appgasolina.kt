package com.example.estudo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.estudo.ui.theme.EstudoTheme

class appgasolina : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EstudoTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    App()
                }
            }
        }
    }
}

@Composable
fun App() {

    var gasolina by remember {
        mutableStateOf("");
    }
    var alcool by remember {
        mutableStateOf("");
    }

    Column(
        Modifier
            .background(color = Color(0xFFF1BF68))
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            text = "Álcool ou Gasolina",
            style = TextStyle(
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold
            )
        )

        if (gasolina.isNotBlank() && alcool.isNotBlank()) {
            val gasolinaouAlcool = if (alcool.toDouble() / gasolina.toDouble() > 0.7) {
                "Gasolina"
            } else {
                "Alcool"
            }

            Spacer(modifier = Modifier.size(16.dp))

            Text(
                text = gasolinaouAlcool,
                style = TextStyle(
                    color = Color.Red,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.size(16.dp))

        TextField(
            value = gasolina,
            onValueChange = { novoValor ->
                gasolina = novoValor
            },
            label = {
                Text(text = "Gasolina")
            }
        )

        Spacer(modifier = Modifier.size(16.dp))

        TextField(
            value = alcool,
            onValueChange = { novoValor ->
                alcool = novoValor
            },
            label = {
                Text(text = "Alcool")
            }
        )
    }
}