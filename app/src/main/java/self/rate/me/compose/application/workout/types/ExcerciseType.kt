package self.rate.me.compose.application.workout.types

data class ExcerciseType(val title: String,
                         val lastRepetitionQuantity: Int,
                         val pending: Int,
                         val status: ExcerciseEstatus,
                         val tags : List<String>?
)
