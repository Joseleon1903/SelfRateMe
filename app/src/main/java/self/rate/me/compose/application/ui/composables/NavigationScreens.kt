package self.rate.me.compose.application.ui.composables

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import self.rate.me.compose.application.nav.NavItem
import self.rate.me.compose.application.nav.NavTitle.ADD_WORKOUT
import self.rate.me.compose.application.ui.composables.tabs.DailyScreen
import self.rate.me.compose.application.ui.composables.tabs.NoteScreen
import self.rate.me.compose.application.ui.composables.tabs.ProfileScreen
import self.rate.me.compose.application.ui.composables.tabs.WorkoutScreen
import self.rate.me.compose.application.workout.ui.AddWorkoutScreen
import self.rate.me.compose.application.workout.ui.WorkoutViewModel


/**
 * Composable function that defines the navigation screens and their corresponding destinations.
 *
 * @param navController The navigation controller used for handling navigation between screens.
 */
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun NavigationScreens(workoutViewModel : WorkoutViewModel, navController: NavHostController) {


    NavHost(navController, startDestination = NavItem.Daily.path) {
        //bottom navigation page
        composable(NavItem.Daily.path) { DailyScreen() }
        composable(NavItem.Workout.path) { WorkoutScreen(viewModel = workoutViewModel){
            navController.navigate("ADD_WORKOUT")
         }
        }
        composable(NavItem.Task.path) { NoteScreen() }
        composable(NavItem.Profile.path) { ProfileScreen() }

        composable(ADD_WORKOUT) {
            AddWorkoutScreen(viewModel = workoutViewModel){
                navController.popBackStack()
            }
        }

    }
}