package com.rooksoto.pokemontcgcardviewer.util

import com.rooksoto.pokemontcgcardviewer.cardlistfragment.model.CardItemUiModel
import java.util.*

class FakeDataUtil {

    companion object {
        fun getListOfUiModels() = listOf(
            cardItemUiModel1,
            cardItemUiModel2,
            cardItemUiModel3,
            cardItemUiModel4,
            cardItemUiModel5,
            cardItemUiModel6,
            cardItemUiModel7
        )

        fun getRandomCardUiModel() = getListOfUiModels().random()

        val cardItemUiModel1 = CardItemUiModel(
            cardId = UUID.randomUUID().toString(),
            cardImageUrl = null,
            name = "Rook",
            abilityName = "The Moves.",
            abilityDescription = "I got the moves like Jagger.",
            priceLow = 1.00,
            priceMid = 2.00,
            priceHigh = 5.00,
            priceMarket = 4.00
        )
        val cardItemUiModel2 = CardItemUiModel(
            cardId = UUID.randomUUID().toString(),
            cardImageUrl = null,
            name = "Rook",
            abilityName = "The Moves.",
            abilityDescription = "I got the moves like Jagger.,",
            priceLow = 1.00,
            priceMid = 2.00,
            priceHigh = 5.00,
            priceMarket = 4.00
        )
        val cardItemUiModel3 = CardItemUiModel(
            cardId = UUID.randomUUID().toString(),
            cardImageUrl = null,
            name = "Rook",
            abilityName = "The Moves.",
            abilityDescription = "I got the moves like Jagger.,",
            priceLow = 1.00,
            priceMid = 2.00,
            priceHigh = 5.00,
            priceMarket = 4.00
        )
        val cardItemUiModel4 = CardItemUiModel(
            cardId = UUID.randomUUID().toString(),
            cardImageUrl = null,
            name = "Rook",
            abilityName = "The Moves.",
            abilityDescription = "I got the moves like Jagger.,",
            priceLow = 1.00,
            priceMid = 2.00,
            priceHigh = 5.00,
            priceMarket = 4.00
        )
        val cardItemUiModel5 = CardItemUiModel(
            cardId = UUID.randomUUID().toString(),
            cardImageUrl = null,
            name = "Rook",
            abilityName = "The Moves.",
            abilityDescription = "I got the moves like Jagger.,",
            priceLow = 1.00,
            priceMid = 2.00,
            priceHigh = 5.00,
            priceMarket = 4.00
        )
        val cardItemUiModel6 = CardItemUiModel(
            cardId = UUID.randomUUID().toString(),
            cardImageUrl = null,
            name = "Rook",
            abilityName = "The Moves.",
            abilityDescription = "I got the moves like Jagger.,",
            priceLow = 1.00,
            priceMid = 2.00,
            priceHigh = 5.00,
            priceMarket = 4.00
        )
        val cardItemUiModel7 = CardItemUiModel(
            cardId = UUID.randomUUID().toString(),
            cardImageUrl = null,
            name = "Rook",
            abilityName = "The Moves.",
            abilityDescription = "I got the moves like Jagger.,",
            priceLow = 1.00,
            priceMid = 2.00,
            priceHigh = 5.00,
            priceMarket = 4.00
        )
    }
}