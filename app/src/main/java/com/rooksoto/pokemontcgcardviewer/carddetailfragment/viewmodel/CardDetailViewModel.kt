package com.rooksoto.pokemontcgcardviewer.carddetailfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rooksoto.pokemontcgcardviewer.carddetailfragment.model.CardUiModel
import java.util.*

class CardDetailViewModel : ViewModel() {

    // TODO: Use a UIModel Mapper here
    val cardModel = MutableLiveData<CardUiModel>()

    fun fetch() {
        val cardUiModel = CardUiModel(
            cardId = UUID.randomUUID().toString(),
            name = "Rook",
            cardImageUrl = "",
            hp = 109,
            typeImage = ""
        )

        cardModel.value = cardUiModel
    }
}