package com.rooksoto.pokemontcgcardviewer.cardlistfragment.model

import com.rooksoto.pokemontcgcardviewer.network.models.Card
import com.rooksoto.pokemontcgcardviewer.network.models.Financial
import com.rooksoto.pokemontcgcardviewer.network.models.PriceList

private const val UNKNOWN = "UNK"

class CardListItemUiModelMapper {

    fun to(card: Card): CardItemUiModel {
        with(card) {
            return CardItemUiModel(
                cardId = id,
                cardImageUrl = cardImages.small,
                name = name,
                abilityName = abilities?.first()?.name,
                abilityDescription = abilities?.first()?.description,
                priceLow = financial.getLowPrice(),
                priceMid = financial.getMidPrice(),
                priceHigh = financial.getHighPrice(),
                priceMarket = financial.getMarketPrice()
            )
        }
    }

    private fun Financial.getLowPrice(): String =
        getPriceList()?.low?.toString() ?: UNKNOWN

    fun Financial.getMidPrice(): String =
        getPriceList()?.mid?.toString() ?: UNKNOWN

    private fun Financial.getHighPrice(): String =
        getPriceList()?.high?.toString() ?: UNKNOWN

    private fun Financial.getMarketPrice(): String =
        getPriceList()?.market?.toString() ?: UNKNOWN

    private fun Financial.getPriceList(): PriceList? =
        with(prices) {
            (normal ?: holofoil ?: reverseHolofoil)
        }

}
