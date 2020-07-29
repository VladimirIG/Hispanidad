package net.example.global.Controller;

import android.app.Activity;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import net.example.global.Model.Politico;
import net.example.global.R;

import java.util.ArrayList;


public class PoliticoAdapter extends BaseAdapter {
    Activity context;
    ArrayList<Politico> politicos;
    private static LayoutInflater inflater = null;

    public PoliticoAdapter(Activity context, ArrayList<Politico> politicos){
        this.context = context;
        this.politicos = politicos;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return politicos.size();
    }

    @Override
    public Object getItem(int position) {
        return politicos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null)? inflater.inflate(R.layout.elemento_lista,null):itemView;

        TextView nombre = itemView.findViewById(R.id.nombre);
        TextView partido = itemView.findViewById(R.id.partido);
        LinearLayout fondo = itemView.findViewById(R.id.fondo);
        ImageView icon = itemView.findViewById(R.id.icon);

        Politico selectedPolitico = politicos.get(position);

        nombre.setText(selectedPolitico.getNombre());
        partido.setText(selectedPolitico.getPartido());
        partido.setBackground(selectedPolitico.getColorBg());
        icon.setImageDrawable(selectedPolitico.getImagen());

        return itemView;
    }
}
