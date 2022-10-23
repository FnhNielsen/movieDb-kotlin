package dk.freni20.moviedb.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MovieDAO {
    @Query("SELECT * FROM MOVIE")
    fun getAllMovies(): List<Movie>

    @Query("SELECT * FROM MOVIE WHERE :movieID=id")
    fun getMovie(movieID: Int) : Movie


    @Insert
    fun insertMovie(movie:Movie)
/*
    @Delete
    fun deleteMovie(movie: Movie)

*/

}