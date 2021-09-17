package com.example.casinhacode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SalaDeEstar extends AppCompatActivity implements View.OnClickListener {
    final static String homethe = "n"; //Home Theater
    final static String lumise = "o"; //Luminária
    final static String tvse = "p"; //TV
    final static String lampse = "q"; //Lâmpada
    final static String arse = "r"; //Ar Condicionado


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sala_de_estar);
        Button btn_se1 = (Button) findViewById(R.id.btn_se1);
        Button btn_se2 = (Button) findViewById(R.id.btn_se2);
        Button btn_se3 = (Button) findViewById(R.id.btn_se3);
        Button btn_se4 = (Button) findViewById(R.id.btn_se4);
        Button btn_se5 = (Button) findViewById(R.id.btn_se5);
        btn_se1.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_se2.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_se3.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_se4.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_se5.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
    }

    @Override
    public void onClick(View view) {

    }
}