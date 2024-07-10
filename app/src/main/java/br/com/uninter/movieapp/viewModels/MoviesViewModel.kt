package br.com.uninter.movieapp.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.uninter.movieapp.core.Constants
import br.com.uninter.movieapp.models.MovieModel
import br.com.uninter.movieapp.network.RetrofitClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MoviesViewModel: ViewModel() {

    private var _movieList = MutableLiveData<List<MovieModel>>()
    val movieList: LiveData<List<MovieModel>> = _movieList

    fun getBanner() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webservice.getBanner(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                _movieList.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }

    fun getPopular() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webservice.getPopular(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                _movieList.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }

    fun getUpcoming() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webservice.getUpcoming(Constants.API_KEY)
            withContext(Dispatchers.Main) {
                _movieList.value = response.body()!!.results.sortedByDescending { it.voteAverage }
            }
        }
    }
}