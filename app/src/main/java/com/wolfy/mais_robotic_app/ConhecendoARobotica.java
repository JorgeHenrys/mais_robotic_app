package com.wolfy.mais_robotic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ConhecendoARobotica extends AppCompatActivity {

    private Button nextButton, backButton;
    private TextView subjectBody, subjectTitle;
    private ProgressBar progressBarLevel;
    private LinearLayout optionsContainer;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conhecendo_arobotica);


        nextButton = findViewById(R.id.next_button);
        backButton = findViewById(R.id.back_button);
        progressBarLevel = findViewById(R.id.progress);
        optionsContainer = findViewById(R.id.options_container);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButton();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openConhecendoRoboticaQuiz();
            }
        });



    }




    public  void openConhecendoRoboticaQuiz() {
        Intent intent =  new Intent(this, ConhecendoRoboticaQuiz.class);
        startActivity(intent);
        finish();
    }

    public  void backButton() {
        Intent intent =  new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}
