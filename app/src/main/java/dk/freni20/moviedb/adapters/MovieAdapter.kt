package dk.freni20.moviedb.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import dk.freni20.moviedb.db.Movie
import dk.freni20.moviedb.R

class MovieAdapter(private val movies : ArrayList<Movie>):RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    var itemClickEvent: ((Movie) -> Unit)? = null

    inner class ViewHolder(item : View): RecyclerView.ViewHolder(item){
        var movieTitle : TextView = item.findViewById(R.id.movieTitle)
        var imdbScore : TextView = item.findViewById(R.id.IMDB_Score)

        init {
            itemView.setOnClickListener {
                itemClickEvent?.invoke(movies[adapterPosition])
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_view_holder, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.movieTitle.text = movies[position].movieTitle
        holder.imdbScore.text = movies[position].IMDB_Score.toString()
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}