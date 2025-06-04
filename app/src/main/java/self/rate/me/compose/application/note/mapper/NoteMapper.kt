package self.rate.me.compose.application.note.mapper

import android.os.Build
import androidx.annotation.RequiresApi
import self.rate.me.compose.application.database.entity.NoteEntity
import self.rate.me.compose.application.database.utils.Converters
import self.rate.me.compose.application.note.data.Note

class NoteMapper {

    companion object {

        fun toDomain(entity : NoteEntity): Note{
            return Note(
                entity.id, entity.title,entity.type, entity.content,
                entity.creationDate.toString(),
                eventDate = entity.eventDate,
                billsDate = entity.billsDate,
                billsAmount =entity.billsAmount
            )
        }

        @RequiresApi(Build.VERSION_CODES.O)
        fun toEntity(entity : Note):NoteEntity{
            return NoteEntity(entity.id, entity.title,entity.type,entity.content,
                Converters().toLocalDateTime(entity.creationDate),
                entity.eventDate,
                entity.billsDate,
                entity.billsAmount
                )
        }
    }
}