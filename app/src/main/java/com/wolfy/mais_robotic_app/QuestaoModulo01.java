package com.wolfy.mais_robotic_app;

import android.graphics.drawable.Drawable;
import android.media.Image;

import com.bumptech.glide.load.engine.Resource;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class QuestaoModulo01 {

    private String pergunta;
    private int images;
    private List<String> respostas = new ArrayList<>();
    private String respostaCerta;

    public QuestaoModulo01(String pergunta, int images, String respostaCerta, String... respostas){
        this.pergunta = pergunta;
        this.images = images;
        this.respostas.add(respostas[0]);
        this.respostas.add(respostas[1]);
        this.respostas.add(respostas[2]);
        this.respostaCerta = respostaCerta;
    }


    public String getPergunta(){ return this.pergunta; }
    public  int getImages(){return  this.images; }
    public List<String> getRespostas(){ return this.respostas; }
    public String getRespostaCerta(){ return this.respostaCerta; }

}
