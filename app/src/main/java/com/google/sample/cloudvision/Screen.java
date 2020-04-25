package com.google.sample.cloudvision;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.TextView;

import android.support.v7.app.AppCompatActivity;

public class Screen extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.screen);

        Intent intent = getIntent();
       // score = intent.getIntExtra("score is", 0);
       // TextView scoreView = findViewById(R.id.score_on_screen);
       // scoreView.setText(Integer.toString(score));
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(view -> onClickBack());
        Button rememberMeButton = findViewById(R.id.rememberme);
        rememberMeButton.setOnClickListener(view -> onClickRemmberMe());
        Button playButton =findViewById(R.id.play);
        playButton.setOnClickListener(view -> onClickPlay());

    }

    public void onClickBack() {

        Intent intent = new Intent(this, Room.class);


        startActivity(intent);


    }

    public void onClickRemmberMe() {

        Intent intent = new Intent(this, RemembermeScreen.class);


        startActivity(intent);


    }
    public void onClickPlay() {

        Intent intent = new Intent(this, Play.class);


        startActivity(intent);


    }
}
