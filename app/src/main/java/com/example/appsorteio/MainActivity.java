package com.example.appsorteio;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.textfield.TextInputEditText;
import org.w3c.dom.Text;

import java.util.Random;

import static java.lang.Math.random;

public class MainActivity extends AppCompatActivity {

    private Button btn_Sorteia;
    private TextView tx_Resultado, ed_ValoFina, ed_ValoInic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_Sorteia = (Button) findViewById(R.id.bt_Sortear);
        tx_Resultado = (TextView) findViewById(R.id.tx_Resultado);
        ed_ValoFina = (TextView) findViewById(R.id.ed_ValoFina);
        ed_ValoInic = (TextView) findViewById(R.id.ed_ValoInic);

        btn_Sorteia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String valorInicialStr = ed_ValoInic.getText().toString();
                String valorFinalStr = ed_ValoFina.getText().toString();

                try {
                    int valorInicial = Integer.parseInt(valorInicialStr);
                    int valorFinal = Integer.parseInt(valorFinalStr);

                    // Cria um número aleatório entre valorInicial e valorFinal
                    int resultado = new Random().nextInt(valorFinal - valorInicial + 1) + valorInicial;

                    // Exibe o resultado na TextView
                    tx_Resultado.setText(String.valueOf(resultado));
                } catch (NumberFormatException e) {
                    // Trate a exceção se os valores não puderem ser convertidos para inteiros
                    tx_Resultado.setText("Erro: Insira valores válidos.");
                }
            }
        });

    }


}