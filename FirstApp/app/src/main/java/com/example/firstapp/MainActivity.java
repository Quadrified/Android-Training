package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Email, Password;
    TextView Attempts;
    Button Login;
    int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        Email    = (EditText) findViewById (R.id.email);
        Password = (EditText) findViewById (R.id.password);
        Attempts = (TextView) findViewById (R.id.info);
        Login    = (Button) findViewById (R.id.login);

        Attempts.setText ("No. of attempts left: " + counter);

        Login.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                validate (Email.getText ().toString (), Password.getText ().toString ());
            }
        });
    }

    private void validate(String uName, String uPass) {
        if ((uName == "Quadri") && (uPass == "quadri")) {

            Intent intent = new Intent (MainActivity.this, SecondActivity.class);

            startActivity (intent);
        } else {

            counter--;

            Attempts.setText ("No. of attempts left: " + counter);

            if (counter == 0) {
//                Login.setEnabled (false);
            }
        }
    }
}
