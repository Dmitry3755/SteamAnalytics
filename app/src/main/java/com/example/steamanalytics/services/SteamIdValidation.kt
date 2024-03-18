package com.example.steamanalytics.services

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.res.stringResource
import com.example.steamanalytics.R
import com.example.steamanalytics.utils.AppResources
import com.example.steamanalytics.utils.ViewError

object SteamIdValidation {

    fun isSteamIdVerify(steamId: String): ViewError {

        return if (steamId.isEmpty() || steamId == "") {
            ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_steam_id_not_enter)
                )
            )
        } else if (steamId.contains("[A-Za-z!\"#$%&'()*+,-./:;<=>?@^_`{|}~]".toRegex())) {
            ViewError(
                isError = mutableStateOf(true),
                errorMessage = mutableStateOf(
                    AppResources.getString(R.string.error_steam_id_consist_only_of_numbers)
                )
            )
        } else {
            ViewError(isError = mutableStateOf(false))
        }
    }
}