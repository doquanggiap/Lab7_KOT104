package fpoly.giapdqph34273.lab7_kot104.service

import fpoly.giapdqph34273.lab7_kot104.response.MovieResponse
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("Movies")
    suspend fun getListFilms(): Response<List<MovieResponse>>
}