package self.rate.me.compose.application.note.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import self.rate.me.compose.application.database.repo.NoteRepository
import self.rate.me.compose.application.database.utils.Converters
import self.rate.me.compose.application.note.data.Note
import self.rate.me.compose.application.note.mapper.NoteFactory
import java.time.LocalDateTime
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class NoteViewModel  @Inject constructor(private val repository: NoteRepository) : ViewModel(){


    private val _title = MutableLiveData<String>();
    val title : LiveData<String> = _title;

    private val _content = MutableLiveData<String>();
    val content : LiveData<String> = _content;

    private val _notes = MutableStateFlow<List<Note>>(emptyList())
    val note: StateFlow<List<Note>> = _notes

    private val _selectedType = MutableLiveData<String>();
    val selectedType:  LiveData<String>  = _selectedType

    //event form
    private val _eventDate = MutableLiveData<String>();
    val eventDate:  LiveData<String>  = _eventDate


    //bills form
    private val _billsDate = MutableLiveData<String>();
    val billsDate:  LiveData<String>  = _billsDate

    private val _billsAmount = MutableLiveData<String>();
    val billsAmount:  LiveData<String>  = _billsAmount

    init {
        // Al instanciar el ViewModel, carga los ejercicios iniciales
        println("Entering in NoteViewModel init..")
        viewModelScope.launch {
            repository.notesFlow
                .collect { listFromDb ->
                    _notes.value = listFromDb
                }
        }

    }

    fun onValueViewChange(title: String, content: String, amount: String) {
        _title.value = title;
        _content.value = content;
        _billsAmount.value = amount
    }

    fun onValueTypeSelectedChange(selectedType: String) {
        _selectedType.value = selectedType;
        _title.value = "";
        _content.value = "";
        _billsAmount.value = ""
    }

    fun onValueDateChange(eventDate:String, billsDate:String) {
        println("Entering onValueDateChange")
        println("eventDate : $eventDate")
        println("billsDate : $billsDate")
        _eventDate.value = eventDate;
        _billsDate.value = billsDate;
    }

    fun submitForm(){
        println("Entering submitForm")
        println("param: ${title.value}")
        println("param: ${content.value}")
        println("param: ${selectedType.value}")

        if(selectedType.value.isNullOrBlank() || selectedType.value.equals("Note", true)){
            println("entering in create Note")
            val newNote = NoteFactory.toCreateNote(title.value.toString(),
                selectedType.value.toString(), content.value.toString(), Converters().fromLocalDateTime(
                                    LocalDateTime.now()).toString())

            viewModelScope.launch {
                repository.addNotes(listOf(newNote))
                println("el resultado fue $newNote")
            }
        }

        if(selectedType.value.equals("Event", true)){
            println("entering in create Event")
            val newNote = NoteFactory.toCreateEvent(title.value.toString(),
                selectedType.value.toString(), content.value.toString(), Converters().fromLocalDateTime(
                    LocalDateTime.now()).toString(), eventDate.value.toString()
            )

            viewModelScope.launch {
                repository.addNotes(listOf(newNote))
                println("el resultado fue $newNote")
            }
        }

        if(selectedType.value.equals("Bill", true)){
            println("entering in create Bills")
            val newNote = NoteFactory.toCreateBills(title.value.toString(),
                selectedType.value.toString(), content.value.toString(), Converters().fromLocalDateTime(
                    LocalDateTime.now()).toString(), billsDate.value.toString(),
                billsAmount.value?.toDouble() ?: 0.0
            )

            viewModelScope.launch {
                repository.addNotes(listOf(newNote))
                println("el resultado fue $newNote")
            }
        }

    }

}