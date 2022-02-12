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

    fun sendRequest(){
        liveData.postValue(PictureOfTheDayData.Loading(null))
        picturesOfTheDayRetrofitImpl.getRetrofit().getPictureOfTheDay(BuildConfig.NASA_API_KEY).enqueue(
            object : Callback<PDOServerResponse>{
                override fun onResponse(
                    call: Call<PDOServerResponse>,
                    response: Response<PDOServerResponse>
                ) {
                    if(response.isSuccessful&&response.body()!=null){
                        response.body()?.let {
                            liveData.postValue(PictureOfTheDayData.Success(it))
                        }

                    } else{

                    }

                }

                override fun onFailure(call: Call<PDOServerResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }
            }
        )
    }
}