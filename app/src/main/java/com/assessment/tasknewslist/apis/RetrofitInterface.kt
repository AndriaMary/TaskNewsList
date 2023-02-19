package com.assessment.tasknewslist.apis

import com.assessment.tasknewslist.model.MainContent
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitInterface {
    @GET("items?lineupSlug=news")
    suspend fun getQuotes() : Response<List<MainContent>>
}