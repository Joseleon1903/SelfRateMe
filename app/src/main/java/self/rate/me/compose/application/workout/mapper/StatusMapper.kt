package self.rate.me.compose.application.workout.mapper

import self.rate.me.compose.application.workout.types.ExcerciseEstatus
import java.util.Locale

class StatusMapper {

    companion object {

        fun toDomain(status : String): ExcerciseEstatus{
            return ExcerciseEstatus.valueOf(status)
        }
        fun toEntity(status : ExcerciseEstatus): String{
            return status.toString().toUpperCase(Locale.ROOT)
        }

    }

}