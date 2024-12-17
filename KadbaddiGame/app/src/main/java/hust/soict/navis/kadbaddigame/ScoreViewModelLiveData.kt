package hust.soict.navis.kadbaddigame

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModelLiveData : ViewModel() {

    private val _scoreA = MutableLiveData<Int>(0)
    val scoreA:LiveData<Int> get() = _scoreA

    private val _scoreB = MutableLiveData<Int>(0)
    val scoreB:LiveData<Int> get() = _scoreB

    fun increaseScore(isTeamA:Boolean)
    {
        if(isTeamA) {
            _scoreA.value = (_scoreA.value ?: 0) + 1
        }
        else {
            _scoreB.value = (_scoreB.value ?: 0) + 1
        }
    }

    fun resetScores() {
        _scoreA.value = 0
        _scoreB.value = 0
    }

}