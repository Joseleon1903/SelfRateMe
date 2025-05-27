package self.rate.me.compose.application.database.repo

import self.rate.me.compose.application.database.dao.ExcerciseDao
import self.rate.me.compose.application.workout.mapper.ExcerciseMapper
import self.rate.me.compose.application.workout.types.ExcerciseType
import javax.inject.Inject

class ExcerciseRepository @Inject constructor(
    private val excerciseDao: ExcerciseDao
){

    suspend fun getAllExcercise():List<ExcerciseType>{
        val response = excerciseDao.getAllExcercise()

        return response.map { ExcerciseMapper.toDomain(it) }
    }

    suspend fun addExcercise(users: List<ExcerciseType>){
        excerciseDao.insertExcercise(users.map { ExcerciseMapper.toEntity(it) })
    }

}