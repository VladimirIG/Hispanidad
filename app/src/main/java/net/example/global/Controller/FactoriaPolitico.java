package net.example.global.Controller;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.ContextCompat;

import net.example.global.Model.Politico;
import net.example.global.R;

public class FactoriaPolitico extends ContextCompat {

    public static final int PSanchez = 0;
    public static final int PCasado = 1;
    public static final int SAbascal = 2;
    public static final int PIglesias = 3;
    public static final int IArimadas = 4;
    public static final int IErrejon = 5;
    public static final int MRajoy = 6;
    public static final int JLZapatero = 7;

    //public static int PSanchez = 0;



    public static Politico getInstanceOf(Context context, int codigoPolitico)
    {
        int id;
        String[] valores;
        String nombre;
        Drawable imagen;
        String partido;
        Drawable colorBg;
        String[] coletillaVictoria;
        String[] coletillaDerrota;
        Politico politico;

        switch(codigoPolitico) {
            case PSanchez:
                valores = new String[]{"monarquia", "democracia", "legalismo", "progresismo", "tecnocracia"};
                nombre  = "Pedro Sanchez";
                imagen = context.getResources().getDrawable(R.drawable.aaa_pedro);
                partido = "PSOE";
                colorBg = context.getResources().getDrawable(R.color.rojo);
                coletillaVictoria = new String[]{"El PSOE es la izquierda que trata de reformar, no la que se contenta sólo con protestar."
                        ,"La consulta solo puede ser legal tras una reforma de la Constitución."
                        ,"El voto, como la tierra, para el que se lo trabaja."
                        ,"Mi único aparato es mi Peugeot 407."};

                coletillaDerrota = new String[]{"A casita que hace mucho frío."
                        ,"¿Hola hay alguien ahí?"
                        ,"Dormir se me da genial."
                        ,"No estoy muerto."};


                politico = new Politico(PSanchez, valores, nombre, imagen, partido, colorBg, coletillaVictoria, coletillaDerrota);
                return politico;


            case PCasado:
                valores = new String[]{"monarquia", "conservacionismo","liberalismo","cristianismo", "unionista"};
                nombre  = "Pablo Casado";
                imagen = context.getResources().getDrawable(R.drawable.aaa_casado);
                partido = "PP";
                colorBg = context.getResources().getDrawable(R.color.azul);
                coletillaVictoria = new String[]{"Si ganamos los populares, ganan todos los españoles."
                        ,"En la práctica, menos PP está resultando ser menos España."
                        ,"Bajar impuestos y flexibilizar la economía para que los políticos manden menos y la gente más."
                        ,"La Hispanidad es la etapa más brillante, no de España, sino del hombre."};

                coletillaDerrota = new String[]{"A casita que hace mucho frío."
                        ,"El PP ha dejado un legado impecable en la Comunidad Valenciana."
                        ,"Viva el rey. Me parece bueno que nos vayamos acostumbrando."
                        ,"Para tener buena cosecha antes hay que arar, sembrar, segar y trillar… Como en política. Que nos dejen gobernar ya."};


                politico = new Politico(PCasado,valores, nombre, imagen, partido, colorBg, coletillaVictoria, coletillaDerrota);
                return politico;


            case SAbascal:
                valores = new String[]{"monarquia", "conservacionismo", "liberalismo", "nacionalismo", "cristianismo"};
                nombre  = "Santiago Abascal";
                imagen = context.getResources().getDrawable(R.drawable.aaa_abascal);
                partido = "VOX";
                colorBg = context.getResources().getDrawable(R.color.verde);
                coletillaVictoria = new String[]{"Los españoles vivimos de espaldas los unos a los otros."
                        ,"No queremos hacerlo con bombas, con chantajes o con referéndums ilegales."
                        ,"Hemos evitado la islamización y que podamos vivir en libertad."
                        ,"La inmigración hay que regularla en función de las necesidades de la economía nacional."};

                coletillaDerrota = new String[]{"Las ONG que viven del Gobierno colaboran con las mafias que se lucran de de la inmigración."
                        ,"Una nación sin fronteras no es una nación, al igual que una casa sin paredes no es una casa."
                        ,"Un matrimonio es la unión entre un hombre y una mujer."
                        ,"Creo que si gana continuará alimentando el efecto llamada de la inmigración."};


                politico = new Politico(SAbascal,valores, nombre, imagen, partido, colorBg, coletillaVictoria, coletillaDerrota);
                return politico;

            case PIglesias:
                valores = new String[]{ "republicanismo", "comunismo", "laicismo", "progresismo", "intervencionismo"};
                nombre  = "Pablo Iglesias";
                imagen = context.getResources().getDrawable(R.drawable.aaa_iglesias);
                partido = "Podemos";
                colorBg = context.getResources().getDrawable(R.color.violeta);
                coletillaVictoria = new String[]{"El derecho a sonreír no se vende."
                        ,"Estamos aquí porque el momento es ahora, depende de lo que le va a ocurrir a una generación entera."
                        ,"El poder no teme a la izquierda, sino a la gente."
                        ,"No se puede entender España sin entender su diversidad, con ustedes es imposible avanzar a una nueva época en la que la plurinacionalidd y la diversidad no sean un problema."};

                coletillaDerrota = new String[]{"La guillotina es el acontecimiento fundador de la democracia."
                        ,"Todos somos víctimas del consumismo capitalista. Además el mundo sería todavía peor sin tabaco."
                        ,"Se echa de menos al comandante. Venezuela es un modelo para Europa"
                        ,"La crisis terminará cuando el miedo cambie de bando."};


                politico = new Politico(PIglesias, valores, nombre, imagen, partido, colorBg, coletillaVictoria, coletillaDerrota);
                return politico;

            case IArimadas:
                valores = new String[]{"liberalismo", "tecnocracia", "democracia", "progresismo", "unionista"};
                nombre  = "Inés Arrimadas";
                imagen = context.getResources().getDrawable(R.drawable.aaa_arrimadas);
                partido = "Ciudadanos";
                colorBg = context.getResources().getDrawable(R.color.naranja);
                coletillaVictoria = new String[]{"En la política, como en la vida, uno tiene que ser valiente en los momentos importantes."
                        ,"La cola del paro es la misma para los independentistas y los no independentistas."
                        ,"A los españoles les importa mucho más que usted les diga cómo va a garantizar las pensiones que las tensiones territoriales."
                        ,"Igual que os ganamos en Cataluña, os vamos a ganar en el resto de España."};

                coletillaDerrota = new String[]{"Cada vez que Mariano Rajoy abre la boca, sube el pan."
                        ,"Estoy segura de que los votantes de Podemos no son independentistas, pero su candidato sí."
                        ,"Es un bendito problema que me comparen con Albert Rivera"
                        ,"Mi timidez y cierta inseguridad pueden pasar factura en política."};


                politico = new Politico(IArimadas, valores, nombre, imagen, partido, colorBg, coletillaVictoria, coletillaDerrota);
                return politico;


             /*VALORES POLÍTICOS v1.5
                        "legalismo", "monarquia", "republicanismo",
                        "comunismo", "unionista","democracia", "autocracia",
                        "intervencionismo", "liberalismo", "tecnocracia"
                        "nacionalismo",
                        "cristianismo""laicismo",
                        "progresismo", "conservacionismo",
                       */
        }
        return null;
    }

}







