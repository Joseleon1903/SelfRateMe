package self.rate.me.compose.application.ui.composables.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import self.rate.me.compose.application.R
import self.rate.me.compose.application.ui.theme.md_theme_light_inversePrimary
import self.rate.me.compose.application.ui.theme.typography

/**
 * Composable function that represents the list screen of the application.
 */
@Composable
fun  NoteScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(id = R.string.task),
            style = typography.titleLarge,
            color = md_theme_light_inversePrimary
        )
    }
}