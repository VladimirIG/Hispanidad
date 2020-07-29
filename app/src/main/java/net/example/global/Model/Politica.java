package net.example.global.Model;

import android.graphics.drawable.Drawable;

public abstract class Politica {


    private int id;
    private String valores[];
    private String nombre;
    private Drawable imagen;


    //-----------------------------Constructor
    public Politica(int id,String[] valores, String nombre, Drawable imagen){
        this.id = id;
        this.valores = valores;
        this.nombre = nombre;
        this.imagen = imagen;
    }

    //-----------------------------Setters
    public void setValores(String[] valores) {
        this.valores = valores;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setImagen(Drawable imagen) {
        this.imagen = imagen;
    }


    //-----------------------------Getters
    public int getId() {
        return id;
    }
    public String[] getValores() {
        return valores;
    }
    public String getNombre() {
        return nombre;
    }
    public Drawable getImagen() {
        return imagen;
    }
}
