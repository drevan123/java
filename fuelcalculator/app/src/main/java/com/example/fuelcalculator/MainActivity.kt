package com.example.fuelcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fuelcalculator.ui.theme.FuelCalculatorTheme

// Define a classe MainActivity, que é a atividade principal do aplicativo
class MainActivity : ComponentActivity() {
    // Função onCreate é chamada quando a atividade é criada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Define o conteúdo da atividade usando Jetpack Compose
        setContent {
            // Aplica o tema FuelCalculatorTheme ao conteúdo
            FuelCalculatorTheme {
                // Cria um controlador de navegação
                val navController = rememberNavController()
                // Define o NavHost, que contém os destinos de navegação
                NavHost(navController = navController, startDestination = "input_screen") {
                    // Define um destino de navegação chamado "input_screen"
                    composable("input_screen") { InputScreen(navController) }
                    // Define um destino de navegação chamado "result_screen" que aceita um parâmetro "autonomy"
                    composable("result_screen/{autonomy}") { backStackEntry ->
                        // Obtém o valor do parâmetro "autonomy" da entrada do backStack
                        val autonomy = backStackEntry.arguments?.getString("autonomy")?.toDoubleOrNull() ?: 0.0
                        // Chama a função ResultScreen, passando a autonomia e uma função de retorno que remove a tela do back stack
                        ResultScreen(autonomy) {
                            navController.popBackStack()
                        }
                    }
                }
            }
        }
    }
}

// Função que calcula a autonomia com base na distância e no combustível
fun calculateAutonomy(distance: Double, fuel: Double): Double {
    // Se o combustível for diferente de 0, retorna a divisão da distância pelo combustível. Caso contrário, retorna 0.
    return if (fuel != 0.0) distance / fuel else 0.0
}
