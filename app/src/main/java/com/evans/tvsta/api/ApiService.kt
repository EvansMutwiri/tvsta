package com.evans.tvsta.api

import com.evans.tvsta.helper.Constants
import com.evans.tvsta.models.TvShowResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.END_POINT)
    suspend fun getTvShows(): Response<TvShowResponse>
}