package com.example.appbar.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun About(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Sobre Nós",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 62.dp),

                        )
                },
            )
        },
        content = {
            Column(Modifier.padding(16.dp)) {
                // Conteúdo da tela
                Text(
                    text = "Objetivo de nosso app",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Magenta,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                )

                Text(
                    text = "Esse aplicativo tem o intuito de nos ajudar a otimizar nosso tempo na criação de nossa próprias tarefas",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp,
                    color = Color.Magenta,
                    modifier = Modifier.padding(top = 35.dp)
                )




            }
        },

        bottomBar = {
            BottomAppBar(

                content = {
                    //Botão para voltar
                    Button(
                        onClick = { navController.navigate("Main") },
                        modifier = Modifier
                            .width(190.dp)
                            .height(45.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(
                            227,
                            185,
                            235,
                            255
                        )
                        ),
                    ) {
                        Text(text = "Home",
                            color = Color.Magenta,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,

                            )
                    } //


                },


                )
        }
    )
}


@Preview(showBackground = true)
@Composable
fun AboutPreview() {
    val navController = rememberNavController() // Importe rememberNavController
    About(navController = navController)
}

