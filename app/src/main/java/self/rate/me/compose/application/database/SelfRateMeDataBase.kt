package self.rate.me.compose.application.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import self.rate.me.compose.application.database.dao.ExcerciseDao
import self.rate.me.compose.application.database.dao.NoteDao
import self.rate.me.compose.application.database.entity.ExerciseEntity
import self.rate.me.compose.application.database.entity.NoteEntity
import self.rate.me.compose.application.database.utils.Converters

@Database( entities = [ExerciseEntity::class, NoteEntity::class] , version = 1)
@TypeConverters(Converters::class)
abstract class SelfRateMeDataBase : RoomDatabase(){

    abstract fun getExcerciseDao(): ExcerciseDao

    abstract fun getNoteDao(): NoteDao
}