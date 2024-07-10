package br.com.uninter.movieapp.network

import br.com.uninter.movieapp.network.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WebService {
    @GET("now_playing")
    suspend fun getBanner(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>

    @GET("popular")
    suspend fun getPopular(
        @Query("api_key") apiKey: String
    ): Response<MovieResponse>
}