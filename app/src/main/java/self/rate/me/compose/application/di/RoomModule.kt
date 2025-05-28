package self.rate.me.compose.application.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import self.rate.me.compose.application.database.SelfRateMeDataBase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {

    const val USER_DATABASE_NAME = "SelfRateMeDataBase2"

    @Singleton
    @Provides
    fun provideRoom(@ApplicationContext context: Context) = Room.databaseBuilder(context,
        SelfRateMeDataBase::class.java, USER_DATABASE_NAME).build();


    @Singleton
    @Provides
    fun provideExerciseDao(db : SelfRateMeDataBase) = db.getExcerciseDao()

    @Singleton
    @Provides
    fun provideNoteDao(db : SelfRateMeDataBase) = db.getNoteDao()

}