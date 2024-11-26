package com.example.fuelcalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

// Define uma função composable chamada InputScreen que aceita um NavHostController
@Composable
fun InputScreen(navController: NavHostController) {
    // Cria variáveis de estado para armazenar os valores de entrada para distância e combustível
    var distance by remember { mutableStateOf("") }
    var fuel by remember { mutableStateOf("") }

    // Cria uma Box que preenche todo o tamanho disponível e centraliza o conteúdo
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Adiciona uma imagem de fundo
        Image(
            painter = painterResource(id = R.drawable.controle), // Referência ao recurso de imagem "controle"
            contentDescription = null, // Descrição da imagem, pode ser null se não for necessário
            contentScale = ContentScale.Crop, // Define a escala do conteúdo para cortar a imagem se necessário
            modifier = Modifier.fillMaxSize() // Preenche todo o tamanho disponível
        )

        // Cria uma coluna para organizar o texto e os campos de entrada verticalmente
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
            modifier = Modifier.padding(16.dp) // Adiciona padding ao redor da coluna
        ) {
            // Adiciona um texto com o título "Cálculo de Autonomia"
            Text("Cálculo de Autonomia", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp)) // Adiciona espaço vertical entre os elementos

            // Campo de entrada para a distância
            BasicTextField(
                value = distance, // Valor atual do campo de entrada
                onValueChange = { distance = it }, // Função chamada quando o valor muda
                modifier = Modifier
                    .fillMaxWidth() // Preenche toda a largura disponível
                    .padding(16.dp) // Adiciona padding ao redor do campo de entrada
                    .background(Color.White), // Define o fundo do campo de entrada como branco
                decorationBox = { innerTextField -> // Caixa de decoração para adicionar o texto de dica
                    if (distance.isEmpty()) {
                        Text("Digite a quilometragem", color = Color.Gray) // Texto de dica quando o campo está vazio
                    }
                    innerTextField() // Renderiza o campo de entrada real
                }
            )

            // Campo de entrada para o combustível
            BasicTextField(
                value = fuel, // Valor atual do campo de entrada
                onValueChange = { fuel = it }, // Função chamada quando o valor muda
                modifier = Modifier
                    .fillMaxWidth() // Preenche toda a largura disponível
                    .padding(16.dp) // Adiciona padding ao redor do campo de entrada
                    .background(Color.White), // Define o fundo do campo de entrada como branco
                decorationBox = { innerTextField -> // Caixa de decoração para adicionar o texto de dica
                    if (fuel.isEmpty()) {
                        Text("Digite a quantidade de combustível", color = Color.Gray) // Texto de dica quando o campo está vazio
                    }
                    innerTextField() // Renderiza o campo de entrada real
                }
            )

            Spacer(modifier = Modifier.height(16.dp)) // Adiciona mais espaço vertical

            // Adiciona um botão que calcula a autonomia e navega para a tela de resultado
            Button(onClick = {
                val distanceValue = distance.toDoubleOrNull() ?: 0.0 // Converte o valor da distância para Double
                val fuelValue = fuel.toDoubleOrNull() ?: 0.0 // Converte o valor do combustível para Double
                val autonomy = calculateAutonomy(distanceValue, fuelValue) // Calcula a autonomia
                navController.navigate("result_screen/$autonomy") // Navega para a tela de resultado passando a autonomia calculada
            }) {
                Text("Calcular") // Texto exibido no botão
            }
        }
    }
}
