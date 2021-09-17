package com.example.casinhacode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Escritorio extends AppCompatActivity implements View.OnClickListener {
    final static String roteador = "s"; //Roteador
    final static String abajes = "t"; //Abajur
    final static String impre = "u"; //Impressora
    final static String note = "v"; //Notebook
    final static String lampes = "w"; //Lâmpada
    final static String ares = "x"; //Ar Condicionado


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escritorio);
        Button btn_es1 = (Button) findViewById(R.id.btn_es1);
        Button btn_es2 = (Button) findViewById(R.id.btn_es2);
        Button btn_es3 = (Button) findViewById(R.id.btn_es3);
        Button btn_es4 = (Button) findViewById(R.id.btn_es4);
        Button btn_es5 = (Button) findViewById(R.id.btn_es5);
        Button btn_es6 = (Button) findViewById(R.id.btn_es6);
        btn_es1.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_es2.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_es3.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_es4.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_es5.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_es6.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });

    }

    @Override
    public void onClick(View view) {

    }
}