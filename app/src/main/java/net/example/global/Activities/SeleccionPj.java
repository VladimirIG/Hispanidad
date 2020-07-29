package net.example.global.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import net.example.global.R;
import net.example.global.Controller.FactoriaPolitico;
import net.example.global.Model.Politico;
import net.example.global.Controller.PoliticoAdapter;
import java.util.ArrayList;

public class SeleccionPj extends Activity {
    private ListView listV_pjs;
    private TextView indicePuntosHispanidadyTurno;
    private PoliticoAdapter adapter;
    private ArrayList<Politico> politicos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seleccion_pj);
        listV_pjs = findViewById(R.id.listV_pjs);
        indicePuntosHispanidadyTurno = findViewById(R.id.indicehispanidadPolitico);

        mostrarPuntosHispanidad();
        rellenarListV();

        listV_pjs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override //Este método devuelve el id del político para luego rescatarlo de la factoría
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Politico politicoSeleccionado = (Politico) parent.getAdapter().getItem(position);

                setResult(politicoSeleccionado.getId());
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

    private void rellenarListV() {
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        ArrayList<Integer> idsPoliticos= bundle.getIntegerArrayList("enviados");
        for (int id : idsPoliticos) {
            politicos.add(FactoriaPolitico.getInstanceOf(this, id));
        }
        adapter = new PoliticoAdapter(this, politicos);
        listV_pjs.setAdapter(adapter);
    }

    @Override
    public void onBackPressed(){
        setResult(-2, null);
        super.onBackPressed();
        finish();
    }
}
