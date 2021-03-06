package com.rooksoto.pokemontcgcardviewer.cardlistfragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rooksoto.pokemontcgcardviewer.cardlistfragment.viewmodel.CardListViewModel
import com.rooksoto.pokemontcgcardviewer.databinding.FragmentCardListBinding

class CardListFragment : Fragment() {

    private var binding: FragmentCardListBinding? = null
    private val cardListAdapter = CardListAdapter(mutableListOf())

    private lateinit var viewModel: CardListViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentCardListBinding.inflate(
        inflater,
        container,
        false
    ).let {
        binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProviders.of(this)
            .get(CardListViewModel::class.java)
        viewModel.refresh()

        binding?.apply {
            cardList.apply {
                layoutManager = LinearLayoutManager(context)
                adapter = cardListAdapter
            }

            refreshLayout.setOnRefreshListener {
                refreshLayout.isRefreshing = false
                cardList.isInvisible = true
                errorView.errorViewRoot.isVisible = false
                loadingView.loadingViewAnimation.isVisible = true
                viewModel.refresh()
            }
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.cardsUiModels.observe(
            viewLifecycleOwner,
            { cardItemUiModels ->
                cardListAdapter.updateCardList(cardItemUiModels)
                binding?.apply {
                    cardList.isInvisible = false
                    errorView.errorViewRoot.isVisible = false
                    loadingView.loadingViewAnimation.isVisible = false
                }
            }
        )

        viewModel.cardsLoadError.observe(
            viewLifecycleOwner,
            { isError ->
                binding?.apply {
                    errorView.errorViewRoot.isVisible = isError
                    loadingView.loadingViewAnimation.isVisible = false
                }
            }
        )

        viewModel.loading.observe(
            viewLifecycleOwner,
            { isLoading ->
                binding?.apply {
                    loadingView.loadingViewAnimation.isVisible = isLoading
                }
            }
        )
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}