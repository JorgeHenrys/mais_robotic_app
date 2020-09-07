package com.wolfy.mais_robotic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resposta extends AppCompatActivity {

    private ImageView imgResposta;
    private TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resposta);


        imgResposta = findViewById(R.id.imgResposta);
        resposta = findViewById(R.id.resposta);
        Button btnJogarNovamente = findViewById(R.id.final_do_quiz);

        Intent intent = getIntent();

        int pontos = intent.getIntExtra("pontos", 0);

        if(intent.hasExtra("acertou")) {
            btnJogarNovamente.setVisibility(View.INVISIBLE);
            boolean acertou = intent.getBooleanExtra("acertou", false);
            if(acertou){
                imgResposta.setImageResource(R.drawable.correta);
                resposta.setText("Acertou!  Pontos: " + pontos);
            }
            else{
                imgResposta.setImageResource(R.drawable.errado);
                resposta.setText("Errou!   Pontos: " + pontos);
            }



            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finish();
                }
                });
                thread.start();

            }

        else {
            imgResposta.setVisibility(View.INVISIBLE);
            btnJogarNovamente.setVisibility(View.VISIBLE);
            resposta.setText("Você fez " + pontos + " pontos!");

        }

        }

    public void btnBackToHomeOnClick(View v){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }


}
