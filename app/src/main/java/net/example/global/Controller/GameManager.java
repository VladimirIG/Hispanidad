package net.example.global.Controller;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import net.example.global.Activities.GameOver;
import net.example.global.Activities.Resultado;
import net.example.global.Activities.SeleccionPais;
import net.example.global.Activities.SeleccionPj;
import net.example.global.Model.Pais;
import net.example.global.Model.Politica;
import net.example.global.Model.Politico;

import java.util.ArrayList;
import java.util.Random;

public class GameManager extends AppCompatActivity {

    //CONFIGURACION DE PARTIDA
    final static int NUMPOLITICOS = 5;
    final static int NUMPPAISES = 25; //MAX 35
    final static int HISPANIDADMAX = 100;
    final static int HISPANIDADMID = 30;


    static int MULTIPLICADORINFLUENCIA; //2 o 4 se modifica en Settings
    final static int TURNOSMAX = 15;

    //VARIABLES PARA EL MECANISMO DEL JUEGO
    final static int VISITAPOLITICO = 1;
    final static int PAISANFITRION = 2;
    private boolean isGameOn = true;
    private int turno = 0;
    private int puntosHispanidad = 20;
    private ArrayList<Politico> politicosGenerados;
    private ArrayList<Pais> paisesGenerados;
    private int id_politico;    //Estos dos int son para pasar el numero de referencia entre activities
    private int id_pais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aplicarPreferencias();
        generarPaises();
        generarPoliticos();
    }

    @Override
    protected void onResume() {
        super.onResume();

        comprobarEstadoPartida();

        if(isGameOn){
            seleccionPaisActivity();
            seleccionPjActivity();
        }else{
           finish();
        }
        if (turno != 0){ //nos saltamos el turno 0
            resolucionVisita();
        }
        turno++;
    }



    //----CONFIGURACION DE LA PARTIDA
    private void aplicarPreferencias() {
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        if(pref.getBoolean("modo", false)) {
            MULTIPLICADORINFLUENCIA = 6;
        }else{
            MULTIPLICADORINFLUENCIA = 3;
        }
    }

    private void generarPaises() {
        Random random = new Random();
        Pais paisAux;
        int r;
        paisesGenerados = new ArrayList<Pais>();

        boolean exist = false;

        while (paisesGenerados.size() != NUMPPAISES){//
            r = random.nextInt(FactoriaPais.MAXVALUE);
            paisAux = FactoriaPais.getInstanceOf(this, r);

            for (Pais p :paisesGenerados) {
                if (paisAux.getNombre().equals(p.getNombre())){
                    exist = true;
                }
            }
            if (exist == false){
                paisesGenerados.add(paisAux);
            }
            exist = false;
        }
    }

    private void generarPoliticos() {
        politicosGenerados = new ArrayList<Politico>() ;
        for (int i = 0; i < NUMPOLITICOS; i++) {
            politicosGenerados.add(FactoriaPolitico.getInstanceOf(this,i));
        }
    }


    //----FASES DE LA PARTIDA
    private void seleccionPaisActivity() {
        Intent miIntent = new Intent(this, SeleccionPais.class);
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("anfitriones", paisesIdInt());
        bundle.putIntegerArrayList("anfitrionesVisitados", paisesIdIntVisitados());
        bundle.putInt("hispanidad",puntosHispanidad);
        bundle.putInt("turno",turno);
        miIntent.putExtras(bundle);

        startActivityForResult(miIntent,PAISANFITRION);
    }

    private void seleccionPjActivity() {
        Intent miIntent = new Intent(this, SeleccionPj.class);
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList("enviados", politicosIdInt());
        bundle.putInt("hispanidad",puntosHispanidad);
        bundle.putInt("turno",turno);
        miIntent.putExtras(bundle);

        startActivityForResult(miIntent,VISITAPOLITICO);
    }

    private void resolucionVisita() {//
        Politico politicoEnviado = (Politico) conseguirPoliticoPorID(politicosGenerados,id_politico);//politicosGenerados.get(id_politico);
        Pais paisAnfitrion = (Pais) conseguirPaisPorID(paisesGenerados,id_pais);//paisesGenerados.get(id_pais);

        int valoresCompartidos = 0;
        int hispanidadResultante;
        for (String valoresDelPolitico : politicoEnviado.getValores() ) {

            for (String valoresDelPais : paisAnfitrion.getValores()) {
                if(valoresDelPolitico.equals(valoresDelPais))
                {
                    valoresCompartidos++;
                }
            }
        }

        if(valoresCompartidos > 1){
            hispanidadResultante = valoresCompartidos * MULTIPLICADORINFLUENCIA;
            mostrarResultado(politicoEnviado, paisAnfitrion, true, hispanidadResultante); //el booleano corresponde a si ha sido exitosa (true) o no,
            puntosHispanidad += hispanidadResultante;
        }else{
            hispanidadResultante = (valoresCompartidos +1) * MULTIPLICADORINFLUENCIA;
            mostrarResultado(politicoEnviado, paisAnfitrion, false, hispanidadResultante);
            puntosHispanidad -= hispanidadResultante;
        }

    } //Lanza mostrar resultado

    private void mostrarResultado(Politico politicoEnviado, Pais paisAnfitrion, boolean isInfluenciado, int hispanidadResultante) {
        Intent intent = new Intent(this, Resultado.class);
        Bundle bundle = new Bundle();
        bundle.putString("politico",politicoEnviado.getNombre());
        bundle.putString("pais",paisAnfitrion.getNombre());
        bundle.putBoolean("isInfluenciado",isInfluenciado);
        bundle.putInt("hispanidadResultante",hispanidadResultante);

        if (isInfluenciado){
            bundle.putString("coletilla",politicoEnviado.getColetilaV());
        }else{
            bundle.putString("coletilla",politicoEnviado.getColetilaD());
        }

        intent.putExtras(bundle);

        startActivityForResult(intent, 1);

    }


    //----ESTADOS DE LA PARTIDA
    private void comprobarEstadoPartida() {
        Log.d("TURNO","-------------------------------------------------------->" + String.valueOf(turno));

        if (puntosHispanidad >= HISPANIDADMAX){
            isGameOn = false;
            victoria();
            return;
        }
        if (puntosHispanidad <= 0){
            isGameOn = false;
            derrota();
            return;
        }
        if ((puntosHispanidad >= HISPANIDADMID) && (turno == TURNOSMAX)){
            isGameOn = false;
            tablas();
            return;
        }

        if (turno >= TURNOSMAX){
            isGameOn = false;
            derrota();
            return;
        }
        if (paisesGenerados.size() == (paisesIdIntVisitados().size())){
            isGameOn = false;
            derrota();
            return;
        }
    }

    private void victoria() {
        Intent intent = new Intent(this, GameOver.class);
        intent.putExtra("final","victoria");
        finish();
        startActivity(intent);
    }

    private void derrota() {
        Intent intent = new Intent(this, GameOver.class);
        intent.putExtra("final","derrota");
        finish();
        startActivity(intent);
    }

    private void tablas() {
        Intent intent = new Intent(this, GameOver.class);
        intent.putExtra("final","tablas");
        finish();
        startActivity(intent);
    }


    //----MÉTODOS AUXILIARES  estos métodos ayudan a pasar los ids a activities y a recuperar su objeto
    private Politico conseguirPoliticoPorID(ArrayList<Politico> politicosGenerados, int id_politico) {
        for (Politico p : politicosGenerados) {
            if (p.getId() == id_politico) {
                return p;
            }
        }
        return null;
    }

    private Pais conseguirPaisPorID(ArrayList<Pais> paisesGenerados, int id_pais) {
        for (Pais p : paisesGenerados) {
            if (p.getId() == id_pais) {
                return p;
            }
        }
        return null;
    }

    private void deshabilitarPaisVisitado(int id_paisVisitado) {
        for (Pais pais :paisesGenerados) {
            if(pais.getId() == id_paisVisitado){
                pais.setVisitado(true);
            }
        }
    }

    private ArrayList<Integer> politicosIdInt() {
        ArrayList<Integer> contenedor = new ArrayList<Integer>();
        for (Politico politico : politicosGenerados) {
            contenedor.add(politico.getId());
        }
        return contenedor;
    }

    private ArrayList<Integer> paisesIdInt() {
        ArrayList<Integer> contenedor = new ArrayList<Integer>();
        for (Pais pais : paisesGenerados) {
            contenedor.add(pais.getId());
        }
        return contenedor;
    }

    private ArrayList<Integer> paisesIdIntVisitados() { //Necesario para pasar el listado de país que hay que desabilitar en SeleccionPais()
        ArrayList<Integer> contenedor = new ArrayList<Integer>();

        for (Pais pais : paisesGenerados) {
            if (pais.isVisitado())
                contenedor.add(pais.getId());
        }
        return contenedor;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == VISITAPOLITICO){
            this.id_politico = resultCode;
        }
        if(requestCode == PAISANFITRION){
            this.id_pais = resultCode;
            deshabilitarPaisVisitado(id_pais);
        }
        if(requestCode == -1){ }
        if(requestCode == -2){finish(); }
    }
}

