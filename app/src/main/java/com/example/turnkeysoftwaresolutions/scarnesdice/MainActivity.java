package com.example.turnkeysoftwaresolutions.scarnesdice;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int userOverallScore = 0;
    int userTurnScore = 0;
    int computerOverallScore = 0;
    int computerTurnScore = 0;

    Button holdButton;
    Button rollButton;
    TextView userStatus;
    TextView computerStatus;
    private Handler mHandler = new Handler();

    public static int randomDieNumber() {
        Random r = new Random();
        int Low = 1;
        int High = 6;
        return r.nextInt(High - Low) + Low;
    }

    public int rollTheDie() {
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
        return randomNumber;
    }

    public void updateScore() {
        TextView scoreTextView = (TextView) findViewById(R.id.scoreTextView);
        scoreTextView.setText("Your score: " + userOverallScore + "           |  Computer score: " + computerOverallScore + "\n"
                + "User turn score: " + userTurnScore + "   |  Computer turn score: " + computerTurnScore);
    }

    private void doStuff() {
        Toast.makeText(this, "Delayed Toast!", Toast.LENGTH_SHORT).show();
    }

    public void computerTurn() {
        boolean computerSawOne = false;
        while (computerTurnScore < 20) {
            holdButton.setEnabled(false);
            rollButton.setEnabled(false);
            int randomNumber = rollTheDie();
            if (randomNumber != 1) {
                computerTurnScore += randomNumber;
                updateScore();
            } else {
                computerTurnScore = 0;
                holdButton.setEnabled(true);
                rollButton.setEnabled(true);
                userTurn();
                computerSawOne = true;
                computerStatus.setText("Computer rolled a one");
                updateScore();
            }
        }

        int randomNumber = rollTheDie();
        if ((randomNumber != 1) && (!computerSawOne)) {
            computerTurnScore += randomNumber;
            computerOverallScore += computerTurnScore;
            computerTurnScore = 0;
            updateScore();
            computerStatus.setText("Computer Holds");
        }
        updateScore();
        userTurn();
    }

    public void userTurn() {
        holdButton.setEnabled(true);
        rollButton.setEnabled(true);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        holdButton = (Button) findViewById(R.id.UIButtonHold);
        rollButton = (Button) findViewById(R.id.UIButtonRoll);
        computerStatus = (TextView) findViewById(R.id.computerStatusTextView);
        userStatus = (TextView) findViewById(R.id.userStatusTextView);

        final Button rollButton = (Button) findViewById(R.id.UIButtonRoll);
        rollButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                int randomNumber = rollTheDie();
                if (randomNumber != 1) {
                    userTurnScore += randomNumber;
                    updateScore();
                } else {
                    userTurnScore = 0;
                    updateScore();
                    computerTurn();
                    userStatus.setText("User rolled a one");
                }
            }
        });

        final Button holdButton = (Button) findViewById(R.id.UIButtonHold);
        holdButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                userOverallScore += userTurnScore;
                userTurnScore = 0;
                updateScore();
                computerTurn();
                userStatus.setText("User holds");
            }
        });

        final Button resetButton = (Button) findViewById(R.id.UIButtonReset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Perform action on click
                userTurnScore = 0;
                userOverallScore = 0;
                computerTurnScore = 0;
                computerOverallScore = 0;
                updateScore();
            }
        });

    }
}
