package com.wiprotask.telstra.model

import com.wiprotask.telstra.Fact
import com.google.gson.annotations.SerializedName

data class FactList(@SerializedName("title") val title:String , @SerializedName("rows") val mList: List<Fact>)
