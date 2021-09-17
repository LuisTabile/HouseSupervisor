package com.example.casinhacode;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

public class Controlling extends Activity implements View.OnClickListener {

    //BLUETOOTH SETTINGS
    private static final String TAG = "BlueTest5-Controlling";
    private UUID mDeviceUUID;
    private BluetoothSocket mBTSocket;
    private ReadInput mReadThread = null;
    private boolean mIsBluetoothConnected = false;
    private BluetoothDevice mDevice;
    private ProgressDialog progressDialog;
    private boolean bloqueio;
    //BLUETOOTH SETTINGS
    //BUTTONS
    Button btn_inicio;
    //BUTTONS
    @SuppressLint("StaticFieldLeak")
    public static Controlling singletom;
    //LAVANDERIA
    final static String ferrol = Lavanderia.ferrol;
    final static String luzl = Lavanderia.luzl;
    final static String centrifugal = Lavanderia.centrifugal;
    final static String maqlavarl = Lavanderia.maqlavarl;
    final static String aspl = Lavanderia.aspl;
    static boolean lav1 = false;
    static boolean lav2 = false;
    static boolean lav3 = false;
    static boolean lav4 = false;
    static boolean lav0 = false;
    static double kwmeslav;
    //LAVANDERIA
    //BANHEIRO 1
    final static String lampbp = Banheiro1.lampbp;
    final static String espelhobp = Banheiro1.espelhobp;
    final static String torneirabp = Banheiro1.torneirabp;
    final static String chapinhabp = Banheiro1.chapinhabp;
    final static String secadorbp = Banheiro1.secadorbp;
    final static String chuveirobp = Banheiro1.chuveirobp;
    final static String aquecedorbp = Banheiro1.aquecedorbp;
    static boolean cl1bp = false;
    static boolean cl2bp = false;
    static boolean cl3bp = false;
    static boolean cl4bp = false;
    static boolean cl5bp = false;
    static boolean cl6bp = false;
    static boolean cl7bp = false;
    static double kwmesb1;
    //BANHEIRO 1
    //QUARTO DE SOLTEIRO
    final static String luzcqs = QuartoSolteiro.luzcqs;
    final static String aquecq = QuartoSolteiro.aquecq;
    final static String escriv = QuartoSolteiro.escriv;
    final static String arcondq = QuartoSolteiro.arcondq;
    final static String tvqs = QuartoSolteiro.tvqs;
    final static String luzqs = QuartoSolteiro.luzqs;
    static boolean qs1 = false;
    static boolean qs2 = false;
    static boolean qs3 = false;
    static boolean qs4 = false;
    static boolean qs5 = false;
    static boolean qs6 = false;
    static double kwmesqs;
    //QUARTO DE SOLTEIRO
    //QUARTO DE CASAL
    final static String abajurqc = QuartoDeCasal.abajurqc;
    final static String cabeceiraqc = QuartoDeCasal.cabeceiraqc;
    final static String lampadaqc = QuartoDeCasal.lampadaqc;
    final static String tvqc = QuartoDeCasal.tvqc;
    final static String arqc = QuartoDeCasal.arqc;
    static boolean qc1 = false;
    static boolean qc2 = false;
    static boolean qc3 = false;
    static boolean qc4 = false;
    static boolean qc5 = false;
    static double kwmesqc;
    //QUARTO DE CASAL
    //BANHEIRO 2
    final static String lampb2 = Banheiro2.lampb2;
    final static String chuveiro = Banheiro2.chuveiro;
    final static String espelho = Banheiro2.espelho;
    final static String arcondb = Banheiro2.arcondb;
    final static String banheira = Banheiro2.banheira;
    static boolean cl1bv = false;
    static boolean cl2bv = false;
    static boolean cl3bv = false;
    static boolean cl4bv = false;
    static boolean cl5bv = false;
    static double kwmesb2;
    //BANHEIRO 2
    //COZINHA
    final static String forno = Cozinha.forno;
    final static String armario = Cozinha.armario;
    final static String chaleira = Cozinha.chaleira;
    final static String torradeira = Cozinha.torradeira;
    final static String geladeira = Cozinha.geladeira;
    final static String microondas = Cozinha.microondas;
    final static String lampc = Cozinha.lampc;
    static boolean coz1 = false;
    static boolean coz2 = false;
    static boolean coz3 = false;
    static boolean coz4 = false;
    static boolean coz5 = false;
    static boolean coz6 = false;
    static boolean coz7 = false;
    static double kwmesc;
    //COZINHA
    //ESCRITORIO
    final static String roteador = Escritorio.roteador;
    final static String abajes = Escritorio.abajes;
    final static String impre = Escritorio.impre;
    final static String note = Escritorio.note;
    final static String lampes = Escritorio.lampes;
    final static String ares = Escritorio.ares;
    static double kwmesesc;
    static boolean esc1 = false;
    static boolean esc2 = false;
    static boolean esc3 = false;
    static boolean esc4 = false;
    static boolean esc5 = false;
    static boolean esc6 = false;
    //ESCRITORIO
    //SALA DE ESTAR
    final static String homethe = SalaDeEstar.homethe;
    final static String lumise = SalaDeEstar.lumise;
    final static String tvse = SalaDeEstar.tvse;
    final static String lampse = SalaDeEstar.lampse;
    final static String arse = SalaDeEstar.arse;
    static boolean se1 = false;
    static boolean se2 = false;
    static boolean se3 = false;
    static boolean se4 = false;
    static boolean se5 = false;
    static double kwmesse;
    //SALA DE ESTAR




    public Controlling() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        singletom = this;
        setContentView(R.layout.activity_controlling);
        ActivityHelper.initialize(this);
        btn_inicio = findViewById(R.id.btn_inicio);
        Intent intent = getIntent();
        Bundle b = intent.getExtras();
        mDevice = b.getParcelable(MainActivity.DEVICE_EXTRA);
        mDeviceUUID = UUID.fromString(b.getString(MainActivity.DEVICE_UUID));
        Log.d(TAG, "Pronto");

        btn_inicio.setOnClickListener(v -> {
            Intent intent0 = new Intent(this, Comodo.class);
            startActivity(intent0);
        });
    }

    //DEFINIÇÃO DE TODOS OS BOTÕES DOS COMODOS
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View view) {
        //DELAY ON BUTTONS
        if (bloqueio) {
               return;
         }
             Toast.makeText(view.getContext(),"Bloqueado, aguarde um instante!",Toast.LENGTH_LONG).show();
        bloqueio = true;

        try {
            switch (view.getId()) {
                case R.id.btn_lav0:
                    mBTSocket.getOutputStream().write(ferrol.getBytes());
                    if (!lav0) {
                        lav0 = true;
                        kwmeslav = kwmeslav + 72;
                        break;
                    } else
                        lav0 = false;
                    kwmeslav = kwmeslav - 72;
                    break;
                case (R.id.btn_lav1):
                    mBTSocket.getOutputStream().write(luzl.getBytes());
                    if (!lav1) {
                        lav1 = true;
                        kwmeslav = kwmeslav + 1.8;
                        break;
                    } else
                        lav1 = false;
                    kwmeslav = kwmeslav - 1.8;
                    break;
                case (R.id.btn_lav2):
                    mBTSocket.getOutputStream().write(centrifugal.getBytes());
                    if (!lav2) {
                        lav2 = true;
                        kwmeslav = kwmeslav + 54;
                        break;
                    } else
                        lav2 = false;
                    kwmeslav = kwmeslav - 54;
                    break;
                case (R.id.btn_lav3):
                    mBTSocket.getOutputStream().write(maqlavarl.getBytes());
                    if (!lav3) {
                        lav3 = true;
                        kwmeslav = kwmeslav + 90;
                        break;
                    } else
                        lav3 = false;
                    kwmeslav = kwmeslav - 90;
                    break;
                case (R.id.btn_lav4):
                    mBTSocket.getOutputStream().write(aspl.getBytes());
                    if (!lav4) {
                        lav4 = true;
                        kwmeslav = kwmeslav + 15;
                        break;
                    } else
                        lav4 = false;
                    kwmeslav = kwmeslav - 15;
                    break;
                case (R.id.img_lampb1):
                    mBTSocket.getOutputStream().write(lampbp.getBytes());
                    if (!cl1bp) {
                        cl1bp = true;
                        kwmesb1 = kwmesb1 + 7.2;
                        break;
                    } else cl1bp = false;
                    kwmesb1 = kwmesb1 - 7.2;
                    break;
                case (R.id.img_espb1):
                    mBTSocket.getOutputStream().write(espelhobp.getBytes());
                    if (!cl2bp) {
                        cl2bp = true;
                        kwmesb1 = kwmesb1 + 5.4;
                        break;
                    } else cl2bp = false;
                    kwmesb1 = kwmesb1 - 5.4;
                    break;
                case (R.id.img_tornb1):
                    mBTSocket.getOutputStream().write(torneirabp.getBytes());
                    if (!cl3bp) {
                        cl3bp = true; //16,5
                        kwmesb1 = kwmesb1 + 16.5;
                        break;
                    } else cl3bp = false;
                    kwmesb1 = kwmesb1 - 16.5;
                    break;
                case (R.id.img_chapb1):
                    mBTSocket.getOutputStream().write(chapinhabp.getBytes());
                    if (!cl4bp) {
                        cl4bp = true;
                        kwmesb1 = kwmesb1 + 0.9;
                        break;
                    } else cl4bp = false;
                    kwmesb1 = kwmesb1 - 0.9;
                    break;
                case (R.id.img_secb1):
                    mBTSocket.getOutputStream().write(secadorbp.getBytes());
                    if (!cl5bp) {
                        cl5bp = true;
                        kwmesb1 = kwmesb1 + 11.25;
                        break;
                    } else cl5bp = false;
                    kwmesb1 = kwmesb1 - 11.25;
                    break;
                case (R.id.img_chuvb1):
                    mBTSocket.getOutputStream().write(chuveirobp.getBytes());
                    if (!cl6bp) {
                        cl6bp = true;
                        kwmesb1 = kwmesb1 + 165;
                        break;
                    } else cl6bp = false;
                    kwmesb1 = kwmesb1 - 165;
                    break;
                case (R.id.img_aquceb1):
                    mBTSocket.getOutputStream().write(aquecedorbp.getBytes());
                    if (!cl7bp) {
                        cl7bp = true;
                        kwmesb1 = kwmesb1 + 60;
                        break;
                    } else
                        cl7bp = false;
                    kwmesb1 = kwmesb1 - 60;
                    break;
                case (R.id.img_lampb2):
                    mBTSocket.getOutputStream().write(lampb2.getBytes());
                    if (!cl1bv) {
                        cl1bv = true;
                        kwmesb2 = kwmesb2 + 36;
                        break;
                    } else
                        cl1bv = false;
                    kwmesb2 = kwmesb2 - 36;
                    break;
                case (R.id.img_chuvb2):
                    mBTSocket.getOutputStream().write(chuveiro.getBytes());
                    if (!cl2bv) {
                        cl2bv = true;
                        kwmesb2 = kwmesb2 + 82.5;
                        break;
                    } else
                        cl2bv = false;
                    kwmesb2 = kwmesb2 - 82.5;
                    break;
                case (R.id.img_espb2):
                    mBTSocket.getOutputStream().write(espelho.getBytes());
                    if (!cl3bv) {
                        cl3bv = true;
                        kwmesb2 = kwmesb2 + 3.6;
                        break;
                    } else
                        cl3bv = false;
                    kwmesb2 = kwmesb2 - 3.6;
                    break;
                case (R.id.img_arb2):
                    mBTSocket.getOutputStream().write(arcondb.getBytes());
                    if (!cl4bv) {
                        cl4bv = true;
                        kwmesb2 = kwmesb2 + 20.25;
                        break;
                    } else
                        cl4bv = false;
                    kwmesb2 = kwmesb2 - 20.25;
                    break;
                case (R.id.img_banb2):
                    mBTSocket.getOutputStream().write(banheira.getBytes());
                    if (!cl5bv) {
                        cl5bv = true;
                        kwmesb2 = kwmesb2 + 82.5;
                        break;
                    } else
                        cl5bv = false;
                    kwmesb2 = kwmesb2 - 82.5;
                    break;
                case (R.id.img_fornocoz1):
                    mBTSocket.getOutputStream().write(forno.getBytes());
                    if (!coz1) {
                        coz1 = true;
                        kwmesc = kwmesc + 180;
                        break;
                    } else
                        coz1 = false;
                    kwmesc = kwmesc - 180;
                    break;
                case (R.id.img_armcoz1):
                    mBTSocket.getOutputStream().write(armario.getBytes()); //N SEI O VALOR
                    if (!coz2) {
                        coz2 = true;
                        kwmesc = kwmesc + 22.5;
                        break;
                    } else
                        coz2 = false;
                    kwmesc = kwmesc - 22.5;
                    break;
                case (R.id.img_chalcoz1):
                    mBTSocket.getOutputStream().write(chaleira.getBytes());
                    if (!coz3) {
                        coz3 = true;
                        kwmesc = kwmesc + 8.25;
                        break;
                    } else
                        coz3 = false;
                    kwmesc = kwmesc - 8.25;
                    break;
                case (R.id.img_torrcoz1):
                    mBTSocket.getOutputStream().write(torradeira.getBytes());
                    if (!coz4) {
                        coz4 = true;
                        kwmesc = kwmesc + 6;
                        break;
                    } else
                        coz4 = false;
                    kwmesc = kwmesc - 6;
                    break;
                case (R.id.img_gelcoz1):
                    mBTSocket.getOutputStream().write(geladeira.getBytes());
                    if (!coz5) {
                        coz5 = true;
                        kwmesc = kwmesc + 180;
                        break;
                    } else
                        coz5 = false;
                    kwmesc = kwmesc - 180;
                    break;
                case (R.id.img_microcoz1):
                    mBTSocket.getOutputStream().write(microondas.getBytes());
                    if (!coz6) {
                        coz6 = true;
                        kwmesc = kwmesc + 21;
                        break;
                    } else
                        coz6 = false;
                    kwmesc = kwmesc - 21;
                    break;
                case (R.id.img_lampcoz1):
                    mBTSocket.getOutputStream().write(lampc.getBytes());
                    if (!coz7) {
                        coz7 = true;
                        kwmesc = kwmesc + 9;
                        break;
                    } else
                        coz7 = false;
                    kwmesc = kwmesc - 9;
                    break;
                case (R.id.btn_es1):
                    mBTSocket.getOutputStream().write(roteador.getBytes());
                    if (!esc1) {
                        esc1 = true;
                        kwmesesc = kwmesesc + 19.44;
                        break;
                    } else
                        esc1 = false;
                    kwmesesc = kwmesesc - 19.44;
                    break;
                case (R.id.btn_es2):
                    mBTSocket.getOutputStream().write(abajes.getBytes());
                    if (!esc2) {
                        esc2 = true;
                        kwmesesc = kwmesesc + 9;
                        break;
                    } else
                        esc2 = false;
                    kwmesesc = kwmesesc - 9;
                    break;
                case (R.id.btn_es3):
                    mBTSocket.getOutputStream().write(impre.getBytes());
                    if (!esc3) {
                        esc3 = true;
                        kwmesesc = kwmesesc + 0.27;
                        break;
                    } else
                        esc3 = false;
                    kwmesesc = kwmesesc - 0.27;
                    break;
                case (R.id.btn_es4):
                    mBTSocket.getOutputStream().write(note.getBytes());
                    if (!esc4) {
                        esc4 = true;
                        kwmesesc = kwmesesc + 54;
                        break;
                    } else
                        esc4 = false;
                    kwmesesc = kwmesesc - 54;
                    break;
                case (R.id.btn_es5):
                    mBTSocket.getOutputStream().write(lampes.getBytes());
                    if (!esc5) {
                        esc5 = true;
                        kwmesesc = kwmesesc + 10.8;
                        break;
                    } else
                        esc5 = false;
                    kwmesesc = kwmesesc - 10.8;
                    break;
                case (R.id.btn_es6):
                    mBTSocket.getOutputStream().write(ares.getBytes());
                    if (!esc6) {
                        esc6 = true;
                        kwmesesc = kwmesesc + 121.5;
                        break;
                    } else
                        esc6 = false;
                    kwmesesc = kwmesesc - 121.5;
                    break;
                case (R.id.btn_qc1):
                    mBTSocket.getOutputStream().write(abajurqc.getBytes());
                    if (!qc1) {
                        qc1 = true;
                        kwmesqc = kwmesqc + 5.4;
                        break;
                    } else
                        qc1 = false;
                    kwmesqc = kwmesqc - 5.4;
                    break;
                case (R.id.btn_qc2):
                    mBTSocket.getOutputStream().write(cabeceiraqc.getBytes());
                    if (!qc2) {
                        qc2 = true;
                        kwmesqc = kwmesqc + 3.6;
                        break;
                    } else
                        qc2 = false;
                    kwmesqc = kwmesqc - 3.6;
                    break;
                case (R.id.btn_qc3):
                    mBTSocket.getOutputStream().write(lampadaqc.getBytes());
                    if (!qc3) {
                        qc3 = true;
                        kwmesqc = kwmesqc + 9;
                        break;
                    } else
                        qc3 = false;
                    kwmesqc = kwmesqc - 9;
                    break;
                case (R.id.btn_qc4):
                    mBTSocket.getOutputStream().write(tvqc.getBytes());
                    if (!qc4) {
                        qc4 = true;
                        kwmesqc = kwmesqc + 24.75;
                        break;
                    } else
                        qc4 = false;
                    kwmesqc = kwmesqc - 24.75;
                    break;
                case (R.id.btn_qc5):
                    mBTSocket.getOutputStream().write(arqc.getBytes());
                    if (!qc5) {
                        qc5 = true;
                        kwmesqc = kwmesqc + 261;
                        break;
                    } else
                        qc5 = false;
                    kwmesqc = kwmesqc - 261;
                    break;
                case (R.id.btn_quars1):
                    mBTSocket.getOutputStream().write(luzcqs.getBytes());// luzcqs aquecq escriv arcondq tvqs luzqs
                    if (!qs1) {
                        qs1 = true;
                        kwmesqs = kwmesqs + 3.6;
                        break;
                    } else
                        qs1 = false;
                    kwmesqs = kwmesqs - 3.6;
                    break;
                case (R.id.btn_quars2):
                    mBTSocket.getOutputStream().write(aquecq.getBytes());
                    if (!qs2) {
                        qs2 = true;
                        kwmesqs = kwmesqs + 1.92;
                        break;
                    } else
                        qs2 = false;
                    kwmesqs = kwmesqs - 1.92;
                    break;
                case (R.id.btn_quars3):
                    mBTSocket.getOutputStream().write(escriv.getBytes());
                    if (!qs3) {
                        qs3 = true;
                        kwmesqs = kwmesqs + 6.6;
                        break;
                    } else// luzcqs aquecq escriv arcondq tvqs luzqs
                        qs3 = false;
                    kwmesqs = kwmesqs - 6.6;
                case (R.id.btn_quars4):
                    mBTSocket.getOutputStream().write(arcondq.getBytes());
                    if (!qs4) {
                        qs4 = true;
                        kwmesqs = kwmesqs + 243;
                        break;
                    } else
                        qs4 = false;
                    kwmesqs = kwmesqs - 243;
                    break;
                case (R.id.btn_quars5):
                    mBTSocket.getOutputStream().write(tvqs.getBytes());
                    if (!qs5) {
                        qs5 = true;
                        kwmesqs = kwmesqs + 17.1;
                        break;
                    } else
                        qs5 = false;
                    kwmesqs = kwmesqs - 17.1;
                    break;
                case (R.id.btn_quars6):
                    mBTSocket.getOutputStream().write(luzqs.getBytes());
                    if (!qs6) {
                        qs6 = true;
                        kwmesqs = kwmesqs + 5.4;
                        break;
                    } else
                        qs6 = false;
                    kwmesqs = kwmesqs - 5.4;
                    break;
                case (R.id.btn_se1):
                    mBTSocket.getOutputStream().write(homethe.getBytes());
                    if (!se1) {
                        se1 = true;
                        kwmesse = kwmesse + 90;
                        break;
                    } else
                        se1 = false;
                    kwmesse = kwmesse - 90;
                    break;
                case (R.id.btn_se2):
                    mBTSocket.getOutputStream().write(lumise.getBytes());
                    if (!se2) {
                        se2 = true;
                        kwmesse = kwmesse + 16.2;
                        break;
                    } else
                        se2 = false;
                    kwmesse = kwmesse - 16.2;
                    break;
                case (R.id.btn_se3):
                    mBTSocket.getOutputStream().write(tvse.getBytes());
                    if (!se3) {
                        se3 = true;
                        kwmesse = kwmesse + 29.7;
                        break;
                    } else
                        se3 = false;
                    kwmesse = kwmesse - 29.7;
                    break;
                case (R.id.btn_se4):
                    mBTSocket.getOutputStream().write(lampse.getBytes());
                    if (!se4) {
                        se4 = true;
                        kwmesse = kwmesse + 37.8;
                        break;
                    } else
                        se4 = false;
                    kwmesse = kwmesse - 37.8;
                    break;
                case (R.id.btn_se5):
                    mBTSocket.getOutputStream().write(arse.getBytes());
                    if (!se5) {
                        se5 = true;
                        kwmesse = kwmesse + 348;
                        break;
                    } else
                        se5 = false;
                    kwmesse = kwmesse - 348;
                    break;

            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        //DELAY ON BUTTONS
        new Thread(() -> {

        try {
          Thread.sleep(500);
           Controlling.singletom.runOnUiThread(()->{
            Toast.makeText(Controlling.singletom,"Liberado",Toast.LENGTH_SHORT).show();
           });
        } catch (InterruptedException e) {
           e.printStackTrace();
         }
           bloqueio = false;
         }).start();
    }

    class ReadInput implements Runnable {

        private boolean bStop = false;
        private final Thread t;

        public ReadInput() {
            t = new Thread(this, "Input Thread");
            t.start();
        }

        public boolean isRunning() {
            return t.isAlive();
        }

        @Override
        public void run() {
            InputStream inputStream;

            try {
                inputStream = mBTSocket.getInputStream();
                while (!bStop) {
                    byte[] buffer = new byte[256];
                    if (inputStream.available() > 0) {
                        inputStream.read(buffer);
                        int i;
                        /*
                         *String(buffer) pega o buffer inteiro 256 chars http://stackoverflow.com/a/8843462/1287554
                         *
                         */
                        for (i = 0; i < buffer.length && buffer[i] != 0; i++) {
                        }
                    }
                    Thread.sleep(500);
                }
            } catch (IOException e) {
// TODO Auto-generated catch block

                e.printStackTrace();
            } catch (InterruptedException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        public void stop() {
            bStop = true;
        }

    }

    @SuppressLint("StaticFieldLeak")
    public class DisConnectBT extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected Void doInBackground(Void... params) {

            if (mReadThread != null) {
                mReadThread.stop();
                while (mReadThread.isRunning())
                    ; //Espere ate isso parar
                mReadThread = null;

            }

            try {
                mBTSocket.close();
            } catch (IOException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            mIsBluetoothConnected = false;
        }

    }

    private void msg() {
        Toast.makeText(getApplicationContext(), "Dispositivo conectado com sucesso", Toast.LENGTH_SHORT).show();
    }
//ON PAUSE
    // @Override
    //protected void onPause() {
    //   if (mBTSocket != null && mIsBluetoothConnected) {
    //       new DisConnectBT().execute();
    //   System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAA");
    //     }
    //   Log.d(TAG, "Pausado");
    //  super.onPause();
    //  }

    @Override
    protected void onResume() {
        if (mBTSocket == null || !mIsBluetoothConnected) {
            new ConnectBT().execute();
        }
        Log.d(TAG, "Resumindo");
        super.onResume();
    }

//ON STOP
    //  @Override
    //  protected void onStop() {
    //     Log.d(TAG, "Parado");
    //     super.onStop();
    //  }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
// TODO Auto-generated method stub
        super.onSaveInstanceState(outState);
    }

    @SuppressLint("StaticFieldLeak")
    private class ConnectBT extends AsyncTask<Void, Void, Void> {
        private boolean mConnectSuccessful = true;

        @Override
        protected void onPreExecute() {

            progressDialog = ProgressDialog.show(Controlling.this, "Aguarde", "Conectando");// http://stackoverflow.com/a/11130220/1287554

        }

        @Override
        protected Void doInBackground(Void... devices) {

            try {
                if (mBTSocket == null || !mIsBluetoothConnected) {
                    mBTSocket = mDevice.createInsecureRfcommSocketToServiceRecord(mDeviceUUID);
                    BluetoothAdapter.getDefaultAdapter().cancelDiscovery();
                    mBTSocket.connect();
                }
            } catch (IOException e) {
// Não conseguiu conectar com o dispositivo`
                e.printStackTrace();
                mConnectSuccessful = false;


            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            if (!mConnectSuccessful) {
                Toast.makeText(getApplicationContext(), "Não foi possivel se conectar ao Dispositivo. Tente novamente.", Toast.LENGTH_LONG).show();
                finish();
            } else {
                msg();
                mIsBluetoothConnected = true;
                mReadThread = new ReadInput(); // inicia leitor de entrada
            }

            progressDialog.dismiss();
        }

    }

    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();
    }
}