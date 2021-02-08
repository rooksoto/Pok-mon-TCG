package com.rooksoto.pokemontcgcardviewer.cardlistfragment.model

data class CardItemUiModel(
    val cardId: String?,
    val cardImageUrl: String?,
    val name: String?,
    val abilityName: String?,
    val abilityDescription: String?,
    val priceLow: String,
    val priceMid: String,
    val priceHigh: String,
    val priceMarket: String
)
