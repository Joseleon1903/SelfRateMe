package self.rate.me.compose.application.note.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import self.rate.me.compose.application.R
import self.rate.me.compose.application.note.component.BillsFormContent
import self.rate.me.compose.application.note.component.EventFormContent
import self.rate.me.compose.application.note.component.FormNoteContent
import self.rate.me.compose.application.ui.composables.CustomTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddNoteScreen(viewModel : NoteViewModel, navigateToScreen : () -> Unit) {

    var selectedType by remember { mutableStateOf("Note") }

    val formTypes = listOf( "Note", "Event", "Bill")
    var expanded by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTopAppBar("Add Note", navigateToScreen)

            Image(
                painter = painterResource(id = R.drawable.note_taking), // imagen tipo autopista nocturna
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 300.dp)
                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
                .background(Color.White)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Selecciona el tipo de formulario", style = MaterialTheme.typography.titleMedium)


            Box {
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded }
                ) {
                    OutlinedTextField(
                        value = selectedType,
                        onValueChange = {},
                        readOnly = true,
                        label = { Text("Tipo de formulario") },
                        trailingIcon = {
                            ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                        },
                        modifier = Modifier
                            .menuAnchor()
                            .fillMaxWidth()
                    )

                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false }
                    ) {
                        formTypes.forEach { selectionOption ->
                            DropdownMenuItem(
                                text = { Text(selectionOption) },
                                onClick = {
                                    selectedType = selectionOption
                                    expanded = false
                                }
                            )
                        }
                    }
                }
            }

            // Formulario dinámico
            when (selectedType) {
                "Note" -> FormNoteContent(viewModel= viewModel, navigateToScreen= navigateToScreen)
                "Event" -> EventFormContent(viewModel= viewModel, navigateToScreen= navigateToScreen)
                "Bill" -> BillsFormContent(viewModel= viewModel, navigateToScreen= navigateToScreen)
                else -> Text("Selecciona un tipo de formulario para comenzar.")
            }

        }



    }



}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun AddNotePreview() {

    AddNoteScreen(viewModel = TODO()){
        println("Navigate back")
    }

}