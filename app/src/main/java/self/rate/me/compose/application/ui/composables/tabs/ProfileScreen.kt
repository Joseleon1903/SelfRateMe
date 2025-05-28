package self.rate.me.compose.application.ui.composables.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import self.rate.me.compose.application.ui.theme.md_theme_light_onTertiaryContainer
import self.rate.me.compose.application.ui.theme.typography

/**
 * Composable function that represents the list screen of the application.
 */
@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize().padding(top = 20.dp), contentAlignment = Alignment.Center) {

        Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {

            Text(
                text = "Profile",
                style = typography.titleLarge,
                color = md_theme_light_onTertiaryContainer
            )

            Text(
                text = "Software Version",
                style = typography.bodyMedium,
                color = md_theme_light_onTertiaryContainer
            )

            Text(
                text = "Version: 0.0.0.1-Prototype",
                style = typography.bodyMedium,
                color = md_theme_light_onTertiaryContainer
            )

        }


    }
}

@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {

    ProfileScreen()

}