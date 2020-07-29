package net.example.global.Activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import net.example.global.Controller.FactoriaPais;
import net.example.global.Controller.PaisAdapter;
import net.example.global.Model.Pais;
import net.example.global.R;

import java.util.ArrayList;

public class SeleccionPais extends Activity {

    private LinearLayout linearLayout;
    private GridView gridView;
    private TextView indicePuntosHispanidadyTurno;
    private PaisAdapter adapter;
    private ArrayList<Pais> paises = new ArrayList<Pais>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_pais);

        linearLayout = findViewById(R.id.ly);
        gridView = findViewById(R.id.gV);
        indicePuntosHispanidadyTurno = findViewById(R.id.indicehispanidadPais);

        mostrarPuntosHispanidad();
        rellenarGridV();

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pais paisSeleccionado = (Pais) parent.getAdapter().getItem(position);

                setResult(paisSeleccionado.getId());
                finish();
            }
        });
    }

    protected void onPause() {
        super.onPause();
        finish();
    }

    private void mostrarPuntosHispanidad() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        int puntos = bundle.getInt("hispanidad");
        int turno = bundle.getInt("turno");
        this.indicePuntosHispanidadyTurno.setText(String.format(getResources().getString(R.string.Titulo)+": %d | %s %d",puntos, getResources().getString(R.string.turno) ,turno));

    }
    private void rellenarGridV() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        ArrayList<Integer> idsPaises = bundle.getIntegerArrayList("anfitriones");
        ArrayList<Integer> idsPaisesVisitados = bundle.getIntegerArrayList("anfitrionesVisitados");

        if (idsPaisesVisitados.size() > 0){ //Comprobamos de que no esté vacío el array de IDs de paises visitados
            for (int id : idsPaises) {
                if (!idsPaisesVisitados.contains(id)) //por cada elemento en idsPaises verificamos que no esté visitado
                    paises.add(FactoriaPais.getInstanceOf(this, id));
            }
        }else {
            for (int id : idsPaises) {
                paises.add(FactoriaPais.getInstanceOf(this, id));
            }
        }

        adapter = new PaisAdapter(this, paises );
        gridView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        setResult(-2, null);
        super.onBackPressed();
        finish();
    }
}
