package com.nandia.mylibraryhelper.model

import com.google.gson.annotations.SerializedName


data class Data (

    @SerializedName("CoinInfo") var CoinInfo : CoinInfo,
    @SerializedName("RAW") var RAW : RAW,
    @SerializedName("DISPLAY") var DISPLAY : DISPLAY

)