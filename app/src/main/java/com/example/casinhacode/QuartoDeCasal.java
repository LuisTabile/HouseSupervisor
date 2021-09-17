package com.example.casinhacode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class QuartoDeCasal extends AppCompatActivity implements View.OnClickListener {

    final static String abajurqc = "b"; //Abajur
    final static String cabeceiraqc = "c"; //Cabeceira
    final static String lampadaqc = "d"; //Lampada
    final static String tvqc = "e"; //TV
    final static String arqc = "f"; //AR

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quarto_de_casal);

        Button btn_qc1 = (Button) findViewById(R.id.btn_qc1);
        Button btn_qc2 = (Button) findViewById(R.id.btn_qc2);
        Button btn_qc3 = (Button) findViewById(R.id.btn_qc3);
        Button btn_qc4 = (Button) findViewById(R.id.btn_qc4);
        Button btn_qc5 = (Button) findViewById(R.id.btn_qc5);
        btn_qc1.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_qc2.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_qc3.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_qc4.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_qc5.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
    }
    @Override
    public void onClick(View view) {

    }
}