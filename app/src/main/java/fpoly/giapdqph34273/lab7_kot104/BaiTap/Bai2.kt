package fpoly.giapdqph34273.lab7_kot104.BaiTap

import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fpoly.giapdqph34273.lab7_kot104.MainViewModel
import fpoly.giapdqph34273.lab7_kot104.Screen
import fpoly.giapdqph34273.lab7_kot104.ui.screens.MovieScreen
import fpoly.giapdqph34273.lab7_kot104.ui.screens.Screen1
import fpoly.giapdqph34273.lab7_kot104.ui.screens.Screen2
import fpoly.giapdqph34273.lab7_kot104.ui.screens.Screen3

@Composable
fun Bai2() {
    val navController = rememberNavController()

    val mainViewModel:MainViewModel= viewModel()
    val moviesState = mainViewModel.movies.observeAsState(initial = emptyList())



    NavHost(
        navController = navController,
        startDestination = Screen.LOGIN.route
    ) {
        composable(Screen.SCREEN1.route) {
            Screen1(navController = navController)
        }

        composable(Screen.SCREEN2.route) {
            Screen2(navController = navController)
        }

        composable(Screen.SCREEN3.route) {
            Screen3(navController = navController)
        }

        composable(Screen.LOGIN.route) {
            Bai3(navController = navController)
        }

        composable(Screen.MOVIE_SCREEN.route) {
            MovieScreen(movies = moviesState.value)
        }
    }
}