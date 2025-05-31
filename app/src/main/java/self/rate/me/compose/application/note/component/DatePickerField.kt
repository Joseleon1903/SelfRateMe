package self.rate.me.compose.application.note.component

import android.app.DatePickerDialog
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import self.rate.me.compose.application.note.ui.NoteViewModel
import java.util.Calendar

@Composable
fun DatePickerField(label: String, selectedDate: String, onDateSelected: (String) -> Unit) {

    val context = LocalContext.current
    val calendar = Calendar.getInstance()

    val datePickerDialog = remember {
        DatePickerDialog(
            context,
            { _, year, month, dayOfMonth ->
                val formattedDate = String.format("%02d/%02d/%04d", dayOfMonth, month + 1, year)
                onDateSelected(formattedDate)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
    }

    OutlinedTextField(
        value = selectedDate,
        onValueChange = { println("onclick function 1") },
        readOnly = true,
        label = { Text(label) },
        modifier = Modifier
            .fillMaxWidth(),
        trailingIcon = {
            IconButton(onClick = {
                println("show datePicker")
                datePickerDialog.show()
            }) {
                Icon(
                    imageVector = Icons.Default.DateRange,
                    contentDescription = "Seleccionar fecha"
                )
            }
        }
    )

}