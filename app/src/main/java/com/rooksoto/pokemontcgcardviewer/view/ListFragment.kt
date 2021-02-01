package com.rooksoto.pokemontcgcardviewer.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.rooksoto.pokemontcgcardviewer.R

class ListFragment : Fragment() {

    private lateinit var listTextView: TextView
    private lateinit var detailButton: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpViews(view)
    }

    private fun setUpViews(rootView: View) =
        with(rootView) {
            listTextView = findViewById(R.id.list_text_view)
            detailButton = findViewById<FloatingActionButton>(R.id.list_view_detail_fab).apply {
                setOnClickListener {
                    val directions = ListFragmentDirections.actionListFragmentToCardDetailFragment()
                    Navigation.findNavController(it).navigate(directions)
                }
            }
        }
}