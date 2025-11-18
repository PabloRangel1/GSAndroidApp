package com.pabloeleo.gsandroidapp.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.DecimalFormat

@Composable
fun ImcScreen(navController: NavController) {

    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultadoImc by remember { mutableStateOf("") }

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Calculadora IMC", fontSize = 24.sp)

            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Seu nome") }
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = peso,
                onValueChange = { peso = it },
                label = { Text("Seu Peso (ex: 70.5)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = altura,
                onValueChange = { altura = it },
                label = { Text("Sua altura (ex: 1.75)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Button(onClick = {
                val pesoDouble = peso.toDoubleOrNull()
                val alturaDouble = altura.toDoubleOrNull()

                if (nome.isNotBlank() && pesoDouble != null && alturaDouble != null && alturaDouble > 0) {
                    val imc = pesoDouble / (alturaDouble * alturaDouble)
                    val df = DecimalFormat("#.##")
                    resultadoImc = "$nome, seu IMC é ${df.format(imc)}"
                } else {
                    resultadoImc = "Por favor, preencha todos os campos corretamente."
                }
            }) {
                Text(text = "Calcular")
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Voltar")
            }

            Spacer(modifier = Modifier.height(32.dp))

            if (resultadoImc.isNotEmpty()) {
                Text(text = resultadoImc, fontSize = 18.sp)
            }
        }
    }
}
