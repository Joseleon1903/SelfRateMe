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

    fun onValueViewChange(title: String, content: String) {
        _title.value = title;
        _content.value = content;
    }

    fun submitForm(){
        println("Entering submitForm")
        println("param: ${title.value}")
        println("param: ${content.value}")


        val newNote = Note(0, title.value.toString(), content.value.toString(), Converters().fromLocalDateTime(
            LocalDateTime.now()).toString() )

        viewModelScope.launch {
            repository.addNotes(listOf(newNote))
            println("el resultado fue $newNote")
        }

    }

}