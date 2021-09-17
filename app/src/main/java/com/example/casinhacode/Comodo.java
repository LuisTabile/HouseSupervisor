package com.example.casinhacode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
//nome codigo lista de aparelhos
//classe aparelhos com o numero/custo
//    comodosMap.put(lavanderia.this)

//   public static HashMap<String, Comodo> comodosMap;
//adicionar itens
// public static Comodo lavanderia = new Comodo();
public class Comodo extends AppCompatActivity implements View.OnClickListener {
     Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comodo);
        getSupportActionBar().hide();
        ImageView img_cozinha = findViewById(R.id.img_cozinha);
        ImageView img_banheiro1 = findViewById(R.id.img_banheiro1);
        ImageView img_banheiro2 = findViewById(R.id.img_banheiro2);
        ImageView img_escritorio = findViewById(R.id.img_escritorio);
        ImageView img_lavanderia = findViewById(R.id.img_lavanderia);
        ImageView img_quartoCasal = findViewById(R.id.img_quartoCasal);
        ImageView img_quartoSolteiro = findViewById(R.id.img_quartoSolteiro);
        ImageView img_salaEstar = findViewById(R.id.img_salaEstar);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(this);
        img_cozinha.setOnClickListener(this);
        img_banheiro1.setOnClickListener(this);
        img_banheiro2.setOnClickListener(this);
        img_escritorio.setOnClickListener(this);
        img_lavanderia.setOnClickListener(this);
        img_quartoCasal.setOnClickListener(this);
        img_quartoSolteiro.setOnClickListener(this);
        img_salaEstar.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button:
                Intent intent = new Intent(this, ContaDeLuz.class);
                startActivity(intent);
                break;
            case R.id.img_cozinha:
                Intent intent1 = new Intent(this,Cozinha.class);
                startActivity(intent1);
                break;
            case R.id.img_banheiro1:
                Intent intent2 = new Intent(this,Banheiro1.class);
                startActivity(intent2);
                break;
            case R.id.img_banheiro2:
                Intent intent3 = new Intent(this,Banheiro2.class);
                startActivity(intent3);
                break;
            case R.id.img_salaEstar:
                Intent intent4 = new Intent(this,SalaDeEstar.class);
                startActivity(intent4);
                break;
            case R.id.img_lavanderia:
                Intent intent5 = new Intent(this,Lavanderia.class);
                startActivity(intent5);
                break;
            case R.id.img_escritorio:
                Intent intent6 = new Intent(this,Escritorio.class);
                startActivity(intent6);
                break;
            case R.id.img_quartoCasal:
                Intent intent7 = new Intent(this,QuartoDeCasal.class);
                startActivity(intent7);
                break;
            case R.id.img_quartoSolteiro:
                Intent intent8 = new Intent(this,QuartoSolteiro.class);
                startActivity(intent8);
                break;

        }

    }
}


