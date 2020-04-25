package com.google.sample.cloudvision;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class Category extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.category_layout);
        ProgressBar progressBar = findViewById(R.id.progressBar);
        TextView categoryNameTV = findViewById(R.id.categoryNameTV);
        Intent intent = getIntent();
        String categoryName = intent.getStringExtra("category name");
        categoryNameTV.setText(categoryName);
        populateWordsContainer(categoryName);
    }

    private void populateWordsContainer(String i_CategoryName)
    {
        Singleton singleton = Singleton.Instance();
        TableLayout table = (TableLayout) findViewById((R.id.WordsContainer));
        CategoryLogic category = singleton.m_Categories.get(i_CategoryName);
        int numOfWords = 2;//to get from singleton;

        for(Map.Entry<String, WordLogic> entry : category.m_WordTable.entrySet())
        {
            createAddWordContainer(table, entry.getValue());
        }
    }

    public void onClickWord(Button b)
    {
        Toast.makeText(this,b.getText(),Toast.LENGTH_SHORT).show();

    }
    public void createAddWordContainer(TableLayout table, WordLogic word)
    {
        TableLayout wordContainer = new TableLayout(this);
        Button wordName = new Button(this);
        wordName.setText(word.get_Word());
        wordName.setTop(20);
        wordName.setWidth(274);
        wordName.setHeight(50);
        wordName.setTextSize(20);
        wordName.setLeft(50);
        ImageView imageView  = new ImageView(this);
        imageView.setTop(20);
        imageView.setLeft(370);
        imageView.setMaxWidth(20);
        imageView.setMaxHeight(20);
        //TODO imageView.setImageBitmap(...);
        Button buttonPlay = new Button(this);
        buttonPlay.setText("Play");
        buttonPlay.setTop(150);
        buttonPlay.setLeft(300);
        buttonPlay.setWidth(50);
        buttonPlay.setHeight(15);
        buttonPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickplay(buttonPlay);
            }
        });

        Button buttonTellMe = new Button(this);
        buttonTellMe.setText("Tell Me");
        buttonTellMe.setTop(150);
        buttonTellMe.setLeft(50);
        buttonTellMe.setWidth(50);
        buttonTellMe.setHeight(15);
        buttonTellMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                onClickTellMe(buttonTellMe, word);
            }
        });
        wordContainer.addView(wordName);
        wordContainer.addView(imageView);
        wordContainer.addView(buttonPlay);
        wordContainer.addView(buttonTellMe);
        wordContainer.setBackgroundColor(Color.BLUE);
        wordContainer.setPadding(0,40,0,40);
        table.addView(wordContainer);
    }
    private void onClickplay(Button i_PlayButton)
    {
        Intent intent = new Intent(this, Play.class);

        startActivity(intent);
    }
    private void onClickTellMe(Button i_TellMeButton, WordLogic i_Word)
    {
        Intent intent = new Intent(this, TellMe.class);
        i_Word.set_FirstTime(false);
        startActivity(intent);
    }

}
