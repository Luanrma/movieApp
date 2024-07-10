package br.com.uninter.movieapp.network.response

import br.com.uninter.movieapp.models.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieResponse (
    @SerializedName("results")
    var results: List<MovieModel>
)