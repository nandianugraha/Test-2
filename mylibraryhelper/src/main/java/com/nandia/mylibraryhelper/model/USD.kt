package com.nandia.mylibraryhelper.model

import com.google.gson.annotations.SerializedName

   
data class USD (

   @SerializedName("FROMSYMBOL") var FROMSYMBOL : String,
   @SerializedName("TOSYMBOL") var TOSYMBOL : String,
   @SerializedName("MARKET") var MARKET : String,
   @SerializedName("PRICE") var PRICE : String,
   @SerializedName("LASTUPDATE") var LASTUPDATE : String,
   @SerializedName("LASTVOLUME") var LASTVOLUME : String,
   @SerializedName("LASTVOLUMETO") var LASTVOLUMETO : String,
   @SerializedName("LASTTRADEID") var LASTTRADEID : String,
   @SerializedName("VOLUMEDAY") var VOLUMEDAY : String,
   @SerializedName("VOLUMEDAYTO") var VOLUMEDAYTO : String,
   @SerializedName("VOLUME24HOUR") var VOLUME24HOUR : String,
   @SerializedName("VOLUME24HOURTO") var VOLUME24HOURTO : String,
   @SerializedName("OPENDAY") var OPENDAY : String,
   @SerializedName("HIGHDAY") var HIGHDAY : String,
   @SerializedName("LOWDAY") var LOWDAY : String,
   @SerializedName("OPEN24HOUR") var OPEN24HOUR : String,
   @SerializedName("HIGH24HOUR") var HIGH24HOUR : String,
   @SerializedName("LOW24HOUR") var LOW24HOUR : String,
   @SerializedName("LASTMARKET") var LASTMARKET : String,
   @SerializedName("VOLUMEHOUR") var VOLUMEHOUR : String,
   @SerializedName("VOLUMEHOURTO") var VOLUMEHOURTO : String,
   @SerializedName("OPENHOUR") var OPENHOUR : String,
   @SerializedName("HIGHHOUR") var HIGHHOUR : String,
   @SerializedName("LOWHOUR") var LOWHOUR : String,
   @SerializedName("TOPTIERVOLUME24HOUR") var TOPTIERVOLUME24HOUR : String,
   @SerializedName("TOPTIERVOLUME24HOURTO") var TOPTIERVOLUME24HOURTO : String,
   @SerializedName("CHANGE24HOUR") var CHANGE24HOUR : String,
   @SerializedName("CHANGEPCT24HOUR") var CHANGEPCT24HOUR : String,
   @SerializedName("CHANGEDAY") var CHANGEDAY : String,
   @SerializedName("CHANGEPCTDAY") var CHANGEPCTDAY : String,
   @SerializedName("CHANGEHOUR") var CHANGEHOUR : String,
   @SerializedName("CHANGEPCTHOUR") var CHANGEPCTHOUR : String,
   @SerializedName("CONVERSIONTYPE") var CONVERSIONTYPE : String,
   @SerializedName("CONVERSIONSYMBOL") var CONVERSIONSYMBOL : String,
   @SerializedName("SUPPLY") var SUPPLY : String,
   @SerializedName("MKTCAP") var MKTCAP : String,
   @SerializedName("MKTCAPPENALTY") var MKTCAPPENALTY : String,
   @SerializedName("TOTALVOLUME24H") var TOTALVOLUME24H : String,
   @SerializedName("TOTALVOLUME24HTO") var TOTALVOLUME24HTO : String,
   @SerializedName("TOTALTOPTIERVOLUME24H") var TOTALTOPTIERVOLUME24H : String,
   @SerializedName("TOTALTOPTIERVOLUME24HTO") var TOTALTOPTIERVOLUME24HTO : String,
   @SerializedName("IMAGEURL") var IMAGEURL : String

)