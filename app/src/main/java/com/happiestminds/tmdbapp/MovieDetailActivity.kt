package com.happiestminds.tmdbapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class MovieDetailActivity : AppCompatActivity() {
    lateinit var posterImageView: ImageView
    lateinit var titleTextView: TextView
    lateinit var overviewTextView: TextView
    lateinit var ratingTextView: TextView
    lateinit var releaseTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        posterImageView = findViewById(R.id.imageView2)
        titleTextView = findViewById(R.id.movieTitleT)
        overviewTextView = findViewById(R.id.mOverviewT)
        releaseTextView = findViewById(R.id.releaseT)
        ratingTextView = findViewById(R.id.mRatingT)

        val selectedMovie = intent.getParcelableExtra<Movie>("movie")

        titleTextView.text = selectedMovie?.title
        overviewTextView.text = selectedMovie?.overview
        releaseTextView.text = selectedMovie?.release_date
        ratingTextView.text = "${selectedMovie?.vote_average}"

        val imgUrl = "https://image.tmdb.org/t/p/original${selectedMovie?.poster_path}"

        Glide.with(this).load(imgUrl).into(posterImageView)

    }
}