package com.happiestminds.tmdbapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBInterface {

    // url: https://api.themoviedb.org/3/movie/popular?api_key=12192812891
    @GET("movie/popular")
    fun getPopularMovies(@Query("api_key") key: String) : Call<PopularMovies>

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"

        fun createInstance(): TMDBInterface {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return retrofit.create(TMDBInterface::class.java)
        }


    }
}








