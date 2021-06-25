package com.fabricioae.labandroidpokedex.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fabricioae.labandroidpokedex.InformacionPokemon;
import com.fabricioae.labandroidpokedex.R;
import com.fabricioae.labandroidpokedex.VerPokemons;
import com.fabricioae.labandroidpokedex.models.Pokemon;
import com.fabricioae.labandroidpokedex.models.Respuesta;

import java.util.ArrayList;

public class ListaPokemonsAdapter extends RecyclerView.Adapter<ItemPokemonViewHolder> {

    private ArrayList<Pokemon> pokemons;
    private Context context;

    public ListaPokemonsAdapter(Context context) {
        this.pokemons = new ArrayList<>();
        this.context = context;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(ArrayList<Pokemon> pokemons) {
        this.pokemons.addAll(pokemons);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemPokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemLista = inflater.inflate(R.layout.item_pokemon, parent, false);
        ItemPokemonViewHolder viewHolder = new ItemPokemonViewHolder(itemLista);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPokemonViewHolder holder, int position) {
        final Pokemon respuesta = this.pokemons.get(position);
        holder.nombrePokemon.setText(respuesta.getName());

        holder.btnPokemon.setOnClickListener(view -> {
            Intent intentInformacionPokemon = new Intent(context.getApplicationContext(), InformacionPokemon.class);
            intentInformacionPokemon.putExtra("id", respuesta.getId());
            intentInformacionPokemon.putExtra("name", respuesta.getName());
            context.startActivity(intentInformacionPokemon);
        });
    }

    @Override
    public int getItemCount() {return this.pokemons.size();}
}
