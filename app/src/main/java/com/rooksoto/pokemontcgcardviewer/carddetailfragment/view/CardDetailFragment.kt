package com.rooksoto.pokemontcgcardviewer.carddetailfragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rooksoto.pokemontcgcardviewer.databinding.FragmentCardDetailBinding

class CardDetailFragment : Fragment() {

    private var cardId: String? = ""
    private var binding: FragmentCardDetailBinding? = null

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

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}