package com.demo.mymoviedb.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.demo.mymoviedb.R
import com.demo.mymoviedb.data.MovieInfo
import com.demo.mymoviedb.databinding.MovieItemLayoutBinding
import javax.inject.Inject

class MovieAdapter @Inject constructor(): Adapter<MovieAdapter.MovieViewHolder>() {
    private lateinit var listener: OnItemClickListener
    var movieInfos: List<MovieInfo> = listOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    interface OnItemClickListener{
        fun onItemClick(movieInfo: MovieInfo)
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener){
        this.listener = onItemClickListener
    }

    inner class MovieViewHolder(val binding: MovieItemLayoutBinding): ViewHolder(binding.root){
        fun bind(movieInfo:MovieInfo){
            binding.tvTitle.text = movieInfo.title
            binding.tvReleaseDate.text = movieInfo.release_date
            Glide.with(binding.root.context)
                .load("https://image.tmdb.org/t/p/w500${movieInfo.poster_path}")
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_foreground)
                .into(binding.ivPoster)

            binding.ctlItemLayout.setOnClickListener {
                if (listener !=null && adapterPosition != RecyclerView.NO_POSITION)
                    listener.onItemClick(movieInfo)
            }
            binding.ivPoster.setOnClickListener {
                if (listener !=null && adapterPosition != RecyclerView.NO_POSITION)
                    listener.onItemClick(movieInfo)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val binding = MovieItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding)
    }

    override fun getItemCount(): Int = movieInfos.size

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieInfos[position])
    }
}