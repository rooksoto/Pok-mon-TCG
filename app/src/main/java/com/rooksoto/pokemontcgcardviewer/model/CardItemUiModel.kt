package com.rooksoto.pokemontcgcardviewer.model

data class CardItemUiModel(
    val cardId: String?,
    val cardImageLargeUrl: String?,
    val cardImageSmallUrl: String?,
    val name: String?,
    val ability: String?,
    val abilityDescription: String?,
    val priceLow: Double?,
    val priceMid: Double?,
    val priceHigh: Double?,
    val priceMarket: Double?
)
