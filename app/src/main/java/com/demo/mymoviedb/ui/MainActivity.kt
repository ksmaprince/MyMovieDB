package com.demo.mymoviedb.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.demo.mymoviedb.data.MovieInfo
import com.demo.mymoviedb.data.RetrofitInstance
import com.demo.mymoviedb.databinding.ActivityMainBinding
import com.demo.mymoviedb.repositories.MovieRepository
import com.demo.mymoviedb.ui.MovieAdapter
import com.demo.mymoviedb.viewmodels.MovieViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject lateinit var viewModel: MovieViewModel
    @Inject lateinit var adapter: MovieAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvMovie.layoutManager = GridLayoutManager(this, 2)
        binding.rvMovie.adapter = adapter
        viewModel.fetchAllMovies("f6c06b6a1cc549d810d4fb194b9d7633", 1)
        viewModel.movies.observe(this@MainActivity, Observer {
            adapter.movieInfos = it.results
        })

        adapter.setOnItemClickListener(object : MovieAdapter.OnItemClickListener{
            override fun onItemClick(movieInfo: MovieInfo) {
                startActivity(MovieDetailsActivity.getIntent(this@MainActivity, movieInfo))
            }

        })
    }
}