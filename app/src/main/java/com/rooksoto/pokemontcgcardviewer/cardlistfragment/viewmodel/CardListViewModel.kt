package com.rooksoto.pokemontcgcardviewer.cardlistfragment.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.rooksoto.pokemontcgcardviewer.cardlistfragment.model.CardItemUiModel
import com.rooksoto.pokemontcgcardviewer.cardlistfragment.model.CardListItemUiModelMapper
import com.rooksoto.pokemontcgcardviewer.network.service.TcgService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.serialization.ExperimentalSerializationApi
import timber.log.Timber

// Using KotlinX Serialization Lints if not annotated as experimental
@ExperimentalSerializationApi
class CardListViewModel : ViewModel() {

    private val service = TcgService() // TODO: Inject?
    private val disposables = CompositeDisposable() // TODO: Add to base?
    private val uiModelMapper = CardListItemUiModelMapper()

    // TODO: Use a UIModel Mapper here
    val cardsUiModels = MutableLiveData<List<CardItemUiModel>>()
    val cardsLoadError = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun refresh() {

        cardsUiModels.value = listOf()
        cardsLoadError.value = false
        loading.value = false

        fetchRemoteCardList()
    }

    private fun fetchRemoteCardList() {
        loading.value = true
        disposables.add(
            service.getCards()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { cardListResponse ->
                        cardsUiModels.value = cardListResponse.cards.map(uiModelMapper::to)
                        cardsLoadError.value = false
                        loading.value = false
                    }, { throwable ->
                        Timber.d("***** -> Error in CardListViewModel: ${throwable.localizedMessage}")
                        cardsLoadError.value = true
                        loading.value = false
                    }
                )
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposables.clear()
    }
}