package dk.freni20.moviedb.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDAO {
    @Query("SELECT * FROM MOVIE")
    fun getAllMovies(): List<Movie>

    @Query("SELECT * FROM MOVIE WHERE :movieID=Id")
    fun getMovie(movieID: Int)

    @Insert
    fun insertMovie(movie:Movie)

    @Delete
    fun deleteMovie(movie: Movie)

}