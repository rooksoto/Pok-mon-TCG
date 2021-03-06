package com.rooksoto.pokemontcgcardviewer.network.service

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rooksoto.pokemontcgcardviewer.network.models.CardListResponse
import com.rooksoto.pokemontcgcardviewer.network.models.CardResponse
import io.reactivex.Single
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory

private const val BASE_URL = "https://api.pokemontcg.io/v2/"

// Using KotlinX Serialization Lints if not annotated as experimental
@ExperimentalSerializationApi
class TcgService {
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(
            Json {
                ignoreUnknownKeys = true
            }.asConverterFactory(
                MediaType.get("application/json")
            )
        )
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(TcgApi::class.java)

    fun getCards(): Single<CardListResponse> = api.getCards()

    fun getCard(id: String): Single<CardResponse> = api.getCard(id)
}
