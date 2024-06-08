package fpoly.giapdqph34273.lab7_kot104.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import fpoly.giapdqph34273.lab7_kot104.MovieList.MovieColumn
import fpoly.giapdqph34273.lab7_kot104.model.MovieViewModel
import fpoly.giapdqph34273.lab7_kot104.navigation.Screen

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