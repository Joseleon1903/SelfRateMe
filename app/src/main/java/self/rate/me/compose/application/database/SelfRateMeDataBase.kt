package self.rate.me.compose.application.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import self.rate.me.compose.application.database.dao.ExcerciseDao
import self.rate.me.compose.application.database.entity.ExerciseEntity
import self.rate.me.compose.application.database.utils.Converters
import self.rate.me.compose.application.database.utils.ListConverters

@Database( entities = [ExerciseEntity::class] , version = 1)
@TypeConverters(Converters::class, ListConverters::class)
abstract class SelfRateMeDataBase : RoomDatabase(){

    abstract fun getExcerciseDao(): ExcerciseDao


}