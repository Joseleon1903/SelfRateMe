package self.rate.me.compose.application.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime


@Entity(tableName = "Note_tbl")
data class NoteEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int =0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "type")val type: String,
    @ColumnInfo(name = "content") val content: String,
    @ColumnInfo(name = "creation_date") val creationDate: LocalDateTime?,
    @ColumnInfo(name = "eventDate") val eventDate :String?,
    @ColumnInfo(name = "billsDate") val billsDate :String?,
    @ColumnInfo(name = "billsAmount") val billsAmount: Double?
)