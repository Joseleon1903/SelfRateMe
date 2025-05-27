package self.rate.me.compose.application.workout.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import self.rate.me.compose.application.database.entity.ExerciseEntity
import self.rate.me.compose.application.workout.types.ExcerciseType

class ExcerciseMapper {

    companion object {

        fun toDomain(entity : ExerciseEntity): ExcerciseType{
            return ExcerciseType(entity.id, entity.title, entity.lastRepetitionQuantity,entity.quantity, entity.pending,
                StatusMapper.toDomain(entity.status), entity.tags)
        }

        fun toEntity(entity : ExcerciseType):ExerciseEntity{
            return ExerciseEntity(entity.id, entity.title, entity.lastRepetitionQuantity,entity.quantity, entity.pending,
                StatusMapper.toEntity(entity.status), entity.tags)
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun toNew(title: String?,lastRepetitionQuantity: Int,quantity: Int ,pending: Int,status: String,tags : List<String>): ExerciseEntity{
            return ExerciseEntity(0 ,title.orEmpty(), lastRepetitionQuantity,quantity,
                pending , status, tags )
        }
    }
}