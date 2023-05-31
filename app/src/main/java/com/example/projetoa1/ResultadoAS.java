package com.example.projetoa1;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultadoAS extends AppCompatActivity {

    private TextView textNomeAS, textMediaAS, textSituAS;

    private String nomeAluno;
    private double novaMedia;
    private String situ;
    private Button buttonVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_as);

        textNomeAS = findViewById(R.id.textNomeAS);
        textMediaAS = findViewById(R.id.textMediaAS);
        textSituAS = findViewById(R.id.textSituAS);
        buttonVoltar = findViewById(R.id.buttonVoltar);

        Intent intent = getIntent();
        nomeAluno = intent.getStringExtra("nomeAluno");
        novaMedia = intent.getDoubleExtra("novaMedia", 0.0);
        situ = intent.getStringExtra("situ");

        textNomeAS.setText(nomeAluno);
        textMediaAS.setText(String.format("%.2f", novaMedia));
        textSituAS.setText(situ);

        buttonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

}