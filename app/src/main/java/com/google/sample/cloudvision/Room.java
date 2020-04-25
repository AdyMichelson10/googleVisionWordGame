package com.google.sample.cloudvision;
import android.os.Bundle;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class Room extends AppCompatActivity
{
    int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.room_cat);

        Intent intent = getIntent();
        score =  intent.getIntExtra("score is",0);
        TextView scoreView = findViewById(R.id.score_on_screen);

        scoreView.setText(Integer.toString(score));
        Button screenButton = findViewById(R.id.screen);
        screenButton.setOnClickListener(view -> onClickScreen());
        Button backButton = findViewById(R.id.back);
        backButton.setOnClickListener(view -> onClickBack());

    }

    public void  onClickScreen() {

        Intent intent = new Intent(this, Screen.class);

        intent.putExtra("score is",score);
        startActivity(intent);



    }

    public void onClickBack() {

        Intent intent = new Intent(this, MainActivity.class);


        startActivity(intent);


    }
}
