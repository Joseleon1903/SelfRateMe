package self.rate.me.compose.application.workout.types

data class ExcerciseType(val id : Int,
                         val title: String,
                         val lastRepetitionQuantity: Int,
                         val quantity: Int,
                         val pending: Int,
                         val status: ExcerciseEstatus,
                         val tags: List<String>
)
