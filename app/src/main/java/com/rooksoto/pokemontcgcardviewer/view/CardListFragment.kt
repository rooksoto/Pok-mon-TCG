package com.rooksoto.pokemontcgcardviewer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.rooksoto.pokemontcgcardviewer.databinding.FragmentListBinding
import com.rooksoto.pokemontcgcardviewer.viewmodel.CardListViewModel

class CardListFragment : Fragment() {

    private lateinit var viewModel: CardListViewModel

    private var binding: FragmentListBinding? = null

    private val cardListAdapter = CardListAdapter(mutableListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val nullableBinding = FragmentListBinding.inflate(inflater, container, false)
        binding = nullableBinding
        return nullableBinding.root
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
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.cardsUiModels.observe(
            viewLifecycleOwner,
            { cardItemUiModels ->
                binding?.apply {
                    listErrorView.errorViewAnimation.isVisible = false
                    listLoadingView.loadingViewAnimation.isVisible = false
                }
                cardListAdapter.updateCardList(cardItemUiModels)
            }
        )

        viewModel.cardsLoadError.observe(
            viewLifecycleOwner,
            { isError ->
                binding?.apply {
                    listErrorView.errorViewRoot.isVisible = isError
                    listLoadingView.loadingViewAnimation.isVisible = false
                }
            }
        )

        viewModel.loading.observe(
            viewLifecycleOwner,
            { isLoading ->
                binding?.apply {
                    listErrorView.errorViewRoot.isVisible = false
                    listLoadingView.loadingViewAnimation.isVisible = isLoading
                }
            }
        )
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}