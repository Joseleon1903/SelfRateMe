package self.rate.me.compose.application

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import self.rate.me.compose.application.note.ui.NoteViewModel
import self.rate.me.compose.application.ui.composables.MainScreen
import self.rate.me.compose.application.ui.theme.SelfRateMeTheme
import self.rate.me.compose.application.workout.ui.WorkoutViewModel
import kotlin.getValue

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val workoutViewModel: WorkoutViewModel by viewModels()

    private val noteViewModel: NoteViewModel by viewModels()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SelfRateMeTheme {
                val navController = rememberNavController()
                Surface(modifier = Modifier.fillMaxSize()) {
                    MainScreen(workoutViewModel= workoutViewModel,noteViewModel= noteViewModel, navController = navController)
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    val navController = rememberNavController()
    SelfRateMeTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            MainScreen(workoutViewModel = TODO(), noteViewModel = TODO(), navController = navController)
        }
    }
}