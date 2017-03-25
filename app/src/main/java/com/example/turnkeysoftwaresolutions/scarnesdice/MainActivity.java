package com.example.turnkeysoftwaresolutions.scarnesdice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int userOverallScore = 0;
    int userTurnScore = 0;
    int computerOverallScore = 0;
    int computerTurnScore = 0;

    public static int randomDieNumber() {

        Random r = new Random();
        int Low = 1;
        int High = 6;

        return r.nextInt(High - Low) + Low;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Testing","TestingTestin");

        final Button rollButton = (Button) findViewById(R.id.UIButtonRoll);
        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                ImageView diceImageView = (ImageView) findViewById(R.id.imageViewDice);

                int randomNumber = randomDieNumber();
                switch (randomNumber) {
                    case 1: {
                        diceImageView.setImageResource(R.drawable.dice1);
                        break;
                    }
                    case 2: {
                        diceImageView.setImageResource(R.drawable.dice2);
                        break;
                    }
                    case 3: {
                        diceImageView.setImageResource(R.drawable.dice3);
                        break;
                    }
                    case 4: {
                        diceImageView.setImageResource(R.drawable.dice4);
                        break;
                    }
                    case 5: {
                        diceImageView.setImageResource(R.drawable.dice5);
                        break;
                    }
                    case 6: {
                        diceImageView.setImageResource(R.drawable.dice6);
                        break;
                    }
                }
            }
        });

        final Button holdButton = (Button) findViewById(R.id.UIButtonHold);
        holdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

            }
        });

        final Button resetButton = (Button) findViewById(R.id.UIButtonReset);
        holdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click

            }
        });

    }
}
