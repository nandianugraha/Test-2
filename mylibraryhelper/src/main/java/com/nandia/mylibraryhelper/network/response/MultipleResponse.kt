package com.nandia.mylibraryhelper.network.response

import com.google.gson.annotations.SerializedName

data class MultipleResponse<T> (
    @SerializedName("Message") var message: String = "",
    @SerializedName("Type") var type: Int? = null,
    @SerializedName("MetaData") var metadata: T? = null,
//    @SerializedName("SponsoredData") var sponsoredata: T? = null,
    @SerializedName("Data") var data: T? = null
)