package com.example.smartcatmobile


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.smartcatmobile.ui.theme.SmartCatMobileTheme
import com.example.smartcatmobile.view.ListaTarefas
import com.example.smartcatmobile.view.Login
import com.example.smartcatmobile.view.SalvarTarefa

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SmartCatMobileTheme {
                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "ListaTarefas") {
                    composable(route = "Login") {
                        Login(navController)
                    }
                    composable(route = "ListaTarefas") {
                        ListaTarefas(navController)
                    }
                    composable(route = "SalvarTarefa") {
                        SalvarTarefa(
                            navController,
                            onDismiss = TODO(),
                            onSave = TODO()
                        )
                    }
                }
            }
        }
    }
}

