package com.fernandopaiva_larissamoreira.appn1.codigo_secreto;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

import com.fernandopaiva_larissamoreira.appn1.core.ObservadorTextoSimples;
import com.fernandopaiva_larissamoreira.appn1.R;

import java.util.ArrayList;
import java.util.List;

public class CodigoSecretoActivity extends AppCompatActivity {

    private EditText etDigito1, etDigito2, etDigito3, etDigito4;
    private Button btnTentar, btnVoltar;
    private final int[] codigoSecreto = {1, 2, 3, 4};
    private final List<int[]> tentativas = new ArrayList<>();
    private int numeroTentativas = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_secreto);

        etDigito1 = findViewById(R.id.etDigito1);
        etDigito2 = findViewById(R.id.etDigito2);
        etDigito3 = findViewById(R.id.etDigito3);
        etDigito4 = findViewById(R.id.etDigito4);
        btnTentar = findViewById(R.id.btnTentar);
        btnVoltar = findViewById(R.id.btnVoltar);

        btnTentar.setOnClickListener(v -> verificarCodigo());

        btnVoltar.setOnClickListener(v -> finish());

        // Passar para o próximo EditText automaticamente
        etDigito1.addTextChangedListener(new ObservadorTextoSimples(etDigito2));
        etDigito2.addTextChangedListener(new ObservadorTextoSimples(etDigito3));
        etDigito3.addTextChangedListener(new ObservadorTextoSimples(etDigito4));
    }

    private void verificarCodigo() {
        int[] tentativaAtual = new int[4];
        tentativaAtual[0] = Integer.parseInt(etDigito1.getText().toString());
        tentativaAtual[1] = Integer.parseInt(etDigito2.getText().toString());
        tentativaAtual[2] = Integer.parseInt(etDigito3.getText().toString());
        tentativaAtual[3] = Integer.parseInt(etDigito4.getText().toString());

        tentativas.add(tentativaAtual);
        numeroTentativas++;

        boolean acertouTudo = true;

        for (int i = 0; i < 4; i++) {
            if (tentativaAtual[i] == codigoSecreto[i]) {
                getEditText(i).setBackgroundColor(Color.parseColor("#8BC34A"));
                getEditText(i).setTextColor(Color.WHITE);
            } else {
                getEditText(i).setBackgroundColor(Color.parseColor("#FFCDD2"));
                getEditText(i).setTextColor(Color.WHITE);
                acertouTudo = false;
            }
        }

        if (acertouTudo) {
            btnTentar.setEnabled(false);
            new Handler().postDelayed(() -> {
                Intent intent = new Intent(this, CodigoSecretoResultadoActivity.class);
                intent.putExtra("tentativas", numeroTentativas);
                intent.putExtra("tentativasLista", new ArrayList<>(tentativas));
                startActivity(intent);
                finish();
            }, 1500);
        } else {
            btnTentar.setEnabled(false);
            new Handler().postDelayed(() -> {
                for (int i = 0; i < 4; i++) {
                    getEditText(i).setBackgroundColor(Color.WHITE);
                    getEditText(i).setTextColor(Color.BLACK);
                    getEditText(i).setText("");
                }
                etDigito1.requestFocus();
                btnTentar.setText("Tentar novamente");
                btnTentar.setEnabled(true);
            }, 1500);
        }
    }

    private EditText getEditText(int index) {
        switch (index) {
            case 0:
                return etDigito1;
            case 1:
                return etDigito2;
            case 2:
                return etDigito3;
            case 3:
                return etDigito4;
            default:
                throw new IllegalArgumentException("Index inválido");
        }
    }
}
