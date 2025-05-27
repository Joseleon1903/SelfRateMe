package self.rate.me.compose.application.workout.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import self.rate.me.compose.application.workout.cases.WorkoutRegisterUseCase
import self.rate.me.compose.application.workout.types.ExcerciseEstatus
import self.rate.me.compose.application.workout.types.ExcerciseType
import javax.inject.Inject

@HiltViewModel
class WorkoutViewModel  @Inject constructor(private val register: WorkoutRegisterUseCase) : ViewModel(){

    private val _name = MutableLiveData<String>();
    val name : LiveData<String> = _name;

    private val _quantity = MutableLiveData<String>();
    val quantity : LiveData<String> = _quantity;

    private val _selectedDay = MutableLiveData<String>();
    val selectedDay : LiveData<String> = _selectedDay;

    private val _daysOfWeek = MutableLiveData<List<String>>();
    val daysOfWeek : LiveData<List<String>> = _daysOfWeek;

    private val _rememberMe = MutableLiveData<Boolean>();
    val rememberMe : LiveData<Boolean> = _rememberMe;

    fun onValueViewChange(name:String, quantity :String, selectedDay:String, rememberMe: Boolean){
        //asignando valores
        _name.value = name;
        _quantity.value = quantity;
        _selectedDay.value = selectedDay;
        _rememberMe.value = rememberMe;
    }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun submitForm(){
        println("entering in submitForm")
        println("param: ${name.value}")
        println("param: ${quantity.value}")
        println("param: ${selectedDay.value}")
        println("param: ${rememberMe.value}")

        val quantiryNum= quantity.value?.toInt()

        val newExcerciseType = ExcerciseType(0, name.value.orEmpty(),0, 1,1, ExcerciseEstatus.PENDING)
        val result = register.invoke(newExcerciseType)

        println("el resultado fue $result")

    }

}