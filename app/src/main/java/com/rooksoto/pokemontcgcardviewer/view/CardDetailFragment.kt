package com.rooksoto.pokemontcgcardviewer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rooksoto.pokemontcgcardviewer.R

class CardDetailFragment : Fragment() {

    private var cardId: String? = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        arguments?.let {
            cardId = CardDetailFragmentArgs.fromBundle(it).cardId
        }

        return inflater.inflate(R.layout.fragment_card_detail, container, false)
    }
}