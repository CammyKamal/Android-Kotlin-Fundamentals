package org.codelabs.androidkotlinfundamentals.androidkotlinfundamentals5.viewmodelandviewmodelfactory.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class GameViewModel : ViewModel() {

    // The current _word
    private val _word = MutableLiveData<String>()

    // The current score
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    val word: LiveData<String>
        get() = _word



    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish


    // The list of words - the front of the list is the next _word to guess
    private lateinit var wordList: MutableList<String>


    /**
     * Resets the list of words and randomizes the order
     */
    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }

    init {
        _word.value = ""
        _score.value = 0
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    /**
     * Callback called when the ViewModel is destroyed
     */
    override fun onCleared() {
        super.onCleared()
        Log.i("GameViewModel", "GameViewModel destroyed!")
    }

    /** Methods for updating the UI **/
    fun onSkip() {
        _score.value = (_score.value)?.minus(1)
        nextWord()
    }
    fun onCorrect() {
        _score.value = (_score.value)?.plus(1)
        nextWord()
    }

    /**
     * Moves to the next _word in the list.
     */
    private fun nextWord() {
        if (wordList.isEmpty()) {
            onGameFinish()

        } else {
            //Select and remove a _word from the list
            _word.value = wordList.removeAt(0)
        }
    }



    /** Method for the game completed event **/

    fun onGameFinish() {
        _eventGameFinish.value = true
    }

    fun onGameFinishComplete() {
        _eventGameFinish.value = false
    }

}