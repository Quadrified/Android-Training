package com.quadri.sharedpreferencesdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText userName;
    EditText password;
    TextView dataView;
    Button saveButton, displayButton;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName      = findViewById(R.id.userNameInput);
        password      = findViewById(R.id.passwordInput);
        dataView      = findViewById(R.id.dataTextView);
        saveButton    = findViewById(R.id.saveButton);
        displayButton = findViewById(R.id.displayButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = sharedPref.edit();

                editor.putString("username", userName.getText().toString());
                editor.putString("password", password.getText().toString());

                editor.apply();

                Toast.makeText(MainActivity.this, "Saved!!", Toast.LENGTH_SHORT).show();
            }
        });

        displayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                SharedPreferences sharedPref = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                String name = sharedPref.getString("username", "");
                String password = sharedPref.getString("password", "");

                dataView.setText("Username: " + name + "\n" + "Password: " + password);
            }
        });
    }
}
