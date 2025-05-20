package self.rate.me.compose.application.workout.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CreateFloatButton(navigateToScreen : () -> Unit) {

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomEnd) {
        Button(
            onClick = { /* logic */
                println("Navigation to Add workout screen")
                navigateToScreen()
            },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .padding(bottom = 120.dp, end = 15.dp)

                .height(48.dp),
            colors = ButtonDefaults.buttonColors()
        ) {
            Icon(Icons.Default.AddCircle, contentDescription = null, tint = Color.Red)
            Spacer(modifier = Modifier.width(8.dp))
            Text("Add", color = Color.Green)
        }
    }

}