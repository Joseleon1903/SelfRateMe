package self.rate.me.compose.application.workout.data

data class CurrentWeekInfo(val date:String,
                           val currentDayName : String,
                           val WokroutCompleted: Int,
                           val WokroutPending: Int
)
