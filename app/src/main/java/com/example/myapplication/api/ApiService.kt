package com.example.myapplication.api

import com.example.myapplication.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {

    @POST("user/authenticate")
    suspend fun authenticate(@Body body: DCBAuth): Response<DCBAuth>

    @POST("user/association")
    suspend fun association(@Body body: DCBAuth): Response<OtpResp>

    @POST("user/purchase")
    suspend fun purchase(@Body body: DcbPurchase): Response<OtpResp>

    @GET("user/subscription_details")
    suspend fun subscriptionDetails(): Response<MutableList<DcbSubscription>>

    @GET("user/wallet")
    suspend fun walletDetails(@Query("phone_number") phone_number: String): Response<BillingResp>
}
