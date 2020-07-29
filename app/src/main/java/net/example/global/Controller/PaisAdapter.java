package net.example.global.Controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import net.example.global.Model.Pais;
import net.example.global.R;

import java.util.ArrayList;

public class PaisAdapter extends BaseAdapter {

    Context context;
    ArrayList<Pais> paises;

    public PaisAdapter(Context context, ArrayList<Pais> paises)
    {
        this.context = context;
        this.paises = paises;
    }

    @Override
    public int getCount() {
        return paises.size();
    }

    @Override
    public Object getItem(int position) {
        return paises.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
       if(convertView == null)
       {
           LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
           convertView = layoutInflater.inflate(R.layout.elemento_grid, null);
       }

       ImageView imagen_pais = convertView.findViewById(R.id.icon_pais);
       TextView nombre_pais = (TextView) convertView.findViewById(R.id.nombre_pais);

       Pais selectedPais = paises.get(position);

       imagen_pais.setImageDrawable(selectedPais.getImagen());
       nombre_pais.setText(selectedPais.getNombre());


       return convertView;
    }


}
