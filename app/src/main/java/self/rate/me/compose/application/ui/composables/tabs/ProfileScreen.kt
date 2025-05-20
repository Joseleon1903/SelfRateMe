package self.rate.me.compose.application.ui.composables.tabs

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import self.rate.me.compose.application.R
import self.rate.me.compose.application.ui.theme.md_theme_light_inversePrimary
import self.rate.me.compose.application.ui.theme.md_theme_light_onTertiaryContainer
import self.rate.me.compose.application.ui.theme.typography
import self.rate.me.compose.application.workout.component.CompleteSection
import self.rate.me.compose.application.workout.component.ExcerciseCard
import self.rate.me.compose.application.workout.component.WeekStatusSection
import self.rate.me.compose.application.workout.types.CompleteInfo
import self.rate.me.compose.application.workout.types.CurrentWeekInfo
import self.rate.me.compose.application.workout.types.ExcerciseEstatus
import self.rate.me.compose.application.workout.types.ExcerciseType

/**
 * Composable function that represents the list screen of the application.
 */
@Composable
fun ProfileScreen() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

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