package com.pabloeleo.gsandroidapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {

    var usuario by remember { mutableStateOf("") }
    var senha by remember { mutableStateOf("") }
    var mensagemErro by remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(text = "LOGIN", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(32.dp))


            OutlinedTextField(
                value = usuario,
                onValueChange = { usuario = it },
                label = { Text("Usuário") }
            )

            Spacer(modifier = Modifier.height(16.dp))


            OutlinedTextField(
                value = senha,
                onValueChange = { senha = it },
                label = { Text("Senha") },
                visualTransformation = PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(32.dp))


            Button(onClick = {

                if (usuario == "admin" && senha == "123456") {

                    mensagemErro = ""
                    navController.navigate("menu")
                } else {

                    mensagemErro = "Usuário inválido"
                }
            }) {
                Text(text = "Entrar")
            }

            Spacer(modifier = Modifier.height(16.dp))


            if (mensagemErro.isNotEmpty()) {
                Text(
                    text = mensagemErro,
                    color = Color.Red,
                    fontSize = 14.sp
                )
            }
        }
    }
}
