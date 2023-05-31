package com.example.projetoa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button btnCalcular;
    EditText txtValorNome, txtValorA1, txtValorA2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorNome = findViewById(R.id.txtValorNome);
        txtValorA1 =  findViewById(R.id.txtValorA1);
        txtValorA2 =  findViewById(R.id.txtValorA2);
        btnCalcular = findViewById(R.id.btnCalcular);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nomeAluno = txtValorNome.getText().toString();
                double notaA1 = Double.parseDouble(txtValorA1.getText().toString());
                double notaA2 = Double.parseDouble(txtValorA2.getText().toString());

                double media = (notaA1 + notaA2) / 2;

                Intent intent = new Intent(MainActivity.this, ResultadoMedia1.class);
                intent.putExtra("nomeAluno", nomeAluno);
                intent.putExtra("media", media);

                if (media >= 6) {
                    intent.putExtra("situ", "Aprovado");
                } else if (media >= 4) {
                    intent.putExtra("situ", "AS");
                } else {
                    intent.putExtra("situ", "Reprovado");
                }

                startActivity(intent);
                limparCampos(); //chama o método para realizar a limpeza dos dados
            }
        });

    }
    //irá limpar os dados previamente digitados, pensando que o usuário poderá fazer outra consulta ao voltar para o menu principal:
    private void limparCampos() {
        txtValorNome.setText("");
        txtValorA1.setText("");
        txtValorA2.setText("");
    }
}

