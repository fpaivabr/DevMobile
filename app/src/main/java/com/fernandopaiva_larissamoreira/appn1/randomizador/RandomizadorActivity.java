package com.fernandopaiva_larissamoreira.appn1.randomizador;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.fernandopaiva_larissamoreira.appn1.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Activity para o Randomizador, que sorteia um item de uma lista.
 */
public class RandomizadorActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RandomizadorAdapter adapter;
    private List<String> items;
    private EditText edtItem;
    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randomizador);

        recyclerView = findViewById(R.id.recyclerView);
        edtItem = findViewById(R.id.edtItem);
        txtResultado = findViewById(R.id.txtResultado);
        Button btnAdicionar = findViewById(R.id.btnAdicionar);
        Button btnSortear = findViewById(R.id.btnSortear);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        items = new ArrayList<>();
        adapter = new RandomizadorAdapter(items);
        recyclerView.setAdapter(adapter);

        btnAdicionar.setOnClickListener(v -> {
            String item = edtItem.getText().toString();
            if (!item.isEmpty()) {
                items.add(item);
                adapter.notifyDataSetChanged();
                edtItem.setText("");
            }
        });

        btnSortear.setOnClickListener(v -> {
            if (!items.isEmpty()) {
                Random random = new Random();
                String resultado = items.get(random.nextInt(items.size()));
                txtResultado.setText("Resultado: " + resultado);
            }
        });

        btnVoltar.setOnClickListener(v -> finish());
    }
}
