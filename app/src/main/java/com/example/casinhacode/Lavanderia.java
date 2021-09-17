package com.example.casinhacode;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;
import java.util.UUID;

public class Lavanderia extends AppCompatActivity implements View.OnClickListener {
    private BluetoothSocket mBTSocket;
    final static String ferrol = "0";//Ferro de Passar Roupa
    final static String luzl = "1";//Luz
    final static String centrifugal = "2"; // Centrifuga
    final static String maqlavarl = "3"; //Maquina de Lavar
    final static String aspl = "4"; //Aspirador de pó

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lavanderia);
        Button btn_lav0 = (Button) findViewById(R.id.btn_lav0);
        Button btn_lav1 = (Button) findViewById(R.id.btn_lav1);
        Button btn_lav2 = (Button) findViewById(R.id.btn_lav2);
        Button btn_lav3 = (Button) findViewById(R.id.btn_lav3);
        Button btn_lav4 = (Button) findViewById(R.id.btn_lav4);
        btn_lav0.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_lav1.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_lav2.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_lav3.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });
        btn_lav4.setOnClickListener((view) -> {
            Controlling.singletom.onClick(view);
        });


    }

    @Override
    public void onClick(View view) {

    }
}
