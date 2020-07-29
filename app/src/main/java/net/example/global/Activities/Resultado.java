package net.example.global.Activities;

import androidx.annotation.RequiresApi;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.example.global.R;

import java.util.ArrayList;
import java.util.Random;

public class Resultado extends Activity {
    LinearLayout linearLayout;

    boolean isInfluenciado;
    String nombre;
    String pais;
    String colet;
    int puntos;

    TextView txt_Cabecera;
    TextView txt_Cuerpo;
    TextView txt_Pie;

    TextView txt_txt_HispanidadResultante;

    ArrayList<Drawable> fondoBien;
    ArrayList<Drawable> fondoMal;

    TextView coletilla;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        linearLayout = findViewById(R.id.fondoResultado);
        txt_Cabecera = findViewById(R.id.txt_Cabecera);
        txt_Cuerpo = findViewById(R.id.txt_Cuerpo);
        txt_Pie = findViewById(R.id.txt_Pie);

        txt_txt_HispanidadResultante = findViewById(R.id.txt_HispanidadResultante);

        rellenarArrayFondo();
        conseguirBundle();
        ponerFondo();
        ponerTexto();

    }

    private void rellenarArrayFondo() {
        fondoBien = new ArrayList<>();
        fondoMal= new ArrayList<>();
        fondoBien.add(getResources().getDrawable(R.drawable.bg_resultbien1));
        fondoBien.add(getResources().getDrawable(R.drawable.bg_resultbien2));
        fondoBien.add(getResources().getDrawable(R.drawable.bg_resultbien3));
        fondoBien.add(getResources().getDrawable(R.drawable.bg_resultbien4));

        fondoMal.add(getResources().getDrawable(R.drawable.bg_resultmal1));
        fondoMal.add(getResources().getDrawable(R.drawable.bg_resultmal2));
        fondoMal.add(getResources().getDrawable(R.drawable.bg_resultmal3));
        fondoMal.add(getResources().getDrawable(R.drawable.bg_resultmal4));
    }

    private void conseguirBundle() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        this.isInfluenciado = bundle.getBoolean("isInfluenciado");
        this.nombre = bundle.getString("politico");
        this.pais = bundle.getString("pais");
        this.colet = bundle.getString("coletilla");
        this.puntos = bundle.getInt("hispanidadResultante");
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void ponerFondo() {
        Random random = new Random();
        if (isInfluenciado){
            linearLayout.setBackground(fondoBien.get(random.nextInt(fondoBien.size())));
        }else{
            linearLayout.setBackground(fondoMal.get(random.nextInt(fondoMal.size())));
        }
    }

    private void ponerTexto() {
        if (isInfluenciado){
            txt_Cabecera.setTextColor(getResources().getColor(R.color.colorPrimary));
            txt_Cabecera.setText(getResources().getString(R.string.resultVictoria));
            tiempo.run();
            txt_Cuerpo.setText(colet);
            txt_Pie.setText(nombre+" "+getResources().getString(R.string.desde)+" "+pais);

            txt_txt_HispanidadResultante.setText("+ " + String.valueOf(puntos));
        }else{
            txt_Cabecera.setTextColor(getResources().getColor(R.color.rojo));
            txt_Cabecera.setText(getResources().getString(R.string.resultDerrota));
            tiempo.run();
            txt_Cuerpo.setText(colet);
            txt_Pie.setText(nombre+" "+getResources().getString(R.string.desde)+" "+pais);

            txt_txt_HispanidadResultante.setText("- " + String.valueOf(puntos));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        setResult(-2);
        finish();
    }

    private Thread tiempo = new Thread() {
        public void run() {
            try {
                sleep(1000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}