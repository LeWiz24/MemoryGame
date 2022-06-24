package com.olivares.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.olivares.myapplication.models.BoardSize
import com.olivares.myapplication.models.MemoryCard
import kotlin.math.min

class MemoryBoardAdapter(
    private val context: Context,
    private val boardSize: BoardSize,
    private val cards: List<MemoryCard>,
    private val cardClickListener: CardClickListener
) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object {
        private const val MARGIN_SIZE = 10
        private const val TAG = "MemoryBoardAdapter"
    }

    interface CardClickListener {
        fun onCardClicked(position: Int,)

        
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Set size of each element here
        val cardWidth = (parent.width / boardSize.getWidth()) - (2 * MARGIN_SIZE)
        val cardHeight = (parent.height / boardSize.getHeight()) - (2 * MARGIN_SIZE)
        val cardLength = min(cardHeight, cardWidth)

        // Inflate our layout here
        val view = LayoutInflater.from(context).inflate(R.layout.memory_card, parent, false)

        // Set the width and height here
        val layoutParams =
            view.findViewById<CardView>(R.id.cardView).layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.width = cardLength
        layoutParams.height = cardLength
        layoutParams.setMargins(MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE, MARGIN_SIZE)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    // Sets item count to hte number of pieces on screen
    override fun getItemCount(): Int = boardSize.numCards


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            val memoryCard = cards[position]
            imageButton.setImageResource( if (memoryCard.isFaceUp) memoryCard.identifier else R.drawable.ic_launcher_background)

            imageButton.setOnClickListener {
                cardClickListener.onCardClicked(position)


            }

        }

    }
}
