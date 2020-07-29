package net.example.global.Controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

import net.example.global.Model.Pais;
import net.example.global.R;

/*
* LOS PAISES FUERON DISEÑADOS EN BASE A:
*https://upload.wikimedia.org/wikipedia/commons/6/6c/Religion_in_the_world.png
*https://es.wikipedia.org/wiki/Índice_de_democracia#/media/Archivo:EIU_Democracy_Index_2017.svg
*https://ilga.org/sites/default/files/ILGA_Map_2014_ENG.png
*Y artículos de wikipedia
* */


public class FactoriaPais extends ContextCompat{
    public static final int Venezuela = 0;
    public static final int Argentina = 1;
    public static final int Portugal = 2;
    public static final int Grecia = 3;
    public static final int Hungria = 4;


    public static final int Alemania = 5;
    public static final int Francia = 6;
    public static final int Filipinas = 7;
    public static final int Rusia = 8;
    public static final int ArabiaSaudita = 9;

    public static final int Turquia = 10;
    public static final int Uzbekistan = 11;
    public static final int Marruecos = 12;
    public static final int India = 13;
    public static final int Brasil = 14;


    public static final int ReinoUnido = 15;
    public static final int Peru = 16;
    public static final int EEUU = 17;
    public static final int Sudan = 18;
    public static final int Bulgaria = 19;

    public static final int Vaticano = 20;
    public static final int Japon = 21;
    public static final int Chile = 22;
    public static final int Mexico = 23;
    public static final int Austria = 24;

    public static final int Honduras = 25;
    public static final int RDCongo = 26;
    public static final int Finlandia = 27;
    public static final int Canada = 28;
    public static final int China = 29;

    public static final int Australia = 30;
    public static final int Somalia = 31;
    public static final int Iran = 32;
    public static final int Angola = 33;
    public static final int KoreaSur = 34;

    public static final int Suiza = 35;

    public static final int MAXVALUE = 36;

     /*VALORES POLÍTICOS v1.5
            "legalismo", "monarquia", "republicanismo",
            "comunismo", "unionista","democracia", "autocracia",
            "intervencionismo", "liberalismo", "tecnocracia"
            "nacionalismo",
            "cristianismo""laicismo",
            "progresismo", "conservacionismo",
           */


    public static Pais getInstanceOf(Context context, int codigoPais) {
        int id;
        String[] valores;
        String nombre;
        Drawable imagen;
        Pais pais;
        switch (codigoPais) {
            case Venezuela:
                id = Venezuela;
                valores = new String[]{"republicanismo", "intervencionismo"
                        , "cristianismo","conservacionismo"};

                nombre = "Venezuela";
                imagen = context.getResources().getDrawable(R.drawable.flag_ve);

                pais = new Pais(id, valores, nombre, imagen, false);
                return pais;


            case Argentina:
                id = Argentina;
                valores = new String[]{"republicanismo", "intervencionismo"
                , "cristianismo","progresismo"};

                nombre = "Argentina";
                imagen = context.getResources().getDrawable(R.drawable.flag_ar);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;


            case Portugal:
                id = Portugal;
                valores = new String[]{"republicanismo", "democracia"
                        , "cristianismo","progresismo"};

                nombre = "Portugal";
                imagen = context.getResources().getDrawable(R.drawable.flag_pt);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Grecia:
                id = Grecia;
                valores = new String[]{"republicanismo", "democracia"
                        , "cristianismo","progresismo"};

                nombre = "Grecia";
                imagen = context.getResources().getDrawable(R.drawable.flag_gr);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Hungria:
                id = Hungria;
                valores = new String[]{"republicanismo", "democracia"
                        , "laicismo","conservacionismo"};

                nombre = "Hungría";
                imagen = context.getResources().getDrawable(R.drawable.flag_hu);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Alemania:
                id = Alemania;
                valores = new String[]{"republicanismo", "democracia"
                        , "liberalismo","cristianismo"};

                nombre = "Alemania";
                imagen = context.getResources().getDrawable(R.drawable.flag_de);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Francia:
                id = Francia;
                valores = new String[]{"republicanismo", "democracia"
                        , "tecnocracia", "intervencionismo"};

                nombre = "Francia";
                imagen = context.getResources().getDrawable(R.drawable.flag_fr);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Filipinas:
                id = Filipinas;
                valores = new String[]{"republicanismo", "democracia"
                        , "intervencionismo", "cristianismo"};

                nombre = "Filipinas";
                imagen = context.getResources().getDrawable(R.drawable.flag_ph);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Rusia:
                id = Rusia;
                valores = new String[]{"republicanismo", "nacionalismo"
                        , "intervencionismo", "conservacionismo"};

                nombre = "Rusia";
                imagen = context.getResources().getDrawable(R.drawable.flag_ru);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case ArabiaSaudita:
                id = ArabiaSaudita;
                valores = new String[]{"monarquia", "autocracia"
                        , "intervencionismo", "conservacionismo"};

                nombre = "Arabia S.";
                imagen = context.getResources().getDrawable(R.drawable.flag_sa);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Turquia:
                id = Turquia;
                valores = new String[]{"republicanismo","nacionalismo",
                        "intervencionismo",  "conservacionismo"};

                nombre = "Turquia";
                imagen = context.getResources().getDrawable(R.drawable.flag_tr);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Uzbekistan:
                id = Turquia;
                valores = new String[]{"republicanismo","autocracia",
                        "tecnocracia",  "conservacionismo"};

                nombre = "Turquia";
                imagen = context.getResources().getDrawable(R.drawable.flag_uz);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Marruecos:
                id = Marruecos;
                valores = new String[]{"monarquia", "unionista",
                        "intervencionismo", "conservacionismo"};

                nombre = "Marruecos";
                imagen = context.getResources().getDrawable(R.drawable.flag_ma);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case India:
                id = India;
                valores = new String[]{"republicanismo", "nacionalismo",
                        "intervencionismo", "conservacionismo"};

                nombre = "India";
                imagen = context.getResources().getDrawable(R.drawable.flag_in);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Brasil:
                id = Brasil;
                valores = new String[]{"republicanismo", "cristianismo",
                        "intervencionismo", "progresismo"};

                nombre = "Brasil";
                imagen = context.getResources().getDrawable(R.drawable.flag_br);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case ReinoUnido:
                id = ReinoUnido;
                valores = new String[]{"monarquia", "legalismo",
                        "liberalismo", "progresismo"};

                nombre = "R. Unido";
                imagen = context.getResources().getDrawable(R.drawable.flag_gb);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Peru:
                id = Peru;
                valores = new String[]{"republicanismo", "cristianismo",
                        "liberalismo", "progresismo"};

                nombre = "Peru";
                imagen = context.getResources().getDrawable(R.drawable.flag_pe);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case EEUU:
                id = EEUU;
                valores = new String[]{"republicanismo", "democracia",
                        "liberalismo", "conservacionismo"};

                nombre = "EEUU";
                imagen = context.getResources().getDrawable(R.drawable.flag_us);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Sudan:
                id = Sudan;
                valores = new String[]{"republicanismo", "democracia",
                        "intervencionismo", "conservacionismo"};

                nombre = "Sudán";
                imagen = context.getResources().getDrawable(R.drawable.flag_sd);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Bulgaria:
                id = Bulgaria;
                valores = new String[]{"republicanismo", "democracia",
                        "intervencionismo", "unionista"};

                nombre = "Bulgaria";
                imagen = context.getResources().getDrawable(R.drawable.flag_bg);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Vaticano:
                id = Vaticano;
                valores = new String[]{"autocracia", "cristianismo",
                        "intervencionismo", "conservacionismo"};

                nombre = "C. Vaticano";
                imagen = context.getResources().getDrawable(R.drawable.flag_va);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Japon:
                id = Japon;
                valores = new String[]{"monarquia", "democracia",
                        "liberalismo", "nacionalismo"};

                nombre = "Japón";
                imagen = context.getResources().getDrawable(R.drawable.flag_jp);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Chile:
                id = Chile;
                valores = new String[]{"republicanismo", "democracia",
                        "liberalismo", "progresismo"};

                nombre = "Chile";
                imagen = context.getResources().getDrawable(R.drawable.flag_cl);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Mexico:
                id = Mexico;
                valores = new String[]{"republicanismo", "democracia",
                        "intervencionismo", "cristianismo"};

                nombre = "Mexico";
                imagen = context.getResources().getDrawable(R.drawable.flag_mx);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Austria:
                id = Austria;
                valores = new String[]{"republicanismo", "democracia",
                        "liberalismo", "nacionalismo"};

                nombre = "Austria";
                imagen = context.getResources().getDrawable(R.drawable.flag_at);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Honduras:
                id = Honduras;
                valores = new String[]{"republicanismo", "democracia",
                        "intervencionismo", "laicismo"};

                nombre = "Honduras";
                imagen = context.getResources().getDrawable(R.drawable.flag_hn);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case RDCongo:
                id = RDCongo;
                valores = new String[]{"republicanismo", "autocracia",
                        "intervencionismo", "cristianismo"};

                nombre = "R.D Congo";
                imagen = context.getResources().getDrawable(R.drawable.flag_cd);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Finlandia:
                id = Finlandia;
                valores = new String[]{"republicanismo", "democracia",
                        "progresismo", "laicismo"};

                nombre = "Finlandia";
                imagen = context.getResources().getDrawable(R.drawable.flag_fi);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Canada:
                id = Canada;
                valores = new String[]{"monarquia", "democracia",
                        "liberalismo", "laicismo"};

                nombre = "Canada";
                imagen = context.getResources().getDrawable(R.drawable.flag_ca);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case China:
                id = China;
                valores = new String[]{"republicanismo", "conservacionismo",
                        "comunismo", "laicismo"};

                nombre = "China";
                imagen = context.getResources().getDrawable(R.drawable.flag_cn);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Australia:
                id = Australia;
                valores = new String[]{"monarquia", "progresismo",
                        "liberalismo", "laicismo"};

                nombre = "Australia";
                imagen = context.getResources().getDrawable(R.drawable.flag_au);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Somalia:
                id = Somalia;
                valores = new String[]{"republicanismo", "conservacionismo",
                        "liberalismo", "unionista"};

                nombre = "Somalia";
                imagen = context.getResources().getDrawable(R.drawable.flag_so);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Iran:
                id = Iran;
                valores = new String[]{"republicanismo", "conservacionismo",
                        "intervencionismo", "autocracia"};

                nombre = "Irán";
                imagen = context.getResources().getDrawable(R.drawable.flag_ir);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case Angola:
                id = Angola;
                valores = new String[]{"republicanismo", "conservacionismo",
                        "intervencionismo", "autocracia"};

                nombre = "Angola";
                imagen = context.getResources().getDrawable(R.drawable.flag_ao);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

            case KoreaSur:
                id = KoreaSur;
                valores = new String[]{"republicanismo", "progresismo",
                        "liberalismo", "democracia"};

                nombre = "Corea del S";
                imagen = context.getResources().getDrawable(R.drawable.flag_kr);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;


            case Suiza:
                id = Suiza;
                valores = new String[]{"republicanismo", "conservacionismo",
                        "liberalismo", "democracia"};

                nombre = "Suiza";
                imagen = context.getResources().getDrawable(R.drawable.flag_ch);

                pais = new Pais(id,valores, nombre, imagen, false);
                return pais;

        }

        return null;
    }

}
