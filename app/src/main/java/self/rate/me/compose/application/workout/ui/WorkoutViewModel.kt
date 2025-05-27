package self.rate.me.compose.application.workout.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import self.rate.me.compose.application.database.repo.ExcerciseRepository
import self.rate.me.compose.application.workout.cases.WorkoutRegisterUseCase
import self.rate.me.compose.application.workout.types.ExcerciseEstatus
import self.rate.me.compose.application.workout.types.ExcerciseType
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class WorkoutViewModel  @Inject constructor(private val register: WorkoutRegisterUseCase,
                                            private val repository: ExcerciseRepository) : ViewModel(){

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

    private val _exercises = MutableStateFlow<List<ExcerciseType>>(emptyList())
    val exercises: StateFlow<List<ExcerciseType>> = _exercises

    init {
        // Al instanciar el ViewModel, carga los ejercicios iniciales
        println("Entering in view model init..")
        viewModelScope.launch {
            repository.exercisesFlow
                .collect { listFromDb ->
                    _exercises.value = listFromDb
                }
        }

    }

    fun onValueViewChange(name:String, quantity :String, selectedDay:String, rememberMe: Boolean){
        //asignando valores
        _name.value = name;
        _quantity.value = quantity;
        _selectedDay.value = selectedDay;
        _rememberMe.value = rememberMe;
    }

    fun submitForm(){
        println("entering in submitForm")
        println("param: ${name.value}")
        println("param: ${quantity.value}")
        println("param: ${selectedDay.value}")
        println("param: ${rememberMe.value}")

        var quantiryNum:Int =quantity.value?.toInt()!!

        val newExcerciseType = ExcerciseType(0, name.value.orEmpty(),0, quantiryNum,quantiryNum, ExcerciseEstatus.PENDING, emptyList())

        viewModelScope.launch {
            val result =   register.invoke(newExcerciseType)
            println("el resultado fue $result")
        }

    }

}