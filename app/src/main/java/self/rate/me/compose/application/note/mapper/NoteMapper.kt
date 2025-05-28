package self.rate.me.compose.application.note.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import self.rate.me.compose.application.database.entity.NoteEntity
import self.rate.me.compose.application.database.utils.Converters
import self.rate.me.compose.application.note.data.Note
import java.time.LocalDateTime


class NoteMapper {

    companion object {

        fun toDomain(entity : NoteEntity): Note{
            return Note(entity.id, entity.title,entity.content, entity.creationDate.toString())
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun toEntity(entity : Note):NoteEntity{
            return NoteEntity(entity.id, entity.title,entity.content, Converters().toLocalDateTime(entity.creationDate) )
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun toNew(title: String?,content: String?,localDateTime: LocalDateTime): NoteEntity{
            return NoteEntity(0 ,title.orEmpty(), content.toString(), localDateTime )
        }
    }
}