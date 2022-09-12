package com.example.scoreboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var teamALabel = 0
    private var teamBLabel = 0

    private lateinit var scoreTeamA: TextView
    private lateinit var scoreTeamB: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        scoreTeamA = findViewById(R.id.scoreA)
        scoreTeamB = findViewById(R.id.scoreB)

        scoreTeamA.text = teamALabel.toString()
        scoreTeamB.text = teamBLabel.toString()

        val addPoint1TeamA: Button = findViewById(R.id.points1_button_A)
        val addPoint2TeamA: Button = findViewById(R.id.points2_button_A)
        val addPoint3TeamA: Button = findViewById(R.id.points3_button_A)

        val addPoint1TeamB: Button = findViewById(R.id.points1_button_B)
        val addPoint2TeamB: Button = findViewById(R.id.points2_button_B)
        val addPoint3TeamB: Button = findViewById(R.id.points3_button_B)

        val resetButton: Button = findViewById(R.id.reset_button)

        addPoint1TeamA.setOnClickListener {addScoreTeamA(1) }
        addPoint2TeamA.setOnClickListener {addScoreTeamA(2) }
        addPoint3TeamA.setOnClickListener {addScoreTeamA(3) }

        addPoint1TeamB.setOnClickListener {addScoreTeamB(1) }
        addPoint2TeamB.setOnClickListener {addScoreTeamB(2) }
        addPoint3TeamB.setOnClickListener {addScoreTeamB(3) }

        resetButton.setOnClickListener {
            teamALabel = 0
            teamBLabel = 0
            scoreTeamA.text = "0"
            scoreTeamB.text = "0"
        }
    }
    private fun addScoreTeamA(points: Int){
        teamALabel += points
        scoreTeamA.text = teamALabel.toString()
    }

    private fun addScoreTeamB(points: Int){
        teamBLabel += points
        scoreTeamB.text = teamBLabel.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putInt("Team_A_Score", teamALabel)
        outState.putInt("Team_B_Score", teamBLabel)
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        teamALabel = savedInstanceState.getInt("Team_A_Score")
        teamBLabel = savedInstanceState.getInt("Team_B_Score")
        scoreTeamA.text = teamALabel.toString()
        scoreTeamB.text = teamBLabel.toString()

    }

}