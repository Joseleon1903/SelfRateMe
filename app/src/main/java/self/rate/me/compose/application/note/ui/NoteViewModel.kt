package self.rate.me.compose.application.note.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import self.rate.me.compose.application.database.repo.NoteRepository
import javax.inject.Inject

@RequiresApi(Build.VERSION_CODES.O)
@HiltViewModel
class NoteViewModel  @Inject constructor(private val repository: NoteRepository) : ViewModel(){


    private val _title = MutableLiveData<String>();
    val title : LiveData<String> = _title;

    private val _content = MutableLiveData<String>();
    val content : LiveData<String> = _content;

    fun onValueViewChange(title: String, content: String) {
        _title.value = title;
        _content.value = content;
    }

    fun submitForm(){
        println("Entering submitForm")


    }

}