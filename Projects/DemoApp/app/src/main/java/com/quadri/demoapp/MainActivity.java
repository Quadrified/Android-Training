package com.quadri.demoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* keyboard is hidden when an activity first launches (ie: if an EditText is the first thing focused) */
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        final EditText Name = findViewById(R.id.name);
        final EditText Phone = findViewById(R.id.phoneNumber);
        final Button ShowDetails = findViewById(R.id.click);
//        final ImageView myImage = findViewById(R.id.androidImage);
        final EditText Age = findViewById(R.id.ageField);

        final int yearAge = Calendar.getInstance().get(Calendar.YEAR) - Integer.parseInt(Age.getText().toString());

        ShowDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                /* Hiding keyboard after button press */
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ShowDetails.getWindowToken(), 0);
//                myImage.setImageResource(R.drawable.q_image);

                /* /* TOAST */
                //Toast.makeText(MainActivity.this, "Your name: " + Name.getText().toString() + "\n Your phone number: " + Phone.getText().toString(), Toast.LENGTH_LONG + "\n Your age is: " + yearAge, Toast.LENGTH_LONG).show();
                Toast.makeText(MainActivity.this, "Age: " + yearAge.parseInt().toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}


