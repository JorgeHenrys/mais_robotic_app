package com.wolfy.mais_robotic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ConhecendoRoboticaQuiz extends AppCompatActivity {

    private Button backQuestion;
    private Button nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conhecendo_robotica_quiz);

        backQuestion = findViewById(R.id.questao_anterior);
        backQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionPreview();
            }
        });

        nextQuestion = findViewById(R.id.proxima_questao);
        nextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuestionNext();
            }
        });
    }

    private  void openQuestionPreview() {
        Intent intent = new Intent(this, ConhecendoARobotica.class);
        startActivity(intent);
    }

    private  void openQuestionNext() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void methodtoexecute(View view){

    }
}
