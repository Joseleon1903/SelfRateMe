package self.rate.me.compose.application.ui.composables

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import self.rate.me.compose.application.note.ui.NoteViewModel
import self.rate.me.compose.application.workout.ui.WorkoutViewModel

/**
 * Composable function that represents the main screen of the application.
 *
 * @param navController The navigation controller used for handling navigation between screens.
 */
@RequiresApi(Build.VERSION_CODES.O)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(workoutViewModel : WorkoutViewModel ,noteViewModel : NoteViewModel,
               navController: NavHostController) {
    Scaffold(bottomBar = {
        BottomAppBar { BottomNavigationBar(navController = navController) }
    }) { NavigationScreens( workoutViewModel= workoutViewModel,noteViewModel= noteViewModel,
        navController = navController)
    }
}