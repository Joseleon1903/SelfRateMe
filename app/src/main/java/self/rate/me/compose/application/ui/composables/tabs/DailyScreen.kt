package self.rate.me.compose.application.ui.composables.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import self.rate.me.compose.application.R
import self.rate.me.compose.application.ui.theme.md_theme_light_error
import self.rate.me.compose.application.ui.theme.typography
/**
 * Composable function that represents the home screen of the application.
 */
@Composable
fun DailyScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(
            text = stringResource(id = R.string.daily),
            style = typography.titleLarge,
            color = md_theme_light_error
        )
    }
}