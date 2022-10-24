package dk.freni20.moviedb

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dk.freni20.moviedb.db.MovieDataAccess

class MovieDetails : AppCompatActivity() {

    private lateinit var movieTitle: TextView
    private lateinit var description: TextView
    private lateinit var moviePoster: ImageView
    lateinit var movieDb: MovieDataAccess

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)
        movieDb = MovieDataAccess.getAppDatabase(this)!!

        movieTitle = findViewById(R.id.title_movie)
        moviePoster = findViewById(R.id.movie_poster)
        description = findViewById(R.id.description_movie)

        val movieId: Int = intent.getIntExtra("Movie", 0)
        Thread {
            var movie = movieDb.movieDAO().getMovie(movieId)
            movieTitle.text = movie.movieTitle
            moviePoster.setImageResource(movie.poster)
            description.text = movie.movieDescription

        }.start()

    }

}