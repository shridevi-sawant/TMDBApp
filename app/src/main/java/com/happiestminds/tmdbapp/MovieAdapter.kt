package com.happiestminds.tmdbapp

import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MovieAdapter(val data: List<Movie>,
                   val action: (Movie)->Unit ) : RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgV = itemView.findViewById<ImageView>(R.id.imageView)
        val titleTextView = itemView.findViewById<TextView>(R.id.titleT)
        val overviewTextView = itemView.findViewById<TextView>(R.id.overviewT)
        val rdateTextView = itemView.findViewById<TextView>(R.id.rdateT)
        val ratingTextView = itemView.findViewById<TextView>(R.id.ratingT)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        // inflate xml and create view holder
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movie_item, parent, false)

        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        // bind data
        val movie = data[position]
        holder.titleTextView.text = movie.title
        holder.overviewTextView.text = movie.overview
        holder.overviewTextView.movementMethod = ScrollingMovementMethod()

        holder.rdateTextView.text = movie.release_date
        holder.ratingTextView.text = "${movie.vote_average}"

        holder.itemView.setOnClickListener {
            action(movie)
        }

        val imgPath = "https://image.tmdb.org/t/p/w500${movie.poster_path}"

        Glide.with(holder.itemView)
            .load(imgPath)
            .placeholder(android.R.drawable.ic_menu_camera)
            .into(holder.imgV)
    }

    override fun getItemCount(): Int {
       return data.size
    }
}