package self.rate.me.compose.application.nav

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person

sealed class NavItem {
    object Daily :
        Item(path = NavPath.DAILY.toString(), title = NavTitle.DAILY, icon = Icons.Default.Person)

    object Workout :
        Item(path = NavPath.WORKOUT.toString(), title = NavTitle.WORKOUT, icon = Icons.Default.DateRange)

    object Task :
        Item(path = NavPath.NOTE.toString(), title = NavTitle.NOTE, icon = Icons.Default.List)

    object Profile :
        Item(
            path = NavPath.PROFILE.toString(), title = NavTitle.PROFILE, icon = Icons.Default.Build)

}