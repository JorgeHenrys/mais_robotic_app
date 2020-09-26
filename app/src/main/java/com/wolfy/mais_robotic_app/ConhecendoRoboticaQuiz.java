package com.wolfy.mais_robotic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.load.engine.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ConhecendoRoboticaQuiz extends AppCompatActivity {


    private ProgressBar progressBar;
    private int progresso = 0;

    private TextView textPergunta;
    private ImageView imgPergunta;
    private Button alternativeA;
    private Button alternativeB;
    private Button alternativeC;
    private Button responseSelected;

    private String respostaCerta = "alter_b";

    private String resposta = "";

    private int pontos;


    List<QuestaoModulo01> questoes = new ArrayList<QuestaoModulo01>(){
        {
            add(new QuestaoModulo01("Como é chamado este componente?", R.drawable.img_quest_01, "alter_b", "Cabo HDMI", "Jumper", "Fonte 220 volts"));
            add(new QuestaoModulo01("Como é chamado este componente?", R.drawable.img_quest_02, "alter_a", "Arduíno", "Placa Mãe", "Ardouno"));
            add(new QuestaoModulo01("Que Componente é esse?", R.drawable.img_quest_03, "alter_c", "Pino", "Lanterna", "Led"));
            add(new QuestaoModulo01("Qual esse componente?", R.drawable.img_quest_04, "alter_a", "Sensor de Luminosidade", "Jumper", "Led"));
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conhecendo_robotica_quiz);

        textPergunta = findViewById(R.id.textPergunta);
        imgPergunta = findViewById(R.id.imgPergunta);
        alternativeA = findViewById(R.id.alternative_a);
        alternativeB = findViewById(R.id.alternative_b);
        alternativeC = findViewById(R.id.alternative_c);
        carregarQuestao();

        alternativeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                alternativeA.setEnabled(false);
                alternativeB.setEnabled(true);
                alternativeC.setEnabled(true);

                resposta = "alter_a";
            }
        });

        alternativeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                alternativeA.setEnabled(true);
                alternativeB.setEnabled(false);
                alternativeC.setEnabled(true);

                resposta = "alter_b";
            }
        });

        alternativeC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                alternativeA.setEnabled(true);
                alternativeB.setEnabled(true);
                alternativeC.setEnabled(false);

                resposta = "alter_c";
            }
        });





    }

    public void btnResponderOnClick(View v){

        progressBar = findViewById(R.id.progress);



        if(resposta !=  ""){





            Intent intent = new Intent(this, Resposta.class);

            progresso = progresso + 25;

            progressBar.setProgress(progresso);

            alternativeA.setEnabled(true);
            alternativeB.setEnabled(true);
            alternativeC.setEnabled(true);

            if(resposta == respostaCerta) {
                intent.putExtra("acertou", true);

                resposta = "";
                pontos ++;
                intent.putExtra("pontos", pontos);
            }
            else{
                intent.putExtra("acertou", false);
                resposta = "";
                pontos = pontos;
                intent.putExtra("pontos", pontos);
            }



            intent.putExtra("progressQuiz", progresso);

            startActivity(intent);
        }
        else {
            Toast.makeText(ConhecendoRoboticaQuiz.this, "Selecione uma resposta", Toast.LENGTH_SHORT).show();
        }


    }

    private void carregarQuestao(){

        if(questoes.size() > 0) {
            QuestaoModulo01 q = questoes.remove(0);
            textPergunta.setText(q.getPergunta());
            imgPergunta.setImageResource(q.getImages());
            List<String> resposta = q.getRespostas();
            alternativeA.setText(resposta.get(0));
            alternativeB.setText(resposta.get(1));
            alternativeC.setText(resposta.get(2));
            respostaCerta = q.getRespostaCerta();
        }

        else {
            Intent intentGet = getIntent();
            Intent intent = new Intent(this, Resposta.class);

            intent.putExtra("progressknow", intentGet.getIntExtra("progress_know", 0));
            intent.putExtra("pontos", pontos);
            startActivity(intent);
            finish();
        }

    }


    @Override
    protected void onRestart(){
        super.onRestart();

        carregarQuestao();
    }




}
