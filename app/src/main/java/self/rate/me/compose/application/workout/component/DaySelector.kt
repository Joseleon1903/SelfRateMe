package self.rate.me.compose.application.workout.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import self.rate.me.compose.application.workout.ui.WorkoutViewModel

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DaySelector(
    daysOfWeek: List<String>,
    name: String,
    quantity: String,
    rememberMe: Boolean,
    viewModel: WorkoutViewModel
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedDay by remember { mutableStateOf("") }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded }
    ) {
        // Campo que muestra el valor seleccionado
        TextField(
            value = selectedDay,
            onValueChange = {},
            readOnly = true,
            label = { Text("Selecciona un día") },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier.menuAnchor()
        )

        // Menú desplegable
        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            daysOfWeek.forEach { day ->
                DropdownMenuItem(
                    text = { Text(text = day) },
                    onClick = {
                        selectedDay = day
                        viewModel.onValueViewChange(name, quantity.toString(), day, rememberMe)
                        expanded = false
                    }
                )
            }
        }
    }
}