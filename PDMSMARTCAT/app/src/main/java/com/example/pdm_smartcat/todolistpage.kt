import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculadora.Todo
import com.example.calculadora.getFakeTodo
import com.example.pdm_smartcat.R
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun TodoListPage() {
    val todoList = getFakeTodo()

    Column(
        modifier = Modifier
            .fillMaxHeight()
            .padding(8.dp)
    ) {
        LazyColumn {
            itemsIndexed(todoList) { _, item: Todo ->
                TodoItem(item = item)
            }
        }
    }
}

@Composable
fun TodoItem(item: Todo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .padding(16.dp)
    ) {
        Column {
            Text(
                text = SimpleDateFormat("HH:mm a, dd/MM", Locale.ENGLISH)
                    .format(item.createdAt),
                fontSize = 10.sp,
                color = Color.Black
            )
            Text(
                text = item.title,
                fontSize = 20.sp,
                color = Color.Magenta
            )
            IconButton(onClick = {}) {
                Icon(painter = painterResource(id = R.drawable.baseline_delete_forever_24), contentDescription = "Apagar")
            }
        }
    }
}
