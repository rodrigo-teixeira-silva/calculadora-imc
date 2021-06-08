package com.example.calculadoradeimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public EditText Peso;
    public EditText Altura;
    public Button Bt_calcular;
    public TextView Resultado;
    public Object view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Peso = (EditText) findViewById(R.id.editPeso);
        Altura = (EditText) findViewById(R.id.editAltura);
        Bt_calcular = (Button) findViewById(R.id.Bt_calcular);
        Resultado = (TextView) findViewById(R.id.Resultado);

        Bt_calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Resultado.setText("");
                int peso = Integer.parseInt(Peso.getText().toString());
                float altura = Float.parseFloat(Altura.getText().toString());
                float resultado = peso / (altura * altura);
                String toastResultado = String.valueOf(resultado);


                if(resultado <= 18) {
                    Resultado.setText("Peso normal ");
                    Toast.makeText(getBaseContext(), toastResultado, Toast.LENGTH_LONG).show();
                    } else if(resultado <= 26) {
                            Resultado.setText("Obesidade grau 1 ");
                            Toast.makeText(getBaseContext(), toastResultado, Toast.LENGTH_LONG).show();
                    } else if(resultado <= 35) {
                        Resultado.setText("Obesidade grau 2");
                        Toast.makeText(getBaseContext(), toastResultado, Toast.LENGTH_LONG).show();
                    }else {
                        Resultado.setText("Obesidade grau 3");
                        Toast.makeText(getBaseContext(), toastResultado, Toast.LENGTH_LONG).show();
                    }


            }
        });
    }
}