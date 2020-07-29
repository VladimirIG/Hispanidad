package net.example.global.Model;

import android.graphics.drawable.Drawable;

import java.util.Random;

public class Politico extends Politica{

    private int id;
    private String partido;
    private Drawable colorBg;
    private String[] coletillaVictoria;
    private String[] coletillaDerrota;


    //-----------------------------Constructor
    public Politico(int id, String[] valores, String nombre, Drawable imagen, String partido
            , Drawable colorBg, String[] coletillaVictoria, String[] coletillaDerrota){
        super(id,valores,nombre,imagen);
        this.id = id;
        this.partido = partido;
        this.colorBg = colorBg;
        this.coletillaVictoria = coletillaVictoria;
        this.coletillaDerrota = coletillaDerrota;
    }

    //-----------------------------Métodos propios

    public String getColetilaV(){
        Random random = new Random();
        int pos = random.nextInt(this.getColetillaVictoria().length);

        return this.getColetillaVictoria()[pos];
    }
    public String getColetilaD(){
        Random random = new Random();
        int pos = random.nextInt(this.getColetillaDerrota().length);

        return this.getColetillaDerrota()[pos];
    }

    //-----------------------------Setters
    public void setId(int id) {
        this.id = id;
    }
    public void setPartido(String partido) {
        this.partido = partido;
    }

    public void setColorBg(Drawable colorBg) {
        this.colorBg = colorBg;
    }

    public void setColetillaVictoria(String[] coletillaVictoria) {
        this.coletillaVictoria = coletillaVictoria;
    }

    public void setColetillaDerrota(String[] coletillaDerrota) {
        this.coletillaDerrota = coletillaDerrota;
    }

    //-----------------------------Getters
    public int getId() {
        return id;
    }

    public String getPartido() {
        return partido;
    }

    public Drawable getColorBg() {
        return colorBg;
    }

    public String[] getColetillaVictoria() {
        return coletillaVictoria;
    }

    public String[] getColetillaDerrota() {
        return coletillaDerrota;
    }
}
