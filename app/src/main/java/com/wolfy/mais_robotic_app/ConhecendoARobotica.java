package com.wolfy.mais_robotic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

public class ConhecendoARobotica extends AppCompatActivity {

    private Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conhecendo_arobotica);


        nextQuestion = findViewById(R.id.conhecendo_a_robotica_quiz);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override

            public  void onClick(View v){
                openConhecendoRoboticaQuiz();
            }
        });
    }

    public  void openConhecendoRoboticaQuiz() {
        Intent intent =  new Intent(this, ConhecendoRoboticaQuiz.class);
        startActivity(intent);
    }



}
