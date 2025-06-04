package self.rate.me.compose.application.note.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import self.rate.me.compose.application.R
import self.rate.me.compose.application.database.util.DateUtils
import self.rate.me.compose.application.note.data.Note
import self.rate.me.compose.application.note.mapper.NoteFactory

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun EventCard(note : Note,  OnDelete: () -> Unit) {

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.Cyan),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    )
    {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Logo (GitHub)
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.event_icon), // Debes añadir este recurso
                    contentDescription = "GitHub Logo",
                    tint = Color.White,
                    modifier = Modifier.size(50.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = note.eventDate.toString(),
                    color = Color.Red, // Rojo suave
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = note.title,
                    style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
                )
                Text(
                    text = note.content,
                    color = Color.Black,
                    style = MaterialTheme.typography.labelSmall
                )
                Text(
                    text = DateUtils.daysBetween(DateUtils.getCurrentDate(),note.eventDate.toString()).toString()+" days left",
                    color = Color.Red,
                    style = MaterialTheme.typography.labelSmall
                )
            }

            // Iconos de control (dots)
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                IconButton(onClick = {
                    println("show delete")
                    OnDelete()
                }) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "eliminar"
                    )
                }
            }
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun EventCardPreview() {

    EventCard(NoteFactory.toCreateEvent(title = "Cumpleaño maria",
        type= "Note",
        content= "Cumpleano de maria la conserje",
        creationDate ="31/01/2025",
        eventDate= "31/01/2025")
    ){
        println("press delete")
    }


}