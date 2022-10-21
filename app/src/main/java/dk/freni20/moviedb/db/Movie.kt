package dk.freni20.moviedb.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Movie(
    @PrimaryKey val id: Int,
    @ColumnInfo(name = "movieTitle") val movieTitle: String,
    @ColumnInfo(name = "movieDescription") val movieDescription: String,
    @ColumnInfo(name = "IMDB_Score") val IMDB_Score: Double,
)

