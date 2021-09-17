package com.example.casinhacode;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Banheiro2 extends AppCompatActivity implements View.OnClickListener {

    final static String lampb2 = "F";
    final static String chuveiro = "G";
    final static String espelho = "H";
    final static String arcondb = "I"; // 30 min 20.25
    final static String banheira = "J"; // = chuveiro

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banheiro2);
        ImageView btn_banbv1 = findViewById(R.id.img_lampb2);
        ImageView btn_banbv2 = findViewById(R.id.img_banb2);
        ImageView btn_banbv3 = findViewById(R.id.img_arb2);
        ImageView btn_banbv4 = findViewById(R.id.img_espb2);
        ImageView btn_banbv5 = findViewById(R.id.img_chuvb2);
        btn_banbv1.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_banbv2.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_banbv3.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_banbv4.setOnClickListener((view)-> Controlling.singletom.onClick(view));
        btn_banbv5.setOnClickListener((view)-> Controlling.singletom.onClick(view));

    }

    @Override
    public void onClick(View view) {

    }
}