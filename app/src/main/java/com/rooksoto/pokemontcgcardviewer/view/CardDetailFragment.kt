package com.rooksoto.pokemontcgcardviewer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rooksoto.pokemontcgcardviewer.R

class CardDetailFragment : Fragment() {

    private lateinit var detailTextView: TextView
    private lateinit var listButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_card_detail, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews(view)
    }

    private fun setUpViews(rootView: View) =
        with(rootView) {
            detailTextView = findViewById(R.id.detail_text_view)
        }
}