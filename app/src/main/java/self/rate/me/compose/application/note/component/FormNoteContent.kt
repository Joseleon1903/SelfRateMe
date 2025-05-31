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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
fun FormNoteContent(viewModel : NoteViewModel,  navigateToScreen : () -> Unit ) {

    val title : String by viewModel.title.observeAsState( initial = "")

    val content : String by viewModel.content.observeAsState( initial = "")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Note",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF512DA8)
        )
        Text("Enter your Note information", fontSize = 14.sp, color = Color.Gray)

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = title,
            onValueChange = {
                viewModel.onValueViewChange(
                    it,
                    content,
                    ""
                )
            },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(Icons.Default.Check, contentDescription = null)
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = content,
            onValueChange = { viewModel.onValueViewChange( title, it, "") },
            label = { Text("Content") },
            modifier = Modifier.fillMaxWidth(),
            trailingIcon = {
                Icon(Icons.Default.Check, contentDescription = null)
            }
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