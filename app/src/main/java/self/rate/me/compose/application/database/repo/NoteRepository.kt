package self.rate.me.compose.application.database.repo

import android.os.Build
import androidx.annotation.RequiresApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import self.rate.me.compose.application.database.dao.NoteDao
import self.rate.me.compose.application.note.data.Note
import self.rate.me.compose.application.note.mapper.NoteMapper
import javax.inject.Inject

class NoteRepository @Inject constructor(
    private val noteDao: NoteDao
){

    // Exponemos un Flow de dominio, mapeando de ExerciseEntity a ExerciseType
    val notesFlow: Flow<List<Note>> = noteDao.getAll()
        .map { entities ->
            entities.map { en ->
                Note(
                    id = en.id,
                    title = en.title,
                    content = en.content,
                    creationDate = en.creationDate.toString()
                )
            }
        }

    @RequiresApi(Build.VERSION_CODES.O)
    suspend fun addNotes(notes: List<Note>){
        noteDao.insertNote(notes.map { NoteMapper.toEntity(it) })
    }

}