package com.rooksoto.pokemontcgcardviewer.cardlistfragment.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rooksoto.pokemontcgcardviewer.R
import com.rooksoto.pokemontcgcardviewer.cardlistfragment.model.CardItemUiModel
import com.rooksoto.pokemontcgcardviewer.util.cardImageProgressDrawable


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
            setOnClickListener {
                Navigation.findNavController(this)
                    .navigate(CardListFragmentDirections.actionListFragmentToCardDetailFragment())
            }

            findViewById<ImageView>(R.id.card_item_image).load(
                uiModel.cardImageUrl
            ) {
                crossfade(true)
                placeholder(cardImageProgressDrawable(context))
                error(R.drawable.ic_launcher_foreground)
            }

            findViewById<TextView>(R.id.card_item_name).text =
                uiModel.name
            findViewById<TextView>(R.id.card_item_ability_description).text =
                uiModel.abilityDescription

            findViewById<TextView>(R.id.card_item_price_low).text =
                uiModel.priceLow
            findViewById<TextView>(R.id.card_item_price_mid).text =
                uiModel.priceMid
            findViewById<TextView>(R.id.card_item_price_high).text =
                uiModel.priceHigh
            findViewById<TextView>(R.id.card_item_price_market).text =
                uiModel.priceMarket
        }
    }
}