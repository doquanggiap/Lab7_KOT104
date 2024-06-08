package fpoly.giapdqph34273.lab7_kot104.MovieList

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import fpoly.giapdqph34273.lab7_kot104.model.Movie
import fpoly.giapdqph34273.lab7_kot104.MovieColumnItem

@Composable
fun MovieColumn(
    movies: List<Movie>,
    onEditClick: (id: String) -> Unit = {},
    onDeleteClick: (id: String) -> Unit = {}
) {
    LazyColumn(
        state = rememberLazyListState(),
        contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(movies.size) { index ->
            MovieColumnItem(
                movie = movies[index],
                onEditClick = onEditClick,
                onDeleteClick = onDeleteClick
            )
        }
    }
}