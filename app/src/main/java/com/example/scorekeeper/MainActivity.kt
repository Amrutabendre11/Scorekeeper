package com.example.scorekeeper

import android.net.wifi.rtt.CivicLocationKeys.STATE
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate

class MainActivity : AppCompatActivity() {
    private var mScore1 = 0
    private var mScore2 = 0
    private var mScoreText1: TextView? = null
    private var mScoreText2: TextView? = null
    val STATE_SCORE_1 = "Team 1 Score"
    val STATE_SCORE_2 = "Team 2 Score"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mScoreText1 = findViewById(R.id.score_1);
        mScoreText2 = findViewById(R.id.score_2);


        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
//            mScoreText1.text = mScore1.toString()
//            //mScoreText1.setText((mScore1).toString());
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mScore1)
        outState.putInt(STATE_SCORE_2, mScore2)
        super.onSaveInstanceState(outState)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)

        // Change the label of the menu based on the state of the app.
        val nightMode = AppCompatDelegate.getDefaultNightMode()
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu!!.findItem(R.id.night_mode).setTitle(R.string.day_mode)
        } else {
            menu?.findItem(R.id.night_mode)?.setTitle(R.string.night_mode)
        }
        return true
        //return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId === R.id.night_mode) {
                        // Get the night mode state of the app.
                        val nightMode = AppCompatDelegate.getDefaultNightMode()
                        // Set the theme mode for the restarted activity.
                        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                        } else {
                            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                        }
                        // Recreate the activity for the theme change to take effect.
                        recreate()
                    }
                    return true
    }

    fun decreaseScore(view: View) {
        // Get the ID of the button that was clicked
        val viewID: Int = view.getId()
        when (viewID) {
            R.id.decreaseTeam1 -> {
                //Decrement the score and update the TextView
                mScore1--
                mScoreText1?.setText(mScore1.toString())
            }
            R.id.decreaseTeam2 -> {
                //Decrement the score and update the TextView
                mScore2--
                mScoreText2?.setText(mScore2.toString())
            }
        }
    }

    fun increaseScore(view: View) {
        // Get the ID of the button that was clicked
        val viewID: Int = view.getId()
        when (viewID) {

            R.id.increaseTeam1 -> {
                //Decrement the score and update the TextView
                mScore1++
                mScoreText1?.setText(mScore1.toString())
            }
            R.id.increaseTeam2 -> {
                //Decrement the score and update the TextView
                mScore2++
                mScoreText2?.setText(mScore2.toString())
            }

        }
    }

}
