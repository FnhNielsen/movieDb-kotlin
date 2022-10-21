package dk.freni20.moviedb.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date


@Entity
data class Movie(
    @PrimaryKey (autoGenerate = true)
    val movieId: Int = 0,
    @ColumnInfo(name = "movieTitle") val movieTitle: String,
    @ColumnInfo(name = "movieDescription") val movieDescription: String,
    @ColumnInfo(name = "IMDB_Score") val IMDB_Score: Double,
    @ColumnInfo(name = "releaseDate") val releaseDate: Date
)

