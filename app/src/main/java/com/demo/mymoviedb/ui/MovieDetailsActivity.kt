package com.demo.mymoviedb.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.demo.mymoviedb.data.MovieInfo
import com.demo.mymoviedb.databinding.ActivityMovieDetailsBinding

class MovieDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovieDetailsBinding
    companion object{
        fun getIntent(context:Context, movieInfo: MovieInfo): Intent{
            val intent = Intent(context, MovieDetailsActivity::class.java)
            val bundle = Bundle()
            intent.putExtra("movie_info", movieInfo)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovieDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val movieInfo = intent.getSerializableExtra("movie_info") as MovieInfo

        binding.tvTitle.text = movieInfo.title
        binding.tvLongDetails.text = movieInfo.overview
        binding.tvShortDescription.text="Rating: ${movieInfo.vote_average} Release Date: ${movieInfo.release_date}"

        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${movieInfo.poster_path}")
            .centerCrop()
            .into(binding.ivPoster)
    }
}