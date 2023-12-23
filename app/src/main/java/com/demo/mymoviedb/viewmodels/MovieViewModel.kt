package com.demo.mymoviedb.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.mymoviedb.data.Movie
import com.demo.mymoviedb.repositories.MovieRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

class MovieViewModel @Inject constructor(val repository: MovieRepository): ViewModel() {
    var _movies = MutableLiveData<Movie>()
    val movies : LiveData<Movie>
        get() = _movies
     fun fetchAllMovies(apiKey: String, page: Int){
        viewModelScope.launch {
            _movies.value = repository.getAllMovies(apiKey, page)
        }
    }

}