package com.wolfy.mais_robotic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ConhecendoARobotica extends AppCompatActivity {

    private Button nextButton, backButton;
    private TextView subjectBody, subjectTitle;
    private ProgressBar progressBarLevel;
    private LinearLayout optionsContainer;
    private int progresso = 0;

    private ImageView imgContent;

    private int x = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conhecendo_arobotica);


        nextButton = findViewById(R.id.next_button);
        backButton = findViewById(R.id.back_button);
        progressBarLevel = findViewById(R.id.progress);
        optionsContainer = findViewById(R.id.options_container);

        imgContent = findViewById(R.id.imgConteudo);

        progressBarLevel = findViewById(R.id.progress);


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                backButton();
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextButton();
            }
        });



    }




    public  void nextButton() {

        int bg = 0;

        Intent intentGet = getIntent();

        Intent intent =  new Intent(this, MainActivity.class);

        // are we larger than 5? lets start again at 1 :)

        progresso = progresso + 16;
        progressBarLevel.setProgress(progresso);

        intent.putExtra("progressKnow", progresso);




        if (x == 6) {

            x = 1;

            progresso = 100;
            int progressoQuiz = intentGet.getIntExtra("progress_quiz", 0);

            intent.putExtra("progressKnow", progresso);



            intent.putExtra("progressQuiz", progressoQuiz);

            startActivity(intent);

            finish();

        }

        x++;


        if (x == 1) bg = R.drawable.game_01;
        if (x == 2) bg = R.drawable.game_02;
        if (x == 3) bg = R.drawable.game_03;
        if (x == 4) bg = R.drawable.game_04;
        if (x == 5) bg = R.drawable.game_05;
        if (x == 6) bg = R.drawable.game_06;



        imgContent.setImageResource(bg);



    }

    public  void backButton() {


        int bg = 0;

        Intent intentGet = getIntent();

        Intent intent =  new Intent(this, MainActivity.class);

        // are we larger than 5? lets start again at 1 :)

        progresso = progresso - 16;
        progressBarLevel.setProgress(progresso);


        intent.putExtra("progressKnow", progresso);




        if (x == 1) {

            progresso = 0;


            intent.putExtra("progressKnow", progresso);
            intent.putExtra("progressQuiz", intentGet.getIntExtra("progress_quiz", 0));

            startActivity(intent);
            finish();

        }

        x--;


        if (x == 1) bg = R.drawable.game_01;
        if (x == 2) bg = R.drawable.game_02;
        if (x == 3) bg = R.drawable.game_03;
        if (x == 4) bg = R.drawable.game_04;
        if (x == 5) bg = R.drawable.game_05;
        if (x == 6) bg = R.drawable.game_06;



        imgContent.setImageResource(bg);



    }



}
