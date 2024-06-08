package fpoly.giapdqph34273.lab7_kot104.request

import com.google.gson.annotations.SerializedName

data class MovieRequest(
    @SerializedName("id") var filmId: String? = null,
    val filmName: String,
    val duration: Int,
    val releaseDate: String,
    val genre: String,
    val national: String,
    val description: String,
    val image: String
)

data class StatusResponse(
    val status: Int,
    val message: String
)