package fpoly.giapdqph34273.lab7_kot104.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import fpoly.giapdqph34273.lab7_kot104.BaiTap.LoginSreen
import fpoly.giapdqph34273.lab7_kot104.MovieFormScreen
import fpoly.giapdqph34273.lab7_kot104.model.MovieViewModel
import fpoly.giapdqph34273.lab7_kot104.ui.screens.MovieScreen

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    val movieViewModel: MovieViewModel = viewModel()


    NavHost(
        navController = navController,
        startDestination = Screen.LOGIN.route
    ) {

        composable(Screen.LOGIN.route) {
            LoginSreen(navController = navController)
        }

        composable(Screen.MOVIE_SCREEN.route) {
            MovieScreen(navController, movieViewModel)
        }

        composable(Screen.ADD.route) {
            MovieFormScreen(
                navController = navController,
                movieViewModel = movieViewModel,
                filmId = null
            )
        }

        composable(
            "${Screen.EDIT.route}/{filmId}",
            arguments = listOf(navArgument("filmId") {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.getString("filmId")?.let { filmId ->
                MovieFormScreen(
                    navController = navController,
                    movieViewModel = movieViewModel, filmId = filmId
                )
            }
        }
    }
}