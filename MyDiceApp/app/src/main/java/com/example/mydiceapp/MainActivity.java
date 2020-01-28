package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.MediaRouteButton;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        final ImageView diceImg1 = findViewById (R.id.imgDice1);
        final ImageView diceImg2 = findViewById (R.id.imgDice2);

        final int[] DiceArray = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6,};

        Button btnRoll = findViewById (R.id.btnRoll);
        final MediaPlayer mp = MediaPlayer.create (this, R.raw.dice_sound);

        btnRoll.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                /*Creating a Random class Object to generate Random Numbers*/

                Random rndObj = new Random ();
                int myRandomNumber = rndObj.nextInt (6); // Bound gives random number between 0 .. 5

                //Log.i ("DiceRoller", "The generated Random Number is " + myRandomNumber);

                diceImg1.setImageResource (DiceArray[myRandomNumber]);

                myRandomNumber = rndObj.nextInt (6);
                diceImg2.setImageResource (DiceArray[myRandomNumber]);

                mp.start ();
            }
        });
    }
}
