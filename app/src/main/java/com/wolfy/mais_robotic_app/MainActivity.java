package com.wolfy.mais_robotic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;

    private ProgressBar progressQuiz;
    private ProgressBar progressKnow;
    private ProgressBar progressHands;

    int progressquiz = 0;

    int progressknow = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        progressKnow = findViewById(R.id.progressBarKnow);
        progressQuiz = findViewById(R.id.progressBarQuiz);
        progressHands = findViewById(R.id.progressBarTests);

        progressKnow.setProgress(intent.getIntExtra("progressKnow", 0));
        progressQuiz.setProgress(intent.getIntExtra("progressQuiz", 0));

        progressquiz = intent.getIntExtra("progressQuiz", 0);
        progressknow = intent.getIntExtra("progressKnow", 0);

        button1 = findViewById(R.id.conhecendo_a_robotica);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                openConhecendoRobotica();
            }
        });

        button2 = findViewById(R.id.quiz_more_robotic);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                openQuizMaisRobotic();
            }
        });

        button3 = findViewById(R.id.hands_in_work);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                openMãosaObra();
            }
        });
    }

    public  void openConhecendoRobotica() {
        Intent intent =  new Intent(this, ConhecendoARobotica.class);


        intent.putExtra("progress_quiz", progressquiz);
        startActivity(intent);
    }

    public void openQuizMaisRobotic() {
        Intent intent =  new Intent(this, ConhecendoRoboticaQuiz.class);


        intent.putExtra("progress_know", progressknow);


        startActivity(intent);
    }

    public  void openMãosaObra() {

    }
}
