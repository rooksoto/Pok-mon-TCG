package com.rooksoto.pokemontcgcardviewer.carddetailfragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.rooksoto.pokemontcgcardviewer.R
import com.rooksoto.pokemontcgcardviewer.carddetailfragment.viewmodel.CardDetailViewModel
import com.rooksoto.pokemontcgcardviewer.databinding.FragmentCardDetailBinding

class CardDetailFragment : Fragment() {

    private var cardId: String? = ""
    private var binding: FragmentCardDetailBinding? = null

    private lateinit var viewModel: CardDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        arguments?.let {
            cardId = CardDetailFragmentArgs.fromBundle(it).cardId
        }

        return FragmentCardDetailBinding.inflate(
            inflater,
            container,
            false
        ).let {
            binding = it
            it.root
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(CardDetailViewModel::class.java)
        viewModel.fetch()

        observeViewModel()
    }

    private fun observeViewModel() =
        with(viewModel) {
            cardModel.observe(
                viewLifecycleOwner,
                { cardUiModel ->
                    binding?.apply {
                        // TODO: Set cardImage
                        // binding?.cardImage
                        name.text = cardUiModel.name
                        val hpText = "${cardUiModel.hp} ${getString(R.string.hp)}"
                        hpValue.text = hpText
                        // binding?.typeImage
                    }
                }
            )
        }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}