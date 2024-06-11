package com.fernandopaiva_larissamoreira.appn1.core;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class ObservadorTextoSimples implements TextWatcher {

    private final EditText proximoEditText;

    public ObservadorTextoSimples(EditText proximoEditText) {
        this.proximoEditText = proximoEditText;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (s.length() == 1) {
            proximoEditText.requestFocus();
        }
    }

    @Override
    public void afterTextChanged(Editable s) {}
}
