package com.fabricioae.labandroidpokedex.adapters;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fabricioae.labandroidpokedex.R;

public class ItemPokemonViewHolder extends RecyclerView.ViewHolder {

    ImageView iconoPokemon;
    TextView nombrePokemon;
    Button btnPokemon;

    public ItemPokemonViewHolder(@NonNull View itemView) {
        super(itemView);
        iconoPokemon = itemView.findViewById(R.id.icono_item);
        nombrePokemon = itemView.findViewById(R.id.nombre_item);
        btnPokemon = itemView.findViewById(R.id.btn_item);
    }
}
