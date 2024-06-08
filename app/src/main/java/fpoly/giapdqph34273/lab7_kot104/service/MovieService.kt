package fpoly.giapdqph34273.lab7_kot104.service

import fpoly.giapdqph34273.lab7_kot104.model.MovieRequest
import fpoly.giapdqph34273.lab7_kot104.model.StatusResponse
import fpoly.giapdqph34273.lab7_kot104.response.MovieResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface MovieService {
    @GET("Movies")
    suspend fun getListFilms(): Response<List<MovieResponse>>

    @GET("Movies/{id}")
    suspend fun getFilmDetail(@Path("id") id: String): Response<MovieResponse>

    @POST("Movies")
    suspend fun addFilm(@Body filmRequest: MovieRequest): Response<StatusResponse>

    @PUT("Movies/{id}")
    suspend fun updateFilm(
        @Path("id") id: String,
        @Body filmRequest: MovieRequest
    ): Response<StatusResponse>

    @DELETE("Movies/{id}")
    suspend fun deleteFilm(@Path("id") id: String): Response<StatusResponse>
}