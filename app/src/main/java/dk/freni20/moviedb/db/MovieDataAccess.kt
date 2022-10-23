package dk.freni20.moviedb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 2)
abstract class MovieDataAccess : RoomDatabase() {
    abstract fun movieDAO(): MovieDAO

    companion object {
        private var INSTANCE: MovieDataAccess? = null

        fun getAppDatabase(context: Context): MovieDataAccess? {
            if (INSTANCE == null) {
                INSTANCE = databaseBuilder(context.applicationContext, MovieDataAccess::class.java, "MovieDatabase")
                    //TO DO: Remove allowMainThreadQueries before handing in!
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return INSTANCE
        }
    }
}