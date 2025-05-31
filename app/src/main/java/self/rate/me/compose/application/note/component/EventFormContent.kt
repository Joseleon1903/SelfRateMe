package self.rate.me.compose.application.note.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import self.rate.me.compose.application.note.ui.NoteViewModel

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventFormContent(viewModel : NoteViewModel,  navigateToScreen : () -> Unit ) {

    val eventName by viewModel.title.observeAsState( initial = "")
    val eventDate by viewModel.eventDate.observeAsState( initial = "")
    val eventContent by viewModel.content.observeAsState( initial = "")

    Column(modifier = Modifier
        .fillMaxSize()
        .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
        .background(Color.White)
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Event",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF512DA8)
        )
        Text("Enter your Event information", fontSize = 14.sp, color = Color.Gray)



        OutlinedTextField(
            value = eventName,
            onValueChange = { viewModel.onValueViewChange(it,eventContent, "" )  },
            label = { Text("Nombre del evento") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = eventContent,
            onValueChange = { viewModel.onValueViewChange(eventName,it, "" ) },
            label = { Text("Contenido del evento") },
            modifier = Modifier.fillMaxWidth()
        )

        DatePickerField(
            label = "Fecha evento",
            selectedDate = eventDate,
            onDateSelected = { viewModel.onValueDateChange(it, "") },
        )


        Spacer(modifier = Modifier.height(15.dp))

        Button(
            onClick = { /* Handle submit */
                viewModel.submitForm()
                navigateToScreen()
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(),
            shape = RoundedCornerShape(25.dp)
        ) {
            Text("Add", color = Color.White)
        }
    }
}