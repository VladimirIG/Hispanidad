package net.example.global.Activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import net.example.global.R;

public class ComoJugar extends Activity {
    Button btn_Atras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comojugar);
    }

}
