package com.fernandopaiva_larissamoreira.appn1.core;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;

import com.fernandopaiva_larissamoreira.appn1.R;
import com.fernandopaiva_larissamoreira.appn1.codificador.CodificadorActivity;
import com.fernandopaiva_larissamoreira.appn1.codigo_secreto.CodigoSecretoActivity;
import com.fernandopaiva_larissamoreira.appn1.pedra_papel_tesoura.PedraPapelTesouraActivity;
import com.fernandopaiva_larissamoreira.appn1.randomizador.RandomizadorActivity;

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnCodificador = findViewById(R.id.btnCodificador);
        btnCodificador.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, CodificadorActivity.class);
            startActivity(intent);
        });

        Button btnPedraPapelTesoura = findViewById(R.id.btnPedraPapelTesoura);
        btnPedraPapelTesoura.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, PedraPapelTesouraActivity.class);
            startActivity(intent);
        });

        Button btnCodigoSecreto = findViewById(R.id.btnCodigoSecreto);
        btnCodigoSecreto.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, CodigoSecretoActivity.class);
            startActivity(intent);
        });

        Button btnRandomizador = findViewById(R.id.btnRandomizador);
        btnRandomizador.setOnClickListener(v -> {
            Intent intent = new Intent(SecondActivity.this, RandomizadorActivity.class);
            startActivity(intent);
        });

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(v -> {
            finish();
        });
    }
}
