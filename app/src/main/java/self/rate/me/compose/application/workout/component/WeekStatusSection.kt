package self.rate.me.compose.application.workout.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import self.rate.me.compose.application.workout.types.CurrentWeekInfo


@Composable
fun WeekStatusSection(week : CurrentWeekInfo) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            // week nombre
            Text("${week.date}", style = MaterialTheme.typography.subtitle2, modifier = Modifier.weight(1f))
            Icon(Icons.Default.Star, contentDescription = null, tint = Color.Blue)

            // cantidad tareas completadas
            Text("${week.WokroutCompleted}", modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.width(8.dp))

            // cantidad tareas pendientes
            Icon(Icons.Default.Star, contentDescription = null, tint = Color(0xFFFFC107))
            Text("${week.WokroutPending}", modifier = Modifier.padding(start = 4.dp))
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            listOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun").forEachIndexed { index, day ->
                val color = when (index) {
                    0, 1, 2 -> Color.Green
                    5 -> Color(0xFFFF9800)
                    else -> Color.LightGray
                }
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(color = color.copy(alpha = 0.2f), shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = day, color = color, fontSize = 12.sp)
                }
            }
        }
    }
}