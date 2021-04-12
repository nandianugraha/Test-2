package com.nandia.mylibraryhelper.network.request

import com.nandia.mylibraryhelper.model.Data
import com.nandia.mylibraryhelper.model.WatchlistModel
import com.nandia.mylibraryhelper.network.response.MultipleResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface WatchListRequest {

    @Headers("Content-Type: application/json")
    @GET("/data/top/totaltoptiervolfull")
    fun getAllWatchlist(
        @Query("limit") limit: Int,
        @Query("tsym") tsym: String
    ): Call<WatchlistModel>


}