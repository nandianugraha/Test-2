package com.nandia.mylibraryhelper.network.service

import com.nandia.mylibraryhelper.BuildConfig
import com.nandia.mylibraryhelper.network.request.WatchListRequest

object BaseService {

    fun watchListService(): WatchListRequest{
        return RetrofitClient.getClient(BuildConfig.BASE_URL)!!.create(WatchListRequest::class.java)
    }
}