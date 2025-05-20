package self.rate.me.compose.application.workout.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material.Text

@Composable
fun ExcerciseTags(label: String) {
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Color.Red,
                shape = RoundedCornerShape(16.dp)
            )
            .padding(horizontal = 12.dp, vertical = 4.dp)
    ) {
        Text(text = label, color = Color.Red, style = MaterialTheme.typography.body2)
    }
}