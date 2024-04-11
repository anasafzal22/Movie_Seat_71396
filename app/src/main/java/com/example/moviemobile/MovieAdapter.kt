package com.example.moviemobile

import android.annotation.SuppressLint
import android.content.Intent
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(private val movies: Array<Movie>) :
    RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val movieImage: ImageView
        private val movieTitle: TextView
        private val movieCertification: TextView
        private val movieDescription: TextView
        private val movieStarring: TextView
        private val movieRunningTime: TextView
        private val movieSeatsRemaining: TextView
        private val movieFillingFast: TextView

        init {
            movieImage = itemView.findViewById(R.id.movie_image)
            movieTitle = itemView.findViewById(R.id.movie_title)
            movieCertification = itemView.findViewById(R.id.movie_certification)
            movieDescription = itemView.findViewById(R.id.movie_description)
            movieStarring = itemView.findViewById(R.id.movie_starring)
            movieRunningTime = itemView.findViewById(R.id.movie_running_time)
            movieSeatsRemaining = itemView.findViewById(R.id.movie_seats_remaining)
            movieFillingFast = itemView.findViewById(R.id.movie_filling_fast)
        }

        @SuppressLint("SetTextI18n")
        fun bind(movie: Movie) {
            Glide.with(movieImage.context)
                .load(movie.image)
                .into(movieImage)
            movieTitle.text = movie.name
            movieCertification.text = movie.certification
            movieDescription.text = movie.description
            movieStarring.text = "Starring: " + TextUtils.join(", ", movie.starring!!)
            movieRunningTime.text = "Running time: " + movie.runningTime + " minutes"
            movieSeatsRemaining.text = "Seats remaining: " + movie.seatsRemaining
            if (movie.seatsRemaining < 3) {
                movieFillingFast.visibility = View.VISIBLE
                movieFillingFast.text = "Filling Fast"
            } else {
                movieFillingFast.visibility = View.GONE
            }

            // Set click listener to open MovieActivity
            itemView.setOnClickListener { view: View ->
                val intent = Intent(view.context, MovieDetails::class.java)
                intent.putExtra("movie", movie) // Pass the Movie object directly
                view.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_items, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }
}
