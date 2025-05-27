package self.rate.me.compose.application.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import self.rate.me.compose.application.database.entity.ExerciseEntity

@Dao
interface ExcerciseDao {

    @Query("select * from Exercise_tbl order by id desc")
    suspend fun getAllExcercise(): List<ExerciseEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExcercise(users: List<ExerciseEntity>)

    @Query("select * from Exercise_tbl order by id desc")
    fun getAllExercises(): Flow<List<ExerciseEntity>>

}