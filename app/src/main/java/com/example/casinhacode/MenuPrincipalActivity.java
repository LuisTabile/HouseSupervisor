package com.example.casinhacode;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MenuPrincipalActivity extends AppCompatActivity implements OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        getSupportActionBar().hide();

        // BUTTONS //
        Button btn_casinha = findViewById(R.id.btn_casinha);
        Button btn_contaluz = findViewById(R.id.btn_contaluz);
        Button btn_sair = findViewById(R.id.btn_sair);
        btn_casinha.setOnClickListener(this);
        btn_contaluz.setOnClickListener(this);
        btn_sair.setOnClickListener(this);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_casinha:
                Intent intent1 = new Intent(this, Comodo.class);
                startActivity(intent1);
                break;
            case R.id.btn_contaluz:
                Intent intent2 = new Intent(this, ContaDeLuz.class);
                startActivity(intent2);
                break;
            case R.id.btn_sair:
                Intent intentexit = new Intent(getApplicationContext(), MainActivity.class);
                intentexit.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intentexit.putExtra("EXIT", true);
                startActivity(intentexit);
                break;
        }

    }
}
