package com.example.smartcatmobile.view

import android.util.EventLogTags.Description
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import com.example.smartcatmobile.ui.theme.colorBackground
import com.example.smartcatmobile.ui.theme.colorTask
import com.example.smartcatmobile.R
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListaTarefas(navController: NavController) {
    var showModal by remember { mutableStateOf(false) } // incia como false, so deve aparecer ao acionar onclick
    val taskList = remember { mutableStateListOf<String>() }

    Scaffold(
        containerColor = colorBackground,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showModal = true },
                containerColor = colorTask
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.add_icon),
                    contentDescription = "Adicionar tarefa"
                )
            }
        },
        topBar = {
            Column {
                TopAppBar(
                    title = { Text(text = "Bem vindo(a) de volta") },
                    colors = TopAppBarDefaults.topAppBarColors(containerColor = colorBackground)
                )
                Text(
                    text = "Sua lista de tarefas:",
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp,),
                    style = MaterialTheme.typography.bodySmall
                )
            }







        }
    ) { paddingValues ->
        // Exibindo as tarefas salvas
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            taskList.forEach { task ->
                Text(
                    text = task,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }
    }

    // Exibe o modal  , passando a tela por navcontroller
    if (showModal) {
        SalvarTarefa(
            navController = navController,
            onDismiss = { showModal = false },
            onSave = { taskName, taskDescription ->
                val newTask = "Título: $taskName\nDescrição: $taskDescription"
                taskList.add(newTask) // Adiciona a tarefa à lista
                showModal = false // Fecha o modal
            }
        )
    }
}