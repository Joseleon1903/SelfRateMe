package self.rate.me.compose.application.ui.composables.dialog

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp


@Composable
fun ConfirmDeleteDialog() {

    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        Text("Seguro que quieres eliminar este registro?")

    }


}