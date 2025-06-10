package self.rate.me.compose.application.ui.composables.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import self.rate.me.compose.application.R
import self.rate.me.compose.application.daily.component.AssignmentCardWithSubjects
import self.rate.me.compose.application.daily.component.DailyHeader
import self.rate.me.compose.application.daily.component.SimpleCard
import self.rate.me.compose.application.daily.data.Subject

/**
 * Composable function that represents the home screen of the application.
 */
@Composable
fun DailyScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp).padding(top = 10.dp)
    ) {

        //header
        DailyHeader("Jacob", painterResource(id = R.drawable.profile_pic))

        AssignmentCardWithSubjects(
            count = 4,
            subjects = listOf(
                Subject("Physics", "11 AM - 12:30 PM", Color(0xFFD32F2F)),
                Subject("Chemistry", "1 PM - 2 PM", Color(0xFF7E57C2)),
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            SimpleCard(count = 2, title = "Assignments due")
            SimpleCard(count = 6, title = "To do items", isCheckIcon = true)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DailyScreenPreview() {

    DailyScreen()

}