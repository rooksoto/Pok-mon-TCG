package com.rooksoto.pokemontcgcardviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rooksoto.pokemontcgcardviewer.model.CardItemUiModel
import com.rooksoto.pokemontcgcardviewer.util.FakeDataUtil

class CardListViewModel : ViewModel() {

    val cardsUiModels = MutableLiveData<List<CardItemUiModel>>()
    val cardsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {
        cardsUiModels.value = FakeDataUtil.getListOfUiModels()
        cardsLoadError.value = false
        loading.value = false
    }
}