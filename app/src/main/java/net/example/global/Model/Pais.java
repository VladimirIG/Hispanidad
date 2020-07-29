package net.example.global.Model;

import android.graphics.drawable.Drawable;

public class Pais extends Politica
{

    private boolean visitado;

    //-----------------------------Constructor
    public Pais(int id, String[] valores, String nombre, Drawable imagen, boolean visitado) {
        super(id, valores, nombre, imagen);
        this.visitado = visitado;
    }

    //-----------------------------Métodos propios

    //-----------------------------Setters
    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
    }

    //-----------------------------Getters

    public boolean isVisitado() {
        return visitado;
    }
}
