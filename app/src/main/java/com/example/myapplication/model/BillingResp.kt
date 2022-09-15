package com.example.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class BillingResp(

    @SerializedName("is_success")
    @Expose
    var success: Boolean? = false,

    @SerializedName("message")
    @Expose
    var message: String? = null,

    @SerializedName("wallet_details")
    @Expose
    var wallet_details: Wallet? = null,

    )


