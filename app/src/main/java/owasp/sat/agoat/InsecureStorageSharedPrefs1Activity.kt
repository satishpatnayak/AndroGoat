package owasp.sat.agoat

<<<<<<< HEAD
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
=======
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_insecure_storage_shared_prefs1.*
import org.w3c.dom.Text
import java.io.File
import java.io.StreamCorruptedException
import java.security.PublicKey
import java.util.*
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d

class InsecureStorageSharedPrefs1Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_insecure_storage_shared_prefs1)

<<<<<<< HEAD
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
=======
        val ScoreButton = findViewById<Button>(R.id.getScore);
        ScoreButton.setOnClickListener {
            var scoreValue: Int =  getScoreFromSP()
            var levelValue: Int = 1;
            var newScore: Int = CalculateScore(scoreValue)
            if (CheckScore(newScore)) {
                levelValue=2;
                ScoreButton.isClickable=false
                ScoreButton.text="You won the game"
                Toast.makeText(applicationContext, "Success", Toast.LENGTH_LONG).show();
            }
            else
            {
                //DisplayScore(newScore, levelValue)
                //UpdateScoreInSP(newScore,levelValue)
                Toast.makeText(applicationContext, "Score is " + newScore + ". Try hard", Toast.LENGTH_SHORT).show();
            }
            DisplayScore(newScore,levelValue)
            UpdateScoreInSP(newScore,levelValue)



        }


    }

    fun CalculateScore(Score:Int):Int{
        return Score+1;
    }
    fun CheckScore(Score: Int):Boolean{
       return(Score>10000)
    }
    fun DisplayScore(score:Int, level:Int)
    {
        val Score=findViewById<TextView>(R.id.score);
        val Level=findViewById<TextView>(R.id.level);
        Score.text=score.toString();
        Level.text=level.toString();
        println("Score " +score.toString())
        println("Level " +level.toString())
    }
    fun UpdateScoreInSP(Score: Int, Level: Int)
    {
        val sharedPreference = getSharedPreferences("score", Context.MODE_PRIVATE);
        var editor1 = sharedPreference.edit();
        editor1.putInt("score", Score);
        editor1.putInt("level", Level);
        editor1.commit();
    }

    fun getScoreFromSP():Int
    {
        var Score:Int=0
        var Level:Int=1
        val sharedPreferences = getSharedPreferences("score", Context.MODE_PRIVATE)
        if((sharedPreferences.getInt("score",0) != 0) && sharedPreferences.getInt("level",0)!=0)
        {
            Score=sharedPreferences.getInt("score",0)
            Level=sharedPreferences.getInt("level",0)

       }
        println("Score is " + Score +" and Level is" + Level)
        return Score
    }
}

    /*fun CalulateScore(MaxValue:Int):Int {
        return MaxValue+1;
    }
    fun UpdateScore(score1:Int){
        //update score on screen and in shred_pref
        Toast.makeText(applicationContext, "Score is "+score1, Toast.LENGTH_LONG).show();
        //val score2:Int=score1.toInt();
        val Score=findViewById<TextView>(R.id.score);
        val Level=findViewById<TextView>(R.id.level);
        Score.text=score1.toString();
        var levelValue:Int=1;
        if (score1 > 10)
        {
            levelValue=2;
            val sharedPreference = getSharedPreferences("score", Context.MODE_PRIVATE);
            var editor1=sharedPreference.edit();
            editor1.putInt("score",score1);
            editor1.putInt("level", levelValue);
            editor1.commit();

        }

    }
}*/
>>>>>>> 1f383989bf8435ba8aea245439e1b7f68f2f985d
