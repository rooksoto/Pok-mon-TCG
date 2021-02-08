package com.rooksoto.pokemontcgcardviewer.network.service

import com.rooksoto.pokemontcgcardviewer.network.models.CardListResponse
import com.rooksoto.pokemontcgcardviewer.network.models.CardResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface TcgApi {

    @GET("cards")
    fun getCards(): Single<CardListResponse>

    @GET("cards/{id}")
    fun getCard(
        @Path("id") id: String
    ): Single<CardResponse>
}