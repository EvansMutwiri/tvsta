package com.evans.tvsta.repository

import com.evans.tvsta.api.ApiService
import javax.inject.Inject

class TvShowRepository
@Inject
constructor(private val apiService: ApiService)
{
    suspend fun getTvShows() = apiService.getTvShows()
}