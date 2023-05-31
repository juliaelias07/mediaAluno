package com.example.projetoa1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ResultadoMedia1 extends AppCompatActivity {

    private TextView textNome, textMedia, textSitu, textDigite;
    private EditText notaAS;
    private Button buttonAS, buttonVoltar2;

    private String nomeAluno;
    private double media;
    private String situ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_media1);

        textNome = findViewById(R.id.textNome);
        textMedia = findViewById(R.id.textMedia);
        textDigite = findViewById(R.id.textDigite);
        textSitu = findViewById(R.id.textSitu);
        notaAS = findViewById(R.id.notaAS);
        buttonAS = findViewById(R.id.buttonAS);
        buttonVoltar2 = findViewById(R.id.buttonVoltar2);

        Intent intent = getIntent();
        nomeAluno = intent.getStringExtra("nomeAluno");
        media = intent.getDoubleExtra("media", 0.0);
        situ = intent.getStringExtra("situ");

        textNome.setText(nomeAluno);
        textMedia.setText(String.format("%.2f", media));
        textSitu.setText(situ);

        if(situ.equals("AS")){
            textDigite.setVisibility(View.VISIBLE);
            notaAS.setVisibility(View.VISIBLE);
            buttonAS.setVisibility(View.VISIBLE);
            buttonVoltar2.setVisibility(View.INVISIBLE);

            buttonAS.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    double AS = Double.parseDouble(notaAS.getText().toString());
                    double novaMedia = (media + AS) / 2;
                    textMedia.setText(String.format("%.2f", novaMedia));

                    Intent intent = new Intent(ResultadoMedia1.this, ResultadoAS.class);
                    intent.putExtra("nomeAluno", nomeAluno);
                    intent.putExtra("novaMedia", novaMedia);
                    intent.putExtra("situ", situ);

                    if (novaMedia >= 6) {
                        textSitu.setText("Aprovado");
                        intent.putExtra("situ", "Aprovado");

                    } else {
                        textSitu.setText("Reprovado");
                        intent.putExtra("situ", "Reprovado");
                    }
                    textDigite.setVisibility(View.INVISIBLE);
                    notaAS.setVisibility(View.INVISIBLE);
                    buttonAS.setVisibility(View.INVISIBLE);
                    buttonVoltar2.setVisibility(View.VISIBLE);

                    buttonVoltar2.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            finish();
                        }
                    });
                    startActivity(intent);
                }
            });
        } else{
            buttonVoltar2.setVisibility(View.VISIBLE);
            buttonVoltar2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}