package com.fernandopaiva_larissamoreira.appn1.codigo_secreto;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandopaiva_larissamoreira.appn1.R;

import java.util.ArrayList;

/**
 * CodigoSecretoResultadoActivity exibe o resultado do jogo de código secreto,
 * incluindo o número de tentativas e uma lista de todas as tentativas feitas.
 */
public class CodigoSecretoResultadoActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private CodigoSecretoAdapter adapter;
    private ArrayList<int[]> tentativas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codigo_secreto_resultado);

        // Recuperar dados das tentativas
        tentativas = (ArrayList<int[]>) getIntent().getSerializableExtra("tentativas");

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CodigoSecretoAdapter(tentativas);
        recyclerView.setAdapter(adapter);

        findViewById(R.id.btnVoltar).setOnClickListener(v -> finish());
    }
}
