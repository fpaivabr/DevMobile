package com.fernandopaiva_larissamoreira.appn1.codificador;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.fernandopaiva_larissamoreira.appn1.R;

/**
 * CodificadorActivity é responsável por codificar e decodificar mensagens usando a cifra de César.
 */
public class CodificadorActivity extends AppCompatActivity {
    private boolean isCodificado = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_codificador);

        EditText editTextInput = findViewById(R.id.editTextInput);
        Button btnCodificar = findViewById(R.id.btnCodificar);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        btnCodificar.setOnClickListener(v -> {
            String input = editTextInput.getText().toString();
            if (isCodificado) {
                String decodificado = decodificar(input, 12);
                editTextInput.setText(decodificado);
                btnCodificar.setText("Codificar");
            } else {
                String codificado = codificar(input, 12);
                editTextInput.setText(codificado);
                btnCodificar.setText("Decodificar");
            }
            isCodificado = !isCodificado;
        });

        btnVoltar.setOnClickListener(v -> finish());
    }

    /**
     * Codifica uma string usando a cifra de César.
     *
     * @param input A string a ser codificada.
     * @param shift O número de posições a serem deslocadas na cifra.
     * @return A string codificada.
     */
    private String codificar(String input, int shift) {
        StringBuilder result = new StringBuilder();
        for (char character : input.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                result.append((char) (((character - base + shift) % 26) + base));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    /**
     * Decodifica uma string usando a cifra de César.
     *
     * @param input A string a ser decodificada.
     * @param shift O número de posições a serem deslocadas na cifra.
     * @return A string decodificada.
     */
    private String decodificar(String input, int shift) {
        return codificar(input, 26 - shift);
    }
}
