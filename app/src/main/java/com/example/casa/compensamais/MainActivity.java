package com.example.casa.compensamais;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private EditText qtde1;
    private EditText valor1;
    private EditText qtde2;
    private EditText valor2;
    private Button button;
    private TextView resposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

                qtde1 = (EditText) findViewById(R.id.qtde1);
                valor1 = (EditText)findViewById(R.id.valor1);

                qtde2 = (EditText)findViewById(R.id.qtde2);
                valor2 = (EditText)findViewById(R.id.valor2);

                resposta = (TextView) findViewById(R.id.resultado);

                Produto p1 = new Produto();
                p1.setQtde( Integer.parseInt( qtde1.getText().toString() ) );
                p1.setValor( Float.valueOf( valor1.getText().toString() ) );

                Produto p2 = new Produto();
                p2.setQtde( Integer.parseInt( qtde2.getText().toString() ) );
                p2.setValor( Float.valueOf( valor2.getText().toString() ) );

                resposta.setText(calcular(p1, p2));

                TextView edtTexto = (TextView) findViewById(R.id.resultado);
                //Intent intent = new Intent(MainActivity.this, Resultado.class);

                //String txt = "";
                //txt = edtTexto.getText().toString();
                /*Bundle bundle = new Bundle();

                bundle.putString("resposta", calcular(p1, p2).toString());
                intent.putExtras(bundle);

                startActivity(intent);*/
            }
        });

    }

    public StringBuilder calcular (Produto p1, Produto p2) {
        StringBuilder resp = new StringBuilder();
        float custoUnitario1 = p1.getValor() / p1.getQtde();
        float custoUnitario2 = p2.getValor() / p2.getQtde();
        DecimalFormat decimal = new DecimalFormat("0.00");

        if ( custoUnitario1 < custoUnitario2 ) {
            resp.append("Leve a opção com ");
            resp.append(p1.getQtde());
            resp.append(". \n");
            resp.append("Cada item sai ao custo de: R$ ");
            resp.append(decimal.format(custoUnitario1));
            resp.append("\n");
            resp.append("Enquanto comprando ");
            resp.append(p2.getQtde());
            resp.append(" sairia por: R$ ");
            resp.append(decimal.format(custoUnitario2));
        }
        else if ( custoUnitario1 > custoUnitario2 ) {
            resp.append("Compensa comprar mais. \n");
            resp.append("Levando ");
            resp.append(p2.getQtde());
            resp.append(" Cada um sai ao custo de: R$ ");
            resp.append(decimal.format(custoUnitario2));
        }
        else {
            resp.append("Valores iguais. Veja se vale a pena comprar tudo de uma vez.");
        }

        return resp;
    }
}
