package self.rate.me.compose.application.daily.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Description
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleCard(count: Int, title: String, isCheckIcon: Boolean = false) {
    Card(
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .width(130.dp) // Ancho fijo en lugar de weight
            .height(120.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ){
                Icon(
                    imageVector = if (isCheckIcon) Icons.Default.CheckCircle else Icons.Default.Description,
                    contentDescription = null
                )
                Text("$count", fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(title)

            Spacer(modifier = Modifier.height(15.dp))
            Text(
                "VIEW",
                modifier = Modifier.align(Alignment.End),
                color = Color.Gray
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleCardPreview() {

    SimpleCard( 25, "Loren impsu" , true)

}