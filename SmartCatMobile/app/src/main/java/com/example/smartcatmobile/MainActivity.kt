package com.example.smartcatmobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
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
        enableEdgeToEdge()
        setContent {
            SmartCatMobileTheme {
               // rotas serao configuradas aqui

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "Login" ){  // primeira tela como Login
                    composable(
                        route = "Login"              // cada funcao composable define nossas rotas
                    ){
                        Login(navController)
                    }


                    composable(
                        route = "ListaTarefas"
                    ){
                        ListaTarefas(navController)
                    }
                    composable(
                        route = "SalvarTarefa"
                    ){
                        SalvarTarefa(navController)
                    }



                }
            }
        }
    }
}

