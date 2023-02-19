package com.assessment.tasknewslist.viewModel

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.assessment.tasknewslist.apis.RetrofitHelper
import com.assessment.tasknewslist.apis.RetrofitInterface
import com.assessment.tasknewslist.model.MainContent



class NewsViewModel(app: Application) : AndroidViewModel(app) {
    var newsLiveData = MutableLiveData<List<MainContent>>()

    suspend fun getNews() {
        val quotesApi = RetrofitHelper.getInstance().create(RetrofitInterface::class.java)
        val result = quotesApi.getQuotes()
        Log.e("RESULT ", result.body()!!.size.toString())
        newsLiveData.postValue(result.body())
    }

}