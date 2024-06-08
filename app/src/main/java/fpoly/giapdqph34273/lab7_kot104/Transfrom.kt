package fpoly.giapdqph34273.lab7_kot104

import fpoly.giapdqph34273.lab7_kot104.model.Movie
import fpoly.giapdqph34273.lab7_kot104.response.MovieResponse

fun MovieResponse.toMovie(): Movie {
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