package dk.freni20.moviedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import dk.freni20.moviedb.db.Movie
import dk.freni20.moviedb.db.MovieAdapter
import dk.freni20.moviedb.db.MovieDatabase
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    lateinit var movieDb: MovieDatabase
    lateinit var adapter: MovieAdapter
    private lateinit var numbers: EditText
    private lateinit var attributes: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieDb = MovieDatabase.getAppDatabase(this)!!


        if (movieDb.movieDAO().getAllMovies().isEmpty()){
            var m1 = Movie(1,"The Wolf of Wall Street", "Financial crime is awesome",8.2)
            var m2 = Movie(2,"Top Gun: Maverick,","Jets", 8.4)
            var m3 = Movie(3,"Uncut Gems","So much stress", 7.4)
            var m4 = Movie(4,"Sicario","Welcome to Juarez", 7.6)

            movieDb.movieDAO().insertMovie(m1)
            movieDb.movieDAO().insertMovie(m2)
            movieDb.movieDAO().insertMovie(m3)
            movieDb.movieDAO().insertMovie(m4)
        }

        var movies : ArrayList<Movie> = arrayListOf()
        for (movie in movieDb.movieDAO().getAllMovies()) {
            movies.add(movie)
        }
        adapter = MovieAdapter(movies)

        var recyclerView: RecyclerView = findViewById(R.id.movie_view)
        recyclerView.setHasFixedSize(true)
        var layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

}