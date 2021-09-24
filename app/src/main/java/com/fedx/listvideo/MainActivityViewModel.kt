package com.fedx.listvideo

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.*
import com.fedx.listvideo.network.Headline
import com.fedx.listvideo.network.ImgSrc
import com.fedx.listvideo.network.Movies
import com.fedx.listvideo.network.MoviesApi
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivityViewModel(): ViewModel() {
    private val _property = MutableLiveData<List<Headline>>()

    val property: LiveData<List<Headline>>
                    get() = _property


    private val _propertySrc = MutableLiveData<List<ImgSrc>>()
    val propertySrc: LiveData<List<ImgSrc>>
        get() = _propertySrc

    private val _header = MutableLiveData<List<String>>()
    val header: LiveData<List<String>>
        get() = _header

    init {
        getMovies()
    }
    private fun getMovies(){
        Log.d(TAG, "movies launch")

        viewModelScope.launch {
            try {
                val headline = MoviesApi.retrofitService.getAllMovies()
                val headlineSrc = MoviesApi.retrofitService.getAllMovies()
                _property.value = headline.results
                val list: ArrayList<ImgSrc> = arrayListOf()
                _property.value!!.forEach {
                    list.add(it.multimedia)
                }
                _propertySrc.value = list
            }catch (e: Exception){
                //_property.value = ArrayList()
                Log.d(TAG, "movies error")
            }
        }
    }
}