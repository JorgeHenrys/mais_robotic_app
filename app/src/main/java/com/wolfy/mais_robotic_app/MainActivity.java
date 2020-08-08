package com.wolfy.mais_robotic_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.conhecendo_a_robotica);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v){
                openConhecendoRobotica();
            }
        });
    }

    public  void openConhecendoRobotica() {
        Intent intent =  new Intent(this, ConhecendoARobotica.class);
        startActivity(intent);
    }
}
