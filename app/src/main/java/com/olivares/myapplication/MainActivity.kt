package com.olivares.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.olivares.myapplication.models.BoardSize

class MainActivity : AppCompatActivity() {

    // Will be initialized after onCreate
    private lateinit var rvBoard: RecyclerView
    private lateinit var tvMoves: TextView
    private lateinit var tvPairs: TextView

    private var boardSize: BoardSize = BoardSize.HARD

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Making reference to these xml items
        rvBoard = findViewById(R.id.rvBoard)
        tvMoves = findViewById(R.id.tvMoves)
        tvPairs = findViewById(R.id.tvPairs)

        // Adapter is responsible for binding data to each view in the rv
        rvBoard.adapter = MemoryBoardAdapter(this, boardSize)
        rvBoard.setHasFixedSize(true)

        // Setting the layout manager for RV (one of 2 key components)
        // Layout manager is responsible for measuring and positioning items
        rvBoard.layoutManager = GridLayoutManager(this,boardSize.getWidth())




    }
}