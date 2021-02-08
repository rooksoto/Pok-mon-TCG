package com.rooksoto.pokemontcgcardviewer.network.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardResponse(
    @SerialName("data") val
    card: Card
)

@Serializable
data class Card(
    val id: String,
    val name: String,
    val hp: Int,
    val types: List<String>,
    val abilities: List<Ability>,
    val set: Set,
    @SerialName("images")
    val cardImages: CardImages
)

@Serializable
data class Ability(
    val name: String,
    @SerialName("text")
    val description: String,
    val type: String
)

@Serializable
data class Set(
    @SerialName("images")
    val typeImages: TypeImages
)

@Serializable
data class CardImages(
    val small: String,
    val large: String
)

@Serializable
data class TypeImages(
    val symbol: String,
    val logo: String
)