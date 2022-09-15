package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myapplication.api.UtApiException
import com.example.myapplication.common_util.Resource
import com.example.myapplication.common_util.Util
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlin.coroutines.CoroutineContext

open class CommonViewModel : ViewModel() {
    private val TAG: String = CommonViewModel::class.java.name
    val statusLiveData = MutableLiveData<Resource<Int>>()
    var apiErrorLiveData = MutableLiveData<UtApiException>()


    fun onApiError(message: String) {
        apiErrorLiveData.postValue(UtApiException(Util.CODE_ERROR, message))
    }

    val coroutineHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _: CoroutineContext, throwable: Throwable ->
            //sessionLiveData.postValue(Resource.error(throwable.localizedMessage,null))
            throwable.printStackTrace()
            onApiError(throwable.localizedMessage ?: "")
        }
}