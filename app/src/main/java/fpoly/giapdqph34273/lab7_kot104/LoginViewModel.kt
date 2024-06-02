package fpoly.giapdqph34273.lab7_kot104

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel:ViewModel() {
    private val _username = MutableLiveData<String>()
    val username:LiveData<String> = _username

    private val _password = MutableLiveData<String>()
    val password:LiveData<String> = _password

    private val _rememberMe = MutableLiveData<Boolean>()
    val rememberMe:LiveData<Boolean> = _rememberMe

    private val _isAuthenticated = MutableLiveData<Boolean?>()
    val isAuthenticated:LiveData<Boolean?> = _isAuthenticated

    fun login(username:String, password:String,rememberMe:Boolean){
        if (username.equals("admin") && password.equals("123")){
            _isAuthenticated.value = true
        }else{
            _isAuthenticated.value = false
        }
    }

    fun resetAuthenticationState(){
        _isAuthenticated.value = null
    }
}