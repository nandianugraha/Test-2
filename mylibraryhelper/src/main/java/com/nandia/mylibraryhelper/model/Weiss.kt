package com.nandia.mylibraryhelper.model

import com.google.gson.annotations.SerializedName

   
data class Weiss (

   @SerializedName("Rating") var Rating : String,
   @SerializedName("TechnologyAdoptionRating") var TechnologyAdoptionRating : String,
   @SerializedName("MarketPerformanceRating") var MarketPerformanceRating : String

)