package com.demo.mymoviedb.repositories

import com.demo.mymoviedb.data.Movie
import com.demo.mymoviedb.data.MovieService
import javax.inject.Inject

class MovieRepository @Inject constructor(val movieService: MovieService) {
    suspend fun getAllMovies(apiKey:String, page:Int): Movie{
        return movieService.getAllMovie(apiKey, page)
    }
}