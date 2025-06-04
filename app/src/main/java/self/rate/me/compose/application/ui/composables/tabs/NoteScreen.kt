package self.rate.me.compose.application.ui.composables.tabs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import self.rate.me.compose.application.note.component.BillCard
import self.rate.me.compose.application.note.component.EventCard
import self.rate.me.compose.application.note.component.NoteCard
import self.rate.me.compose.application.note.data.Note
import self.rate.me.compose.application.note.mapper.NoteFactory
import self.rate.me.compose.application.note.ui.NoteViewModel
import self.rate.me.compose.application.ui.composables.dialog.ConfirmDeleteDialog

/**
 * Composable function that represents the list screen of the application.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NoteScreen(viewModel : NoteViewModel,navigateToScreen : () -> Unit ) {

    val brands = listOf("All","Note","Event", "Nearest event", "Bill")

    var selectedBrand by remember { mutableStateOf("All") }

    val notes by viewModel.note.collectAsState()

    var showDialog by remember { mutableStateOf(false) }

    var selectedNote: Note by remember { mutableStateOf(NoteFactory.toCreateEmptyNote()) }

    if (showDialog) {
        AlertDialog(
            onDismissRequest = { showDialog = false },
            title = { Text("Delete") },
            text = {
                ConfirmDeleteDialog()
            },
            confirmButton = {
                Button(onClick = {
                    // Aquí puedes procesar el formulario
                    showDialog = false
                    viewModel.OndeleteNote(selectedNote)
                }) {
                    Text("Yes")
                }
            },
            dismissButton = {
                OutlinedButton(onClick = { showDialog = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(top = 20.dp)) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {

            Text(
                text = "Filter",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color(0xFF3F3D56)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                brands.forEach { brand ->
                    FilterChip(
                        selected = brand == selectedBrand,
                        onClick = {
                                    selectedBrand = brand;
                                    viewModel.onFilterChangeValue(brand)
                                  },
                        label = {
                            Text(
                                text = brand,
                                color = if (brand == selectedBrand) Color.White else Color.Black
                            )
                        },
                        colors = FilterChipDefaults.filterChipColors(
                            selectedContainerColor = Color(0xFF007BFF),
                            containerColor = Color(0xFFF0F0F0),
                            labelColor = if (brand == selectedBrand) Color.White else Color.Black
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
                }
            }

            LazyColumn {
                items(count = notes.size) { index ->
                    val ex = notes[index]
                    if(ex.type.equals("Note", true) ||ex.type.isNullOrBlank()){
                        NoteCard(ex){
                            println("press delete button")
                            showDialog = true;
                            selectedNote = ex;
                        }
                    }else if(ex.type.equals("Event", true)){
                        EventCard(ex){
                            println("press delete button")
                            showDialog = true;
                            selectedNote = ex;
                        }
                    }
                    else if(ex.type.equals("Bill", true)){
                        BillCard(ex){
                            println("press delete button")
                            showDialog = true;
                            selectedNote = ex;
                        }
                    }
                }
            }



        }

        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
            Button(
                onClick = { /* logic */
                    println("Navigation to Add Note")
                    navigateToScreen()
                },
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .padding(bottom = 120.dp, end = 15.dp)
                    .height(48.dp),
                colors = ButtonDefaults.buttonColors(Color.Green)
            ) {
                Icon(Icons.Default.AddCircle, contentDescription = null, tint = Color.DarkGray)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Add", color = Color.DarkGray)
            }
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun NoteScreenPreview() {

      NoteScreen(navigateToScreen = TODO(), viewModel = TODO())

}