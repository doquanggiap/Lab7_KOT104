package fpoly.giapdqph34273.lab7_kot104.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fpoly.giapdqph34273.lab7_kot104.MovieColumnItem
import fpoly.giapdqph34273.lab7_kot104.model.Movie
import fpoly.giapdqph34273.lab7_kot104.navigation.Screen
import fpoly.giapdqph34273.lab7_kot104.viewModel.MovieViewModel

@Composable
fun MovieScreen(
    navController: NavController,
    movieViewModel: MovieViewModel
) {
    val moviesState = movieViewModel.movies.observeAsState(initial = emptyList())
    val movies = moviesState.value

    Column(
        modifier = Modifier.safeDrawingPadding()
    ) {
        Button(onClick = {
            navController.navigate(Screen.ADD.route)
        }) {
            Text("Thêm")
        }

        MovieColumn(
            movies = movies,
            onEditClick = {
                navController.navigate("${Screen.EDIT.route}/${it}")
            },
            onDeleteClick = {
                movieViewModel.deleteMovieById(it)
            })
    }


}

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