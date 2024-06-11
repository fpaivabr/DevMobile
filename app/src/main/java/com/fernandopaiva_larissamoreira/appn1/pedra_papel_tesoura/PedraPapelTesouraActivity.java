package com.fernandopaiva_larissamoreira.appn1.pedra_papel_tesoura;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.fernandopaiva_larissamoreira.appn1.R;

import java.util.Random;

/**
 * Activity para o jogo de Pedra, Papel e Tesoura.
 */
public class PedraPapelTesouraActivity extends AppCompatActivity {

    private ImageView imgEscolhaApp;
    private TextView txtResultado;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pedra_papel_tesoura);

        imgEscolhaApp = findViewById(R.id.imgEscolhaApp);
        txtResultado = findViewById(R.id.txtResultado);
        random = new Random();

        ImageView btnPedra = findViewById(R.id.btnPedra);
        ImageView btnPapel = findViewById(R.id.btnPapel);
        ImageView btnTesoura = findViewById(R.id.btnTesoura);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnPedra.setOnClickListener(v -> jogar("pedra"));
        btnPapel.setOnClickListener(v -> jogar("papel"));
        btnTesoura.setOnClickListener(v -> jogar("tesoura"));

        btnVoltar.setOnClickListener(v -> finish());
    }

    /**
     * Método para realizar a jogada do usuário e determinar o resultado.
     *
     * @param escolhaUsuario A escolha do usuário (pedra, papel ou tesoura).
     */
    private void jogar(String escolhaUsuario) {
        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[random.nextInt(3)];

        int resId = getResources().getIdentifier("ic_" + escolhaApp, "drawable", getPackageName());
        imgEscolhaApp.setImageResource(resId);

        if (escolhaUsuario.equals(escolhaApp)) {
            txtResultado.setText("Empate!");
        } else if ((escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra")) ||
                (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))) {
            txtResultado.setText("Você ganhou :)");
        } else {
            txtResultado.setText("Você perdeu :(");
        }
    }
}
