package self.rate.me.compose.application.ui.composables.tabs

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import self.rate.me.compose.application.workout.component.CompleteSection
import self.rate.me.compose.application.workout.component.CreateFloatButton
import self.rate.me.compose.application.workout.component.WeekStatusSection
import self.rate.me.compose.application.workout.types.CompleteInfo
import self.rate.me.compose.application.workout.types.CurrentWeekInfo

/**
 * Composable function that represents the workout screen of the application.
 */
@Composable
fun WorkoutScreen(navigateToScreen : () -> Unit) {
    Box(modifier = Modifier.fillMaxSize().padding(top = 20.dp)) {

        Column {

            // week status
            WeekStatusSection(week = CurrentWeekInfo(date = "Saturday 5 2025",
                WokroutCompleted = 0, WokroutPending = 0,
                currentDayName = "Saturday")
            )

//            ExcerciseCard( excercise = ExcerciseType( title = "PUSH UP", lastRepetitionQuantity = 0, pending = 50, status = ExcerciseEstatus.PENDING,
//                listOf("Daily", "Chest")))

            CompleteSection( info = CompleteInfo(progress = 10))



        }

        //boton para agregar workout
        CreateFloatButton(navigateToScreen)

    }
}


@Preview(showBackground = true)
@Composable
fun WorkoutScreenPreview() {

  //  WorkoutScreen()

}