package org.codelabs.androidkotlinfundamentals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    var listClickObserver = MutableLiveData<Int>()
    var listitems = listOf("Hello World",
        "Dice Roller",
        "Dice Roller With Image",
        "Linear layout using the Layout Editor",
        "User interactivity In Linear layout using the Layout Editor",
        "Constraint layout using the Layout Editor",
        "Data-binding basics",
        "Trivia Example Using Fragments",
        "Lifecycles and logging",
        "Game Using ViewModel And ViewModel Factory",
        "Livedata And Observers",
        "Create Room database",
        "Getting data from the internet",
        "Repository")

    fun getList(): List<String> {
        return listitems
    }

    fun getListValue(pos:Int):String{
        return listitems[pos]
    }



    fun onItemClick(pos: Int) {
        listClickObserver.postValue(pos)
    }
}