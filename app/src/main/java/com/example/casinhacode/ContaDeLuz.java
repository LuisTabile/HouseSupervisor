package com.example.casinhacode;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//BANHEIRO I ----------------------------------------------------> < --------------------------
/*Lampada  = 60W / 7,2 KW/Mês / R$5,02 / cl1bp
 *Iluminação Espelho 60W / 5,4 KW/Mês / R$ 3,76/ cl2bp
 *Torneira Elétrica 5500W / 16,5KW/Mês / R$ 11,50/ cl3bp
 *Chapinha 60W / 0.90KW/Mês / R$ 0,62/ cl4bp
 *Secador 1500W/ 11,25KW/Mês / R$ 7,84 / cl5bp
 *Chuveiro 5500W / 165 KW/Mês / R$115,02 / cl6bp
 *Aquecedor 2000W/ 60KW/Mês / R$41,82 /cl7bp *

 */
public class ContaDeLuz extends AppCompatActivity {
    static double somakw;
    double custo;
    double contaBanheiro1 = Controlling.kwmesb1;
    double contaBanheiro2 = Controlling.kwmesb2;
    double contaCozinha = Controlling.kwmesc;
    double contaEscritorio = Controlling.kwmesesc;
    double contaLavanderia = Controlling.kwmeslav;
    double contaQuartoSolteiro = Controlling.kwmesqs;
    double contaQuartoCasal = Controlling.kwmesqc;
    double contasalaDeEstar = Controlling.kwmesse;
    boolean cl1bp = Banheiro1.cl1bp;
    boolean cl2bp = Banheiro1.cl2bp;
    boolean cl3bp = Banheiro1.cl3bp;
    boolean cl4bp = Banheiro1.cl4bp;
    boolean cl5bp = Banheiro1.cl5bp;
    boolean cl6bp = Banheiro1.cl6bp;
    boolean cl7bp = Banheiro1.cl7bp;
     TextView textViewKw;
     TextView textViewCusto;

    public ContaDeLuz() {
        //VERIFICADOR BANHEIRO 1
        String string1 = String.format("Lampada: %b", cl1bp);
        System.out.println(string1);

        String string2 = String.format("Luzes Espelho: %b", cl2bp);
        System.out.println(string2);

        String string3 = String.format("Torneira Elétrica: %b", cl3bp);
        System.out.println(string3);

        String string4 = String.format("Chapinha: %b", cl4bp);
        System.out.println(string4);

        String string5 = String.format("Secador: %b", cl5bp);
        System.out.println(string5);

        String string6 = String.format("Chuveiro: %b", cl6bp);
        System.out.println(string6);

        String string7 = String.format("Aquecedor: %b", cl7bp);
        System.out.println(string7);

    }


    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        somakw = contaBanheiro1 + contaBanheiro2 + contaCozinha + contaEscritorio +
                contaLavanderia + contaQuartoCasal + contaQuartoSolteiro + contasalaDeEstar;
        custo = somakw * 0.6971;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conta_de_luz);
        textViewKw = findViewById(R.id.textViewKw);
        textViewCusto = findViewById(R.id.textViewCusto);
        textViewCusto.setText(String.format("Custo: R$%,.2f", custo));
        textViewKw.setText(String.format("%,.2f KWh/Mês", somakw));

    }

}
