package fpoly.giapdqph34273.lab7_kot104

import android.app.DatePickerDialog
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import fpoly.giapdqph34273.lab7_kot104.model.Movie
import fpoly.giapdqph34273.lab7_kot104.model.MovieRequest
import fpoly.giapdqph34273.lab7_kot104.model.MovieViewModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun MovieFormScreen(
    navController: NavController,
    movieViewModel: MovieViewModel,
    filmId: String?
) {
    val movie = movieViewModel.getMovieById(filmId).observeAsState(initial = null).value
//    val isEditing = filmId != null

    var formData by remember(movie) {
        mutableStateOf(movie?.toMovieFormData() ?: MovieFormData())
    }

    MovieForm(
        formData = formData,
        onSave = {
            Log.d("zzzzzzzzzzz", "MovieFormScreen: ${filmId}")
            if (filmId == null) {
                movieViewModel.addFilm(formData.toMovieRequest())
                navController.popBackStack()
            } else {
                formData.id = filmId
                movieViewModel.updateMovie(formData.toMovieRequest())
                navController.popBackStack()
            }
        },
        navController
    ) { updatedFormData ->
        formData = updatedFormData
    }

}

@Composable
fun MovieForm(
    formData: MovieFormData,
    onSave: () -> Unit,
    navController: NavController,
    onUpdateFormData: (MovieFormData) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())
            .imePadding()
    ) {
        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formData.filmName,
            onValueChange = {
                onUpdateFormData(formData.copy(filmName = it))
            },
            label = { Text("Tên phim *") },
            maxLines = 3
        )

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formData.duration,
            onValueChange = {
                onUpdateFormData(formData.copy(duration = it))
            },
            label = { Text("Thời lượng *") }
        )

        Spacer(modifier = Modifier.width(8.dp))

        DatePickerField(
            label = "Khởi chiếu *",
            selectedDate = formData.releaseDate,
            onDateSelected = {
                onUpdateFormData(formData.copy(releaseDate = it))
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formData.genre,
            onValueChange = {
                onUpdateFormData(formData.copy(genre = it))
            },
            label = { Text("Thể loại *") }
        )

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formData.national,
            onValueChange = {
                onUpdateFormData(formData.copy(national = it))
            },
            label = { Text("Quốc gia *") }
        )

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formData.imageUrl,
            onValueChange = {
                onUpdateFormData(formData.copy(imageUrl = it))
            },
            label = { Text("Liên kết ảnh minh hoạ *") }
        )

        Spacer(modifier = Modifier.width(8.dp))

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = formData.description,
            onValueChange = {
                onUpdateFormData(formData.copy(description = it))
            },
            label = { Text("Mô tả *") }
        )

        Spacer(modifier = Modifier.height(12.dp))

        Button(
            onClick = onSave,
//            modifier = Modifier.height(12.dp)
        ) {
            Text("Lưu")
        }

        Button(
            onClick = { navController.popBackStack() },
//            modifier = Modifier.height(12.dp)
        ) {
            Text("Hủy")
        }


    }
}

@Composable
fun DatePickerField(
    label: String,
    selectedDate: String,
    onDateSelected: (String) -> Unit,
    modifier: Modifier
) {
    val context = LocalContext.current
    var showDialog by remember { mutableStateOf(false) }

    val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

    if (showDialog) {
        val calendar = Calendar.getInstance()
        try {
            calendar.time = dateFormat.parse(selectedDate) ?: Date()

        } catch (e: Exception) {
            e.printStackTrace()
        }

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            context, { _, selectedYear, selectedMonth, dayOfMonth ->
                val newCalendar = Calendar.getInstance().apply {
                    set(selectedYear, selectedMonth, dayOfMonth)
                }
                onDateSelected(dateFormat.format(newCalendar.time))
            }, year, month, day
        ).apply {
            show()
        }

        LaunchedEffect(key1 = Unit) {
            showDialog = false
        }

    }

    OutlinedTextField(
        modifier = modifier,
        value = selectedDate, onValueChange = {},
        readOnly = true,
        label = { Text(label) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Chọn ngày",
                modifier = Modifier.clickable { showDialog = true }
            )
        }
    )
}

fun isAllFieldValid(formData: MovieFormData): Boolean {
    return with(formData) {
        filmName.isNotEmpty() && duration.isNotEmpty() && releaseDate.isNotEmpty() &&
                genre.isNotEmpty() && national.isNotEmpty() && description.isNotEmpty() && imageUrl.isNotEmpty()
    }
}

fun validateMovieDataAndEnsureCompletion(formData: MovieFormData, movie: Movie): Boolean {
    if (!isAllFieldValid(formData)) return false
    if (formData.filmName != movie.filmName) return true
    if (formData.duration != movie.duration) return true
    if (formData.releaseDate != movie.releaseDate) return true
    if (formData.genre != movie.genre) return true
    if (formData.national != movie.national) return true
    if (formData.description != movie.description) return true
    if (formData.imageUrl != movie.image) return true

    return false
}


data class MovieFormData(
    var id: String? = "",
    var filmName: String = "",
    var duration: String = "",
    var releaseDate: String = "",
    var genre: String = "",
    var national: String = "",
    var description: String = "",
    var imageUrl: String = ""
) {
    fun toMovieRequest(): MovieRequest {
        val filmIdInt = try {
            this.id?.toIntOrNull()
        } catch (e: NumberFormatException) {
            null
        }
        val durationInt = try {
            this.duration.toInt()
        } catch (e: NumberFormatException) {
            0
        }
        return MovieRequest(
            filmId = this.id,
            filmName = this.filmName,
            duration = durationInt,
            releaseDate = this.releaseDate,
            genre = this.genre,
            national = this.national,
            description = this.description,
            image = this.imageUrl
        )
    }
}