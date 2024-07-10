package br.com.uninter.movieapp.models

import com.google.gson.annotations.SerializedName

data class MovieModel(
    @SerializedName("id")
    var id: String,
    @SerializedName("original_title")
    var movieName: String,
    @SerializedName("overview")
    var description: String,
    @SerializedName("poster_path")
    var poster: String,
    @SerializedName("release_date")
    var releaseDate: String,
    @SerializedName("vote_average")
    var voteAverage: String,
    @SerializedName("vote_count")
    var voteCount: String,
)
