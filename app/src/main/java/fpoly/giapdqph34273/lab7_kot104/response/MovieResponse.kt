package fpoly.giapdqph34273.lab7_kot104.response

import com.google.gson.annotations.SerializedName
import fpoly.giapdqph34273.lab7_kot104.model.Movie

data class MovieResponse(
    @SerializedName("filmId") val filmId: String,
    @SerializedName("filmName") val filmName: String,
    @SerializedName("duration") val duration: String,
    @SerializedName("releaseDate") val releaseDate: String,
    @SerializedName("genre") val genre: String,
    @SerializedName("national") val national: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: String
) {
    fun toMovie(): Movie {
        return Movie(
            id = this.filmId,
            filmName = this.filmName,
            duration = this.duration,
            releaseDate = this.releaseDate,
            genre = this.genre,
            national = national,
            description = this.description,
            image = this.image
        )
    }
}