package com.example.steamanalytics.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class AppViewModel() : ViewModel() {

    var internetState: MutableState<Boolean> = mutableStateOf(value = true)

}