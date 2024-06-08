package fpoly.giapdqph34273.lab7_kot104.model

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fpoly.giapdqph34273.lab7_kot104.service.RetrofitService
import fpoly.giapdqph34273.lab7_kot104.toMovie
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {
    private val _movies = MutableLiveData<List<Movie>>()
    val movies: LiveData<List<Movie>> = _movies

    init {
        getMovies()
    }

    fun getMovies() {
        viewModelScope.launch {
            try {
                val response = RetrofitService().movieService.getListFilms()
                if (response.isSuccessful) {
                    _movies.postValue(response.body()?.map { it.toMovie() })
                } else {
                    _movies.postValue(emptyList())
                }
            } catch (e: Exception) {
                Log.e("TAG", "getMovies: ${e.message}")
                _movies.postValue(emptyList())
            }
        }
    }

    fun getMovieById(filmId: String?): LiveData<Movie?> {
        val liveData = MutableLiveData<Movie?>()
        filmId?.let {
            viewModelScope.launch {
                try {
                    val response = RetrofitService().movieService.getFilmDetail(filmId)
                    if (response.isSuccessful) {
                        liveData.postValue(response.body()?.toMovie())
                    } else {
                        liveData.postValue(null)
                    }
                } catch (e: Exception) {
                    liveData.postValue(null)
                }
            }
        }
        return liveData
    }

    fun addFilm(movieRequest: MovieRequest) {
        try {
            viewModelScope.launch {
                movieRequest.filmId = null

                val response = RetrofitService().movieService.addFilm(movieRequest)
                if (response.isSuccessful) {
                    getMovies()
                }
            }

        } catch (e: Exception) {
            Log.d("zzzzz", "addFilm: ${e.message}")
        }

    }

    fun updateMovie(movieRequest: MovieRequest) {
        try {
            viewModelScope.launch {
                Log.d("zzzzz", "updateMovie: " + movieRequest.filmId.toString())
                val response = RetrofitService().movieService.updateFilm(
                    movieRequest.filmId.toString(),
                    movieRequest
                )
                if (response.isSuccessful) {
                    getMovies()
                }
            }

        } catch (e: Exception) {
            Log.d("zzzzz", "updateMovie: ${e.message}")

        }

    }

    fun deleteMovieById(id: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitService().movieService.deleteFilm(id)
                if (response.isSuccessful) {

                    getMovies()
                } else {
                    false
                }


            } catch (e: Exception) {
                Log.d("zzzzz", "deleteMovieByIdErr: ${e.message}")

            }
        }
    }
}