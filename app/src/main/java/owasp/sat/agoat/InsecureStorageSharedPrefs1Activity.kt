package owasp.sat.agoat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class InsecureStorageSharedPrefs1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage_shared_prefs1)

        val currentScore = getScoreFromSP()
        val sharedPreferences = getSharedPreferences("score", MODE_PRIVATE)
        val currentLevel = sharedPreferences.getInt("level", 1) // Default to level 1
        displayScore(currentScore, currentLevel)

        val ScoreButton = findViewById<Button>(R.id.getScore)
        ScoreButton.setOnClickListener {
            val scoreValue: Int = getScoreFromSP()
            var levelValue = currentLevel
            val newScore: Int = calculateScore(scoreValue)
            val builder = androidx.appcompat.app.AlertDialog.Builder(this)
            builder.setTitle("Hurray!")
            if (checkScore(newScore)) {
                levelValue = 2
                ScoreButton.isClickable = false
                builder.setMessage("You won the game")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                val dialog = builder.create()
                dialog.show()
                ScoreButton.text = "You won the game"
                Toast.makeText(applicationContext, "You won the game", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(applicationContext, "Score is $newScore. Try hard", Toast.LENGTH_SHORT).show()
            }

            displayScore(newScore, levelValue)
            updateScoreInSP(newScore, levelValue)
        }
    }

    private fun calculateScore(score: Int): Int {
        return score + 1
    }

    private fun checkScore(score: Int): Boolean {
        return score > 10000
    }

    private fun displayScore(score: Int, level: Int) {
        val scoreTv = findViewById<TextView>(R.id.score)
        val levelTv = findViewById<TextView>(R.id.level)
        scoreTv.text = score.toString()
        levelTv.text = level.toString()
        println("Score $score")
        println("Level $level")
    }

    private fun updateScoreInSP(score: Int, level: Int) {
        val sharedPreference = getSharedPreferences("score", MODE_PRIVATE)
        val editor = sharedPreference.edit()
        editor.putInt("score", score)
        editor.putInt("level", level)
        editor.commit()
    }

    private fun getScoreFromSP(): Int {
        var score = 0
        var level = 1
        val sharedPreferences = getSharedPreferences("score", MODE_PRIVATE)
        if (sharedPreferences.getInt("score", 0) != 0 && sharedPreferences.getInt("level", 0) != 0) {
            score = sharedPreferences.getInt("score", 0)
            level = sharedPreferences.getInt("level", 0)
        }
        println("Score is $score and Level is $level")
        return score
    }
}
