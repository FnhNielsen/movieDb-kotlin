package dk.freni20.moviedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
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
    private var movies : ArrayList<Movie> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        movieDb = MovieDataAccess.getAppDatabase(this)!!

        Thread{
            if (movieDb.movieDAO().getAllMovies().isEmpty()){
                var m1 = Movie(0,"The Wolf of Wall Street", "Financial crime is awesome",8.2,R.drawable.wolfofwallst)
                var m2 = Movie(1,"Top Gun: Maverick","Jets", 8.4, R.drawable.topgun)
                var m3 = Movie(2,"Uncut Gems","So much stress", 7.4, R.drawable.uncutgems)
                var m4 = Movie(3,"Sicario","Welcome to Juarez", 7.6, R.drawable.sicario)
                var m5 = Movie(4,"Inception","Never falling asleep again", 8.8, R.drawable.inception)

                movieDb.movieDAO().addMovie(m1)
                movieDb.movieDAO().addMovie(m2)
                movieDb.movieDAO().addMovie(m3)
                movieDb.movieDAO().addMovie(m4)
                movieDb.movieDAO().addMovie(m5)
            }
            movies.addAll(movieDb.movieDAO().getAllMovies())
        }.start()

        adapter = MovieAdapter(movies)

        var recyclerView: RecyclerView = findViewById(R.id.movie_view)
        recyclerView.setHasFixedSize(true)
        var layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL,)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        adapter.itemClickEvent = {movie ->
            val intent = Intent(this, MovieDetails::class.java)
            intent.putExtra("Movie", movie.id)
            startActivity(intent)
        }
    }
}


