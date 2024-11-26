package com.example.fuelcalculator.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Define um esquema de cores para o modo escuro
private val DarkColorPalette = darkColorScheme(
    primary = Color(0xFFBB86FC), // Cor primária
    onPrimary = Color.White, // Cor do texto em cima da cor primária
    primaryContainer = Color(0xFF3700B3), // Cor do contêiner primário
    secondary = Color(0xFF03DAC6) // Cor secundária
)

// Define um esquema de cores para o modo claro
private val LightColorPalette = lightColorScheme(
    primary = Color(0xFF6200EE), // Cor primária
    onPrimary = Color.White, // Cor do texto em cima da cor primária
    primaryContainer = Color(0xFF3700B3), // Cor do contêiner primário
    secondary = Color(0xFF03DAC6) // Cor secundária
)

// Define uma função composable chamada FuelCalculatorTheme para aplicar o tema do aplicativo
@Composable
fun FuelCalculatorTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // Determina se o tema escuro está ativo com base nas configurações do sistema
    content: @Composable () -> Unit // Conteúdo composable que usará este tema
) {
    // Seleciona o esquema de cores com base no tema atual
    val colors = if (darkTheme) {
        DarkColorPalette // Usa o esquema de cores escuras se o tema escuro estiver ativo
    } else {
        LightColorPalette // Usa o esquema de cores claras se o tema escuro não estiver ativo
    }

    // Aplica o MaterialTheme ao conteúdo fornecido
    MaterialTheme(
        colorScheme = colors, // Esquema de cores a ser usado
        typography = Typography, // Tipografia a ser usada
        content = content // Conteúdo que usará este tema
    )
}
