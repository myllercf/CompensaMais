package com.example.casa.compensamais;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by casa on 26/11/2016.
 */

public class Resultado extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        String texto = bundle.getString("resposta");
        TextView resultado = (TextView) findViewById(R.id.resultado2);
        resultado.setText(texto);
    }
}
