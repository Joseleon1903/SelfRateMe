package self.rate.me.compose.application.workout.cases

import android.os.Build
import androidx.annotation.RequiresApi
import self.rate.me.compose.application.database.repo.ExcerciseRepository
import self.rate.me.compose.application.workout.types.ExcerciseType
import javax.inject.Inject

class WorkoutRegisterUseCase @Inject constructor (private val exerciseRepository: ExcerciseRepository) {

    @RequiresApi(Build.VERSION_CODES.O)
    suspend operator fun invoke(excercise: ExcerciseType) : Boolean{

        println("Entering in workoutRegisterUseCase")
        println("excercise $excercise")

        val insertList = arrayListOf<ExcerciseType>();
        insertList.add(excercise)
        exerciseRepository.addExcercise(insertList)
        println("return successful")
        return true
    }

}