package self.rate.me.compose.application.note.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun FormNoteContent(onCancel: () -> Unit, onSave: () -> Unit) {
//
//    var name by remember { mutableStateOf("") }
//    var email by remember { mutableStateOf("") }
//
//    Column(
//        modifier = Modifier
//            .padding(20.dp)
//            .fillMaxWidth(),
//        verticalArrangement = Arrangement.spacedBy(12.dp)
//    ) {
//        Text("Nuevo Registro", style = MaterialTheme.typography.titleMedium)
//
//        OutlinedTextField(
//            value = name,
//            onValueChange = { name = it },
//            label = { Text("Nombre") },
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        OutlinedTextField(
//            value = email,
//            onValueChange = { email = it },
//            label = { Text("Correo electrónico") },
//            singleLine = true,
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        Row(
//            horizontalArrangement = Arrangement.End,
//            modifier = Modifier.fillMaxWidth()
//        ) {
//            TextButton(onClick = onCancel) {
//                Text("Cancelar")
//            }
//            Spacer(modifier = Modifier.width(8.dp))
//            Button(onClick = onSave) {
//                Text("Guardar")
//            }
//        }
//    }
}