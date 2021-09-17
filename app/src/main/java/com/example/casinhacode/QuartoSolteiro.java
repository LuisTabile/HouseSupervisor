package com.example.casinhacode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuartoSolteiro extends AppCompatActivity implements View.OnClickListener {
    final static String luzcqs = "5"; // Luz Cama
    final static String aquecq = "6"; //Aquecedor
    final static String escriv = "7"; //Escrivaninha
    final static String arcondq = "8"; //Ar Condicionado
    final static String tvqs = "9"; //TV
    final static String luzqs = "a"; //Luz

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_solteiro);
        Button btn_quars1 = (Button) findViewById(R.id.btn_quars1);
        Button btn_quars2 = (Button) findViewById(R.id.btn_quars2);
        Button btn_quars3 = (Button) findViewById(R.id.btn_quars3);
        Button btn_quars4 = (Button) findViewById(R.id.btn_quars4);
        Button btn_quars5 = (Button) findViewById(R.id.btn_quars5);
        Button btn_quars6 = (Button) findViewById(R.id.btn_quars6);
        btn_quars1.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_quars2.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_quars3.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_quars4.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_quars5.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_quars6.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
    }
        @Override
        public void onClick (View view){
        }

    }