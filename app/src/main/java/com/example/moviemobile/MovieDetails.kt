package com.example.moviemobile

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide

class MovieDetails : AppCompatActivity() {
    private var seatsRemaining = 0
    private var seatsSelected = 0
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_details)

        // Get movie object from intent
        val movie = intent.getParcelableExtra<Movie>("movie")

        // Initialize seatsRemaining and seatsSelected values
        seatsRemaining = movie!!.seatsRemaining
        seatsSelected = 0

        // Set up views
        val movieImage = findViewById<ImageView>(R.id.movie_image)
        val movieTitle = findViewById<TextView>(R.id.movie_name)
        val movieCertification = findViewById<TextView>(R.id.movie_certification)
        val movieDescription = findViewById<TextView>(R.id.movie_description)
        val movieStarring = findViewById<TextView>(R.id.movie_starring)
        val movieRunningTime = findViewById<TextView>(R.id.movie_running_time)
        val movieSeatsRemaining = findViewById<TextView>(R.id.movie_seats_remaining)
        val minusButton = findViewById<ImageView>(R.id.minus_button)
        val plusButton = findViewById<ImageView>(R.id.plus_button)

        // Load movie data into views
        Glide.with(movieImage.context)
            .load(movie.image)
            .into(movieImage)
        movieTitle.text = movie.name
        movieCertification.text = movie.certification
        movieDescription.text = movie.description
        movieStarring.text = "Starring: " + TextUtils.join(", ", movie.starring!!)
        movieRunningTime.text = "Running time: " + movie.runningTime + " minutes"
        movieSeatsRemaining.text = "Seats remaining: $seatsRemaining"

        // Set click listener for minus button
        minusButton.setOnClickListener { v: View? ->
            if (seatsSelected > 0) {
                seatsSelected--
                seatsRemaining++
                updateSeatsText()
                updateSeatsRemainingText()
            }
        }

        // Set click listener for plus button
        plusButton.setOnClickListener { v: View? ->
            if (seatsRemaining > 0) {
                seatsSelected++
                seatsRemaining--
                updateSeatsText()
                updateSeatsRemainingText()
            }
        }

        // Update seats text
        updateSeatsText()
        updateSeatsRemainingText()
    }

    override fun onBackPressed() {
        val resultIntent = Intent()
        resultIntent.putExtra("selectedSeats", seatsSelected)
        setResult(RESULT_OK, resultIntent)
        super.onBackPressed()
    }

    private fun updateSeatsText() {
        val seatsSelectedText = findViewById<TextView>(R.id.seats_selected_text)
        seatsSelectedText.text = seatsSelected.toString()
    }

    private fun updateSeatsRemainingText() {
        val seatsRemainingText = findViewById<TextView>(R.id.seats_remaining_text)
        seatsRemainingText.text = seatsRemaining.toString()
        val minusButton = findViewById<ImageView>(R.id.minus_button)
        val plusButton = findViewById<ImageView>(R.id.plus_button)
        minusButton.isEnabled = seatsSelected > 0
        plusButton.isEnabled = seatsRemaining > 0
    }
}
