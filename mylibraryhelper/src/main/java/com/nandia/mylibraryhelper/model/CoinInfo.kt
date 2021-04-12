package com.nandia.mylibraryhelper.model

import com.google.gson.annotations.SerializedName

   
data class CoinInfo (

   @SerializedName("Id") var Id : String,
   @SerializedName("Name") var Name : String,
   @SerializedName("FullName") var FullName : String,
   @SerializedName("Internal") var Internal : String,
   @SerializedName("ImageUrl") var ImageUrl : String,
   @SerializedName("Url") var Url : String,
   @SerializedName("Algorithm") var Algorithm : String,
   @SerializedName("ProofType") var ProofType : String,
   @SerializedName("Rating") var Rating : Rating,
//   @SerializedName("NetHashesPerSecond") var NetHashesPerSecond : Int,
   @SerializedName("BlockNumber") var BlockNumber : Int,
   @SerializedName("BlockTime") var BlockTime : Double,
   @SerializedName("BlockReward") var BlockReward : Double,
   @SerializedName("AssetLaunchDate") var AssetLaunchDate : String,
//   @SerializedName("MaxSupply") var MaxSupply : Int,
   @SerializedName("Type") var Type : Int,
   @SerializedName("DocumentType") var DocumentType : String

)