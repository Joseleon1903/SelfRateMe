package self.rate.me.compose.application.database.repo

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import self.rate.me.compose.application.database.dao.ExcerciseDao
import self.rate.me.compose.application.workout.mapper.ExcerciseMapper
import self.rate.me.compose.application.workout.types.ExcerciseEstatus
import self.rate.me.compose.application.workout.types.ExcerciseType
import javax.inject.Inject

class ExcerciseRepository @Inject constructor(
    private val excerciseDao: ExcerciseDao
){


    suspend fun getAllExcercise():List<ExcerciseType>{
        val response = excerciseDao.getAllExcercise()

        return response.map { ExcerciseMapper.toDomain(it) }
    }

    // Exponemos un Flow de dominio, mapeando de ExerciseEntity a ExerciseType
    val exercisesFlow: Flow<List<ExcerciseType>> = excerciseDao.getAllExercises()
        .map { entities ->
            entities.map { en ->
                ExcerciseType(
                    id = en.id,
                    title = en.title,
                    lastRepetitionQuantity = en.lastRepetitionQuantity,
                    quantity = en.quantity,
                    pending = en.pending,
                    status = ExcerciseEstatus.valueOf(en.status),
                    tags = en.tags
                )
            }
        }

    suspend fun addExcercise(users: List<ExcerciseType>){
        excerciseDao.insertExcercise(users.map { ExcerciseMapper.toEntity(it) })
    }

}