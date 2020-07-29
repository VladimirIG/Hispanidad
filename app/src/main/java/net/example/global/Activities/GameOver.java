package net.example.global.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.example.global.R;

public class GameOver extends Activity {

    MediaPlayer player;
    String tipoDeFinal;
    LinearLayout linearLayout;
    TextView txt_Cabecera;
    TextView txt_Cuerpo;
    Button btn_Atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        linearLayout = findViewById(R.id.fondoGameOver);
        txt_Cabecera = findViewById(R.id.txt_Cabecera);
        txt_Cuerpo = findViewById(R.id.txt_Cuerpo);
        btn_Atras = findViewById(R.id.btn_Atras_GO);

        btn_Atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(-1);
                finish();
            }
        });
        tipoDeFinal = getIntent().getExtras().getString("final");
        configurarPantalla(tipoDeFinal);
    }

    private void configurarPantalla(String tipoDeFinal) {
        switch (tipoDeFinal){
            case "victoria":
                linearLayout.setBackgroundResource(R.drawable.bg_victoria);
                txt_Cabecera.setText(getResources().getString(R.string.gameoverVictoria));
                txt_Cuerpo.setText(getResources().getString(R.string.gameoverVictoriaMensaje));
                player = MediaPlayer.create(this, R.raw.bso_victoria);
                player.start();
                break;
            case "tablas":
                linearLayout.setBackgroundResource(R.drawable.bg_tablas);
                txt_Cabecera.setText(getResources().getString(R.string.gameoverTablas));
                txt_Cuerpo.setText(getResources().getString(R.string.gameoverTablasMensaje));
                player = MediaPlayer.create(this, R.raw.bso_tablas);
                player.start();
                break;
            case "derrota":
                linearLayout.setBackgroundResource(R.drawable.bg_derrota);
                txt_Cabecera.setText(getResources().getString(R.string.gameoverDerrota));
                txt_Cuerpo.setText(getResources().getString(R.string.gameoverDerrotaMensaje));
                player = MediaPlayer.create(this, R.raw.bso_derrota);
                player.start();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        player.stop();
    }
}
