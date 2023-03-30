package com.example.mvvmcleanarchidemo1.viewmodels

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Amiibo
import com.example.domain.entity.GamesDomainMario
import com.example.domain.usecase.GetGamesUseCase
import com.example.supermariocompose.ui.HomeState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GameViewModel @Inject constructor(private val gamesData: GetGamesUseCase, private val dispatcherIO: CoroutineDispatcher = Dispatchers.IO) : ViewModel() {
    val gamesDetails: MutableLiveData<GamesDomainMario> = MutableLiveData()

    fun getGamesData() {
        viewModelScope.launch(dispatcherIO) {
            try {
                val apiRes = gamesData.execute()
                gamesDetails.postValue(apiRes)
            } catch (e: Exception) {
                Log.d("MyTag", e.toString())
            }

        }

    }
 private  val _games= mutableStateOf<HomeState>(HomeState())
    var games:State<HomeState> =_games

init {
    gamesDataval()
}

    fun gamesDataval(){
        viewModelScope.launch(dispatcherIO) {
            val apiRes = gamesData.execute()
            _games.value = HomeState(data = apiRes.amiibo)
        }
    }
}



