package com.fernandopaiva_larissamoreira.appn1.randomizador;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fernandopaiva_larissamoreira.appn1.R;

import java.util.List;

/**
 * Adapter para o RecyclerView do Randomizador.
 */
public class RandomizadorAdapter extends RecyclerView.Adapter<RandomizadorAdapter.ViewHolder> {

    private final List<String> items;

    public RandomizadorAdapter(List<String> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_randomizador, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String item = items.get(position);
        holder.txtItem.setText(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtItem;

        ViewHolder(View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.txtItem);
        }
    }
}
