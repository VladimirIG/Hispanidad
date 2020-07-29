package net.example.global;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import net.example.global.Activities.About;
import net.example.global.Activities.ComoJugar;
import net.example.global.Activities.SettingsActivity;
import net.example.global.Controller.GameManager;

public class MainActivity extends AppCompatActivity {

    Button btn_Jugar;
    Button btn_Opciones;
    Button btn_Salir;
    Button btn_Como;
    LinearLayout linearLayout;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Jugar = findViewById(R.id.btn_Jugar);
        btn_Opciones = findViewById(R.id.btn_Opciones);
        btn_Como = findViewById(R.id.btn_Como);
        btn_Salir = findViewById(R.id.btn_Salir);
        linearLayout = findViewById(R.id.ly);

        aplicarPreferencias();

        ///LISTENER EN BOTONES///////////////////////
        btn_Jugar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                jugarActivity();
            }
        });
        btn_Como.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                acercadeActivity();
            }
        });
        btn_Opciones.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                opcionesActivity();
            }
        });
        btn_Salir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                salir();
            }
        });
    }

    private void aplicarPreferencias() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if(pref.getBoolean("bg", false)) {
            linearLayout.setBackgroundResource(R.drawable.bg_gibraltar);
        }else{
            linearLayout.setBackgroundResource(R.drawable.bg);
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        aplicarPreferencias();
        Log.d("TURNO","--------------------------------------------------------onResume>");
    }

    //-------------------------Botones Inicio
    private void jugarActivity() {

        Intent miIntent = new Intent(this, GameManager.class);
        startActivity(miIntent);
        recreate();
    }

    private void opcionesActivity() {
        Intent miIntent = new Intent(this, SettingsActivity.class);
        startActivity(miIntent);
        recreate();
    }

    private void acercadeActivity(){
        Intent miIntent = new Intent(this, ComoJugar.class);
        startActivityForResult(miIntent,1);
        recreate();
    }

    private void salir() {
        System.exit(0);
    }

    //-------------------------MENU BAR
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.bar_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {

            case R.id.menu_buscar:
                Intent intent = new Intent(this, About.class);
                startActivity(intent);

            default:
                return super.onOptionsItemSelected(item);

        }
    }


}
