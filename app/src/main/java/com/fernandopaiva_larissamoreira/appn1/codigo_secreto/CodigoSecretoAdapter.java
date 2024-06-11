package com.fernandopaiva_larissamoreira.appn1.codigo_secreto;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandopaiva_larissamoreira.appn1.R;

import java.util.List;

/**
 * Adapter para o RecyclerView que exibe as tentativas do código secreto.
 */
public class CodigoSecretoAdapter extends RecyclerView.Adapter<CodigoSecretoAdapter.ViewHolder> {

    private final List<int[]> tentativas;

    public CodigoSecretoAdapter(List<int[]> tentativas) {
        this.tentativas = tentativas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tentativa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int[] tentativa = tentativas.get(position);
        holder.txtTentativa.setText(arrayToString(tentativa));
    }

    @Override
    public int getItemCount() {
        return tentativas.size();
    }

    /**
     * ViewHolder para o adapter.
     */
    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTentativa;

        ViewHolder(View itemView) {
            super(itemView);
            txtTentativa = itemView.findViewById(R.id.txtTentativa);
        }
    }

    /**
     * Converte um array de inteiros para uma string formatada.
     *
     * @param array O array de inteiros.
     * @return A string formatada.
     */
    private String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}
