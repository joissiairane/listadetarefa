package com.example.appbar.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NewTarefa(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Lista de Tarefa",
                        fontWeight = FontWeight.Bold,
                        fontSize = 27.sp,
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
                    text = "Inserir uma nova tarefa:",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Magenta,

                )

                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Nome da tarefa",
                        color = Color.Magenta,) },
                    modifier = Modifier.width(180.dp)
                        .padding(top = 15.dp)

                )

                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Descrição da tarefa",
                        color = Color.Magenta,) },
                    modifier = Modifier.width(180.dp)
                        .padding(top = 15.dp),

                )

                TextField(
                    value = "",
                    onValueChange = {},
                    label = { Text("Nome da tarefa",
                        color = Color.Magenta,) },
                    modifier = Modifier.width(180.dp)
                        .padding(top = 15.dp)

                )


            }
        },

            //bottom bar
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
                            210,
                            147,
                            221,
                            255
                        )
                        ),
                    ) {
                        Text(text = "Voltar",
                            color = Color.Magenta,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,

                            )
                    } //


                    Button( //Botão Finalizar
                        onClick = { navController.navigate("Sobre") },
                        modifier = Modifier
                            .width(198.dp)
                            .height(45.dp)
                            .padding(horizontal = 5.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(
                            210,
                            147,
                            221,
                            255
                        )),
                    ) {
                        Text(text = "Finalizar",
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
fun TarefaPreview() {
    val navController = rememberNavController() // Importe rememberNavController
    NewTarefa(navController = navController)
}