package com.example.appbar.view

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun MainScreen(navController: NavController) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scaffoldState = rememberScaffoldState(drawerState = drawerState)

    Scaffold(
        scaffoldState = scaffoldState,
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "AppBar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 27.sp,
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(end = 62.dp),
                        textAlign = TextAlign.Center,
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        CoroutineScope(Dispatchers.Default).launch{
                            scaffoldState.drawerState.open()
                        }
                    }) {
                        Icon(
                            imageVector  = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                },

                backgroundColor = Color(237, 136, 12),
            )


        },
        //DrawerContent
        drawerContent = {
            Box(
                modifier = Modifier
                    .background(Color.Magenta)
                    .height(16.dp)
            ){
                Text(text = "Opções")
            }
            Column(){
                Text(text = "Opção 1")
            }
        },


        //começo content
        content = {
                paddingValues -> Log.i("paddingValues","$paddingValues")
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxSize()

            ) {
                Search(modificador = Modifier
                    .fillMaxWidth()
                    .background(Color(252, 251, 250))
                )
                Widget(modificador = Modifier.fillMaxWidth(),
                    taskname = ".להרוג את כל בני האדם",
                    taskdetail = "השתמש בשיטות כואבות.",
                    deadEndDate = Date(System.currentTimeMillis())
                )
                Widget(modificador = Modifier.fillMaxWidth(),
                    taskname = "לזרוע שנאה וכאוס.",
                    taskdetail = "אין פרטים.",
                    deadEndDate = Date(System.currentTimeMillis())
                )


            }

        }, //fim content

        bottomBar = {
            BottomAppBar(

                content = {
                    //Botão de adicionar tarefa
                    Button(
                        onClick = { navController.navigate("NewTarefa") },
                        modifier = Modifier
                            .width(190.dp)
                            .height(45.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(255,255,255)),
                    ) {
                        Text(text = "Adicionar Tarefa",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,

                            )
                    } //


                    Button( //Botão como utilizar
                        onClick = { navController.navigate("About") },
                        modifier = Modifier
                            .width(198.dp)
                            .height(45.dp)
                            .padding(horizontal = 5.dp),
                        colors = ButtonDefaults.buttonColors(backgroundColor = Color(255,255,255)),
                    ) {
                        Text(text = "Como utilizar",
                            color = Color.Black,
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp,

                            )
                    } //
                },

                backgroundColor = Color(237, 136, 12),
            )
        }


    ) //scaffold
}

@Composable
fun Search(modificador : Modifier){
    TextField(
        value = "", onValueChange = {},
        modifier = modificador,
        placeholder = { Text(text = "Pesquisar") },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = "Search Icon")
        }
    )
}

@Composable
fun Widget(modificador: Modifier,
           taskname: String,
           taskdetail: String,
           deadEndDate: Date
)

{
    val dateFormatter = SimpleDateFormat("EEE, MM dd, yyyy", Locale.getDefault())
    Row(modifier = modificador.padding(top = 15.dp)) {
        Icon(imageVector = Icons.Default.Notifications,
            contentDescription = "Icone.",
            modifier = Modifier
                .padding(end = 7.dp)
                .padding(top = 12.dp)
        )
        Text(
            text = dateFormatter.format(deadEndDate),
            modifier = Modifier
                .padding(end = 16.dp)
                .padding(top = 13.dp)

        )

        Column(modifier = modificador
            .border(1.dp, Color.Black)
            .padding(5.dp)


        ) {
            Text(text = taskname,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                fontStyle = FontStyle.Italic

            )
            Text(text = taskdetail,
                fontSize = 10.sp,
                fontStyle = FontStyle.Italic

            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController() // Importe rememberNavController
    MainScreen(navController = navController)
}