package self.rate.me.compose.application.ui.composables.tabs

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import self.rate.me.compose.application.workout.component.CompleteSection
import self.rate.me.compose.application.workout.component.CreateFloatButton
import self.rate.me.compose.application.workout.component.ExcerciseCard
import self.rate.me.compose.application.workout.component.WeekStatusSection
import self.rate.me.compose.application.workout.types.CompleteInfo
import self.rate.me.compose.application.workout.types.CurrentWeekInfo
import self.rate.me.compose.application.workout.types.ExcerciseEstatus
import self.rate.me.compose.application.workout.types.ExcerciseType
import self.rate.me.compose.application.workout.ui.WorkoutViewModel
import androidx.compose.runtime.getValue

/**
 * Composable function that represents the workout screen of the application.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WorkoutScreen(viewModel : WorkoutViewModel,navigateToScreen : () -> Unit) {

    val exercises by viewModel.exercises.collectAsState()


    Box(modifier = Modifier.fillMaxSize().padding(top = 20.dp)) {

        Column {

            // week status
            WeekStatusSection(week = CurrentWeekInfo(date = "Saturday 5 2025",
                WokroutCompleted = 0, WokroutPending = 0,
                currentDayName = "Saturday")
            )

            LazyColumn {
                items(count = exercises.size) { index ->
                    val ex = exercises[index]
                    ExcerciseCard(ex)
                }
            }


//            ExcerciseCard( excercise = ExcerciseType(
//                id = 1,
//                title = "PUSH UP",
//                lastRepetitionQuantity = 0,
//                pending = 50,
//                status = ExcerciseEstatus.PENDING,
//                quantity =0,
//                tags = listOf("Daily", "Chest"),
//            ))


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