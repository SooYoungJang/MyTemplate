package com.sooyoung.data.ticker.remote

import com.sooyoung.data.ticker.remote.model.TickerInfo
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET

interface TickerApi {

    @GET("v1/ticker/detailed/all")
    suspend fun getAllTickerDetail(): Map<String,TickerInfo>

}