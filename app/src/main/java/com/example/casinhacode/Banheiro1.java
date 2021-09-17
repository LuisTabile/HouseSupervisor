package com.example.casinhacode;
//Bluetooth disconnect when open next activity

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Banheiro1 extends Activity implements View.OnClickListener {
    final static String lampbp = "g"; //Lampada
    final static String espelhobp = "h"; //Espelho
    final static String torneirabp = "i"; //Torneira
    final static String chapinhabp = "j"; //Chapinha
    final static String secadorbp = "k"; //Secador
    final static String chuveirobp = "l"; //Chuveiro
    final static String aquecedorbp = "m"; //Aquecedor
    static boolean cl1bp = false;
    static boolean cl2bp = false;
    static boolean cl3bp = false;
    static boolean cl4bp = false;
    static boolean cl5bp = false;
    static boolean cl6bp = false;
    static boolean cl7bp = false;


    public Banheiro1() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banheiro1);
        ImageView btn_bp1 = findViewById(R.id.img_lampb1);
        ImageView btn_bp2 = findViewById(R.id.img_espb1);
        ImageView btn_bp3 = findViewById(R.id.img_aquceb1);
        ImageView btn_bp4 = findViewById(R.id.img_tornb1);
        ImageView btn_bp5 = findViewById(R.id.img_chapb1);
        ImageView btn_bp6 = findViewById(R.id.img_chuvb1);
        ImageView btn_bp7 = findViewById(R.id.img_secb1);
        btn_bp1.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_bp2.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_bp3.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_bp4.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_bp5.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_bp6.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_bp7.setOnClickListener((view)-> Controlling.singletom.onClick(view));

    }

    @Override
    public void onClick(View view) {

    }
}