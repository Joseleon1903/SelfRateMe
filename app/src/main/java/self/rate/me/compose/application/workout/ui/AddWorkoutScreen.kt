package self.rate.me.compose.application.workout.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material3.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material.Button
//import androidx.compose.material.ButtonDefaults
//import androidx.compose.material.DropdownMenuItem
//import androidx.compose.material.ExperimentalMaterialApi
//import androidx.compose.material.ExposedDropdownMenuBox
//import androidx.compose.material.ExposedDropdownMenuDefaults
//import androidx.compose.material.OutlinedTextField
//import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Checkbox
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import self.rate.me.compose.application.R
import self.rate.me.compose.application.ui.composables.CustomTopAppBar

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AddWorkoutScreen(viewModel : WorkoutViewModel, navigateToScreen : () -> Unit) {

    val name : String by viewModel.name.observeAsState( initial = "")

    val quantity : String by viewModel.quantity.observeAsState( initial = "")

    val selectedDay : String by viewModel.selectedDay.observeAsState( initial = "")

    val rememberMe: Boolean by viewModel.rememberMe.observeAsState( initial = false)
   // ComboBox: Día de la semana
    val daysOfWeek : List<String> by viewModel.daysOfWeek.observeAsState( initial = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"))
    var expanded by remember { mutableStateOf(false) }


    //couritine
    val scope = rememberCoroutineScope()

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CustomTopAppBar("Add Workout", navigateToScreen)

            Image(
                painter = painterResource(id = R.drawable.gimnastic_body), // imagen tipo autopista nocturna
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
        }

        /// formulario

//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(top = 300.dp)
//                .clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
//                .background(Color.White)
//                .padding(16.dp),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text("Exercise", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF512DA8))
//            Text("Enter your workout information", fontSize = 14.sp, color = Color.Gray)
//
//            Spacer(modifier = Modifier.height(16.dp))
//            OutlinedTextField(
//                value = name,
//                onValueChange = {  viewModel.onValueViewChange(it, quantity, selectedDay, rememberMe) },
//                label = { Text("Escercise Name") },
//                modifier = Modifier.fillMaxWidth(),
//                trailingIcon = {
//                    Icon(Icons.Default.Check, contentDescription = null)
//                }
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            OutlinedTextField(
//                value = quantity,
//                onValueChange = {  viewModel.onValueViewChange(name, it, selectedDay, rememberMe) },
//                label = { Text("Reps Quantity") },
//                modifier = Modifier.fillMaxWidth(),
//                trailingIcon = {
//                    Icon(Icons.Default.Check, contentDescription = null)
//                }
//            )
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            // ComboBox: Día de la semana
//            ExposedDropdownMenuBox(
//                expanded = expanded,
//                onExpandedChange = { expanded = !expanded }
//            ) {
//                OutlinedTextField(
//                    value = selectedDay,
//                    onValueChange = {},
//                    readOnly = true,
//                    label = { Text("Day of the week") },
//                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
//                    modifier = Modifier.fillMaxWidth()
//                )
//                ExposedDropdownMenu(
//                    expanded = expanded,
//                    onDismissRequest = { expanded = false }
//                ) {
//                    daysOfWeek.forEach { day ->
//                        DropdownMenuItem(onClick = {
//                            viewModel.onValueViewChange(name, quantity, day, rememberMe)
//                            expanded = false
//                        }) {
//                            Text(text = day)
//                        }
//                    }
//                }
//            }
//
//            Spacer(modifier = Modifier.height(8.dp))
//
//            Row(
//                modifier = Modifier.fillMaxWidth(),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.SpaceBetween
//            ) {
//                Row(verticalAlignment = Alignment.CenterVertically) {
//                    Checkbox(
//                        checked = rememberMe,
//                        onCheckedChange =  {  viewModel.onValueViewChange(name, quantity, selectedDay, it) }
//                    )
//                    Text("Remember me", fontSize = 14.sp)
//                }
//
//            }
//
//            Spacer(modifier = Modifier.height(16.dp))
//
//            Button(
//                onClick = { /* Handle submit */
//                    { scope.launch {  viewModel.submitForm() } }
//                    navigateToScreen()
//                },
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(50.dp),
//                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF512DA8)),
//                shape = RoundedCornerShape(25.dp)
//            ) {
//                Text("Add", color = Color.White)
//            }
////
////            Spacer(modifier = Modifier.height(16.dp))
////
////            Text("Or Login with", color = Color.Gray, fontSize = 14.sp)
//        }


    }


}


@Preview(showBackground = true)
@Composable
fun AddWorkoutPreview() {

    AddWorkoutScreen(viewModel = TODO()){
        println("Navigate back")
    }

}