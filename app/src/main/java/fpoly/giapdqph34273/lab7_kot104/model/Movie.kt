package fpoly.giapdqph34273.lab7_kot104.model

import com.google.gson.annotations.SerializedName
import fpoly.giapdqph34273.lab7_kot104.ui.screens.MovieFormData

data class Movie(
    @SerializedName("filmId") val id: String,
    @SerializedName("filmName") val filmName: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("image") val image: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("national") val national: String,
    @SerializedName("description") val description: String
){
    fun toMovieFormData() = this?.let {
        MovieFormData(
            this.id,
            this.filmName,
            this.duration,
            this.releaseDate,
            this.genre,
            this.national,
            this.description,
            this.image
        )
    }
}