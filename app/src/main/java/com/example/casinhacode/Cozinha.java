package com.example.casinhacode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Cozinha extends AppCompatActivity implements View.OnClickListener {
    final static String forno = "y"; //Forno
    final static String armario = "z"; //Armário
    final static String chaleira = "A"; //Chaleira
    final static String torradeira = "B"; //Torradeira
    final static String geladeira = "C"; //Geladeira
    final static String microondas = "D"; //Microondas
    final static String lampc = "E"; //Lampâda


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cozinha);

      ImageView btn_coz1 = findViewById(R.id.img_armcoz1);
      ImageView btn_coz2 = findViewById(R.id.img_chalcoz1);
      ImageView btn_coz3 = findViewById(R.id.img_fornocoz1);
      ImageView btn_coz4 = findViewById(R.id.img_gelcoz1);
      ImageView btn_coz5 = findViewById(R.id.img_lampcoz1);
      ImageView btn_coz6 = findViewById(R.id.img_microcoz1);
      ImageView btn_coz7 = findViewById(R.id.img_torrcoz1);

        btn_coz1.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_coz2.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_coz3.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_coz4.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_coz5.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_coz6.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_coz7.setOnClickListener((view)-> Controlling.singletom.onClick(view));
    }

    @Override
    public void onClick(View view) {

    }
}