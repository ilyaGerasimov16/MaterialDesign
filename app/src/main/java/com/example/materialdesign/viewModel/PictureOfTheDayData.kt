package com.example.materialdesign.viewModel

import com.example.materialdesign.repository.PDOServerResponse

sealed class PictureOfTheDayData {
    data class Success(val serverResponse:PDOServerResponse):PictureOfTheDayData()
    data class Loading(val process: Int?):PictureOfTheDayData()
    data class Error(val error:Throwable):PictureOfTheDayData()
}