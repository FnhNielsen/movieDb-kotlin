package dk.freni20.moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dk.freni20.moviedb.adapters.MovieAdapter
import dk.freni20.moviedb.db.Movie
import dk.freni20.moviedb.db.MovieDataAccess
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var movieDb: MovieDataAccess
    lateinit var adapter: MovieAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieDb = MovieDataAccess.getAppDatabase(this)!!

        if (movieDb.movieDAO().getAllMovies().isEmpty()){
            var m1 = Movie(1,"The Wolf of Wall Street", "Financial crime is awesome",8.2)
            var m2 = Movie(2,"Top Gun: Maverick","Jets", 8.4)
            var m3 = Movie(3,"Uncut Gems","So much stress", 7.4)
            var m4 = Movie(4,"Sicario","Welcome to Juarez", 7.6)

            movieDb.movieDAO().addMovie(m1)
            movieDb.movieDAO().addMovie(m2)
            movieDb.movieDAO().addMovie(m3)
            movieDb.movieDAO().addMovie(m4)
        }

        var movies : ArrayList<Movie> = arrayListOf()
        for (movie in movieDb.movieDAO().getAllMovies()) {
            movies.add(movie)
        }
        adapter = MovieAdapter(movies)

        var recyclerView: RecyclerView = findViewById(R.id.movie_view)
        recyclerView.setHasFixedSize(true)
        var layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL,)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}