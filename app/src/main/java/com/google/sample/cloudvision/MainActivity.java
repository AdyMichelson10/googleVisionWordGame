/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.sample.cloudvision;

import android.os.Bundle;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;
import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{
    int score =2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categories);
        populateContainer();
         TextView scoreView = findViewById(R.id.score_on_screen);
         
             scoreView.setText(Integer.toString(score));


        Button fab = findViewById(R.id.room);
        fab.setOnClickListener(view -> onClickRoom());
      /*  fab.setOnClickListener(view -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder

                    .setPositiveButton(R.string.action_settings, (dialog, which) -> onClickRoom());

            builder.create().show();
        });*/


    }

    public void  onClickRoom(){

        Intent intent = new Intent(this, Room.class);
        intent.putExtra("score is 1",score);
        startActivity(intent);
    }

    public void populateContainer()
    {
        Singleton singleton = Singleton.Instance();
        TableLayout table = (TableLayout) findViewById((R.id.CategoriesContainer));
        int numOfCategories = 1;//to get from singleton;

        for(Map.Entry<String, CategoryLogic> entry : singleton.m_Categories.entrySet())
        {
            Button button = new Button(this);
            //add attributes to button
            button.setText(entry.getKey());
            button.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v)
                {
                    onClickCategory(button);
                }
            });
            table.addView(button);
        }
    }
    public void onClickCategory(Button b)
    {
        //CategoryLogic category = Singleton.Instance().m_Categories.get(b.getText());
        Toast.makeText(this,b.getText(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, Category.class);
        intent.putExtra("category name", b.getText());
        startActivity(intent);
    }
}