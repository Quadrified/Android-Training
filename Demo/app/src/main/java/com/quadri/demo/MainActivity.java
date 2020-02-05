package com.quadri.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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

        ShowDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Log.i("NAME", Name.getText().toString());
                Log.i("PHONE", Phone.getText().toString());

                /* Hiding keyboard after button press */
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(ShowDetails.getWindowToken(), 0);

                /* TOAST */
                Toast.makeText(MainActivity.this, "Your name: " + Name.getText().toString() + "\n Your phone number: " + Phone.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
