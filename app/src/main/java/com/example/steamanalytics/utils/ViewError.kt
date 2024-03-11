package com.example.steamanalytics.utils

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class ViewError(
    var isError: MutableState<Boolean> = mutableStateOf(false),
    var errorMessage: MutableState<String> = mutableStateOf("success")
) {}