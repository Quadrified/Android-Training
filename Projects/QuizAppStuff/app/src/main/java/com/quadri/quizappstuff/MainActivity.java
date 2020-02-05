package com.quadri.quizappstuff;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnTrue = findViewById(R.id.btnTrue);
        Button btnFalse = findViewById(R.id.btnFalse);

        /* Explicitly creating OnClickEvent */

//        View.OnClickListener myClick = new View.OnClickListener() {
//            @Override
//            public void onClick (View v) {
//
//                if(v.getId() == R.id.btnTrue) {
//                    Log.i("Listener", "True clicked");
//
//                } else {
//                    Log.i("Listener", "False clicked");
//                }
//            }
//        };

        /* An ANONYMOUS OnClickListener i.e., Creating OnClickListener on the spot */

        btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Log.i("Listener", "True clicked");
            }
        });
        btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Log.i("Listener", "False clicked");
            }
        });
    }
}
