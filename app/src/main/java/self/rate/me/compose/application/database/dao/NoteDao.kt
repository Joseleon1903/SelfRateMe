package self.rate.me.compose.application.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import self.rate.me.compose.application.database.entity.NoteEntity

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(notes: List<NoteEntity>)

    @Query("select * from Note_tbl order by id desc")
    fun getAll(): Flow<List<NoteEntity>>

    @Delete
    fun delete(note: NoteEntity)
}