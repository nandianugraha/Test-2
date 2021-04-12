package com.nandia.mylibraryhelper.model

import com.google.gson.annotations.SerializedName


data class WatchlistModel (

    @SerializedName("Message") var Message : String,
    @SerializedName("Type") var Type : Int,
    @SerializedName("MetaData") var MetaData : MetaData,
    @SerializedName("SponsoredData") var SponsoredData : List<String>,
    @SerializedName("Data") var Data : List<Data>,
    @SerializedName("HasWarning") var HasWarning : Boolean

)