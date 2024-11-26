package com.example.fuelcalculator

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Define uma função composable chamada ResultScreen que aceita a autonomia e uma função onBack
@Composable
//Função ResultScreen: Uma função composable que exibe a tela de resultado.
fun ResultScreen(autonomy: Double, onBack: () -> Unit) {
    // Cria uma Box que preenche todo o tamanho disponível e centraliza o conteúdo
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // Image: Exibe uma imagem de fundo. A imagem é carregada a partir dos recursos do aplicativo
        Image(
            painter = painterResource(id = R.drawable.estrada), // Referência ao recurso de imagem "estrada"
            contentDescription = null, // Descrição da imagem, pode ser null se não for necessário
            contentScale = ContentScale.Crop, // Define a escala do conteúdo para cortar a imagem se necessário
            modifier = Modifier.fillMaxSize() // Preenche todo o tamanho disponível
        )

        // Cria uma coluna para organizar o texto e o botão verticalmente
        Column(
            horizontalAlignment = Alignment.CenterHorizontally, // Centraliza horizontalmente
            modifier = Modifier.padding(16.dp) // Adiciona padding ao redor da coluna
        ) {
            // Exibe texto na tela. O primeiro Text exibe o título "Resultado" com tamanho e peso de fonte definidos.
            Text("Resultado", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp)) // Adiciona espaço vertical entre os elementos

            // Adiciona um texto para exibir a autonomia formatada
            Text("Autonomia: %.2f km/l".format(autonomy), fontSize = 20.sp, color = Color.White)
            //Aqui, usado para criar espaço entre o título e o texto de autonomia, e entre o texto de autonomia e o botão.
            Spacer(modifier = Modifier.height(16.dp)) // Adiciona mais espaço vertical

            // Adiciona um botão que chama a função onBack quando clicado
            Button(onClick = onBack) {
                Text("Voltar")
            }
        }
    }
}
