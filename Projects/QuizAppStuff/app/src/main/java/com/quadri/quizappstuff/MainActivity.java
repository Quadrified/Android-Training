package com.quadri.quizappstuff;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

/* This class is the Controller in MVC */

public class MainActivity extends AppCompatActivity {

    private final String SCORE_KEY = "SCORE";
    private final String INDEX_KEY = "INDEX";

    private TextView mTxtQuestion, mStats;
    private ProgressBar mProgressbar;
    private Button btnTrue, btnFalse;
    private int mQuestionIndex; // Initial value: 0
    private int mQuizQuestion, mUserScore;

    private QuizModel[] questionCollection = new QuizModel[]{

            new QuizModel(R.string.q1, true),
            new QuizModel(R.string.q2, true),
            new QuizModel(R.string.q3, false),
            new QuizModel(R.string.q4, false),
            new QuizModel(R.string.q5, true),
    };

    final int USER_PROGRESS = (int) Math.ceil(100.00 / questionCollection.length);

    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {

            mUserScore     = savedInstanceState.getInt(SCORE_KEY);
            mQuestionIndex = savedInstanceState.getInt(INDEX_KEY);
        } else {

            mUserScore     = 0;
            mQuestionIndex = 0;
        }

        Toast.makeText(this, "Lifecycle method \n 'onCreate()' is called", Toast.LENGTH_SHORT).show();

        mTxtQuestion = findViewById(R.id.textQuestions);
        btnTrue      = findViewById(R.id.btnTrue);
        btnFalse     = findViewById(R.id.btnFalse);
        mProgressbar = findViewById(R.id.progressBar);
        mStats       = findViewById(R.id.txtStats);

        QuizModel q1 = questionCollection[ mQuestionIndex ];
        mQuizQuestion = q1.getmQuestion();
        mTxtQuestion.setText(mQuizQuestion);

        mStats.setText(mUserScore + "");

        /* An ANONYMOUS OnClickListener i.e., Creating OnClickListener on the spot */

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                evaluateAnswers(true);
                changeQuestion();
            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {

                evaluateAnswers(false);
                changeQuestion();
            }
        });
    }

    private void changeQuestion () {

        mQuestionIndex = (mQuestionIndex + 1) % 5; // To loop inside the quiz question list. % by 5 because we got 5 questions

        if(mQuestionIndex == 0) {

            /* After reaching the last question */

            AlertDialog.Builder quizAlert = new AlertDialog.Builder(this); // Creating an alert

            quizAlert.setCancelable(false); // Disabling the alert to go away on tapping the empty spaces on app

            quizAlert.setTitle("Quiz has finished!");

            quizAlert.setMessage("Your score is: " + mUserScore);

            quizAlert.setPositiveButton("Finish Quiz", new DialogInterface.OnClickListener() {
                @Override
                public void onClick (DialogInterface dialog, int which) {
                    finish();
                }
            });
            quizAlert.show();
        }

        mQuizQuestion = questionCollection[ mQuestionIndex ].getmQuestion();

        mTxtQuestion.setText(mQuizQuestion); // Setting next question

        /* Feedback to user */

        mProgressbar.incrementProgressBy(USER_PROGRESS); // Showing Progress in Progress Bar

        mStats.setText(mUserScore + ""); // Showing user score on screen

    }

    private void evaluateAnswers (boolean userGuess) {

        boolean currentQuestionAnswer = questionCollection[ mQuestionIndex ].ismAnswer();

        if(currentQuestionAnswer == userGuess) {

            Toast.makeText(MainActivity.this, R.string.correct_toast_message, Toast.LENGTH_LONG).show();

            mUserScore = mUserScore + 1;

        } else {

            Toast.makeText(MainActivity.this, R.string.incorrect_toast_message, Toast.LENGTH_LONG).show();

        }
    }

    // Android Lifecycle methods

    @Override
    protected void onStart () {
        super.onStart();
        Toast.makeText(this, " Lifecycle method \n 'onStart()' is called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume () {
        super.onResume();
        Toast.makeText(this, " Lifecycle method \n  'onResume()' is called", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause () {
        super.onPause();
        Toast.makeText(this, " Lifecycle method \n 'onPause()' is called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop () {
        super.onStop();
        Toast.makeText(this, "Lifecycle method \n 'onStop()' is called", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        Toast.makeText(this, "Lifecycle method \n 'onDestroy()' is called", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onSaveInstanceState (Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt(SCORE_KEY, mUserScore); // {Key, Value} pair
        outState.putInt(INDEX_KEY, mQuestionIndex);
    }
}
