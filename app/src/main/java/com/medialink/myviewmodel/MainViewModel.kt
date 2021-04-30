package com.medialink.myviewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel: ViewModel() {
    var result = 0
    var status = MutableLiveData<Boolean?>()

    fun calculate(width: String, height: String, length: String) {
        try {
            result = width.toInt() * height.toInt() * length.toInt()
            this.status.value = true
        } catch(e: NumberFormatException) {
            this.status.value = false
        }

    }
}