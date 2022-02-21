package com.example.materialdesign.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.materialdesign.BuildConfig
import com.example.materialdesign.repository.PDOServerResponse
import com.example.materialdesign.repository.PicturesOfTheDayRetrofitImpl
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PictureOfTheDayViewModel:ViewModel() {
    private val liveData:MutableLiveData<PictureOfTheDayData> = MutableLiveData()
    private val picturesOfTheDayRetrofitImpl: PicturesOfTheDayRetrofitImpl = PicturesOfTheDayRetrofitImpl()
    fun getData():LiveData<PictureOfTheDayData>{
        return liveData
    }

    fun sendRequest(date:String) {
        liveData.value = PictureOfTheDayData.Loading(0)
        val apiKey: String = BuildConfig.NASA_API_KEY
        if (apiKey.isBlank()) {
            liveData.value = PictureOfTheDayData.Error(Throwable("wrong key"))
        } else {
            picturesOfTheDayRetrofitImpl.getRetrofit().getPictureOfTheDay(apiKey,date).enqueue(callback)
        }
    }

    fun sendRequest() {
        liveData.value = PictureOfTheDayData.Loading(0)
        val apiKey: String = BuildConfig.NASA_API_KEY
        if (apiKey.isBlank()) {
            liveData.value = PictureOfTheDayData.Error(Throwable("wrong key"))
        } else {
            picturesOfTheDayRetrofitImpl.getRetrofit().getPictureOfTheDay(apiKey).enqueue(callback)
        }
    }


    private val callback = object : Callback<PDOServerResponse>{
        override fun onResponse(
            call: Call<PDOServerResponse>,
            response: Response<PDOServerResponse>
        ) {
            if(response.isSuccessful&&response.body()!=null){
                liveData.value = PictureOfTheDayData.Success(response.body()!!)
            }else{
                liveData.value = PictureOfTheDayData.Error(IllegalStateException("Ошибка"))
            }
        }

        override fun onFailure(call: Call<PDOServerResponse>, t: Throwable) {
            liveData.value = PictureOfTheDayData.Error(IllegalStateException("onFailure"))
        }

    }
}