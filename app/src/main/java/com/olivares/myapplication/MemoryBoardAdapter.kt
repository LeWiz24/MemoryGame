package com.olivares.myapplication

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import kotlin.math.min

class MemoryBoardAdapter(private val context: Context, private val numPieces: Int) :
    RecyclerView.Adapter<MemoryBoardAdapter.ViewHolder>() {

    companion object {
        private const val MARGIN_SIZE = 10
        private const val TAG = "MemoryBoardAdapter"
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        // Set size of each element here
        val cardWidth = (parent.width / 2) - (2 * MARGIN_SIZE)
        val cardHeight = (parent.height / 4) - (2 * MARGIN_SIZE)
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
    override fun getItemCount() = numPieces


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imageButton = itemView.findViewById<ImageButton>(R.id.imageButton)
        fun bind(position: Int) {
            imageButton.setOnClickListener {
                Log.i(TAG, "Clicked on position $position ")

            }

        }

    }
}
