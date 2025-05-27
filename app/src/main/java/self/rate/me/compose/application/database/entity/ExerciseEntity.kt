package self.rate.me.compose.application.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Exercise_tbl")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id: Int =0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "lastRepetitionQuantity") val lastRepetitionQuantity: Int,
    @ColumnInfo(name = "quantity")val quantity: Int,
    @ColumnInfo(name = "pending") val pending: Int,
    @ColumnInfo(name = "status") val status: String,
    //@ColumnInfo(name = "tags") val tags: List<String>?
)
