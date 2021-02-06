package com.rooksoto.pokemontcgcardviewer.view

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rooksoto.pokemontcgcardviewer.R
import com.rooksoto.pokemontcgcardviewer.model.CardItemUiModel


class CardListAdapter(
    private val cardItemUiModels: MutableList<CardItemUiModel>
) : RecyclerView.Adapter<CardListAdapter.CardViewHolder>() {

    fun updateCardList(newList: List<CardItemUiModel>) {
        cardItemUiModels.clear()
        cardItemUiModels.addAll(newList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_card, parent, false)
        return CardViewHolder(view)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        val uiModel = cardItemUiModels[position]
        holder.bind(uiModel)
    }

    override fun getItemCount(): Int =
        cardItemUiModels.count()

    class CardViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val colorList: List<String> =
            listOf(
                "#3F51B5",
                "#673AB7",
                "#FF5722",
                "#607D8B",
                "#795548",
                "#E91E63"
            )

        fun bind(uiModel: CardItemUiModel) = with(view) {
            findViewById<ImageView>(R.id.card_item_image).setBackgroundColor(
                getRandomColor()
            )
            findViewById<TextView>(R.id.card_item_name).text =
                uiModel.name
            findViewById<TextView>(R.id.card_item_ability_description).text =
                uiModel.abilityDescription

            findViewById<TextView>(R.id.card_item_price_low).text =
                uiModel.priceLow.toString()
            findViewById<TextView>(R.id.card_item_price_mid).text =
                uiModel.priceMid.toString()
            findViewById<TextView>(R.id.card_item_price_high).text =
                uiModel.priceHigh.toString()
            findViewById<TextView>(R.id.card_item_price_market).text =
                uiModel.priceMarket.toString()
        }

        private fun getRandomColor(): Int =
            Color.parseColor(colorList.random())
    }
}