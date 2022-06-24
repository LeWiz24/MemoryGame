package com.olivares.myapplication.models

import com.olivares.myapplication.utils.DEFAULT_ICONS

class MemoryGame (private val boardSize: BoardSize){

    val cards: List<MemoryCard>
    val numPairsFound = 0

    init {
        // Shuffle and get resourcces from constants cile
        val chosenImage = DEFAULT_ICONS.shuffled().take(boardSize.getNumPairs())
        val randomizedImages = (chosenImage + chosenImage).shuffled()

        // Transformed randomizedimage to new list based on operation
         cards = randomizedImages.map { MemoryCard(it) }
    }

}
