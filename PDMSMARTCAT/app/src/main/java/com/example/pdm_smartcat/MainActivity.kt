package com.example.pdm_smartcat // Atualizado para o novo projeto

import TodoListPage
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.pdm_smartcat.ui.theme.PDMSMARTCATTheme // Atualize se necessário

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PDMSMARTCATTheme { // Atualize para o nome correto do tema do seu projeto
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TodoListPage() // Certifique-se de que este Composable está definido no projeto atual
                }
            }
        }
    }
}
