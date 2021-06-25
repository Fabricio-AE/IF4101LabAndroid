package com.fabricioae.labandroidpokedex.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fabricioae.labandroidpokedex.R;
import com.fabricioae.labandroidpokedex.models.Result;

import java.util.List;

public class ListaPokemonsAdapter extends RecyclerView.Adapter<ItemPokemonViewHolder> {

    private List<Result> listaResults;
    private Context context;

    public ListaPokemonsAdapter(List<Result> listaResults, Context context) {
        this.listaResults = listaResults;
        this.context = context;
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
        final Result result = this.listaResults.get(position);
        holder.nombrePokemon.setText(result.getName());
        switch (result.getName()){
            case "bulbasaur":
                holder.iconoPokemon.setBackgroundResource(R.mipmap.ic_bulbasaur_layer);
                break;
            case "ivasaur":
                holder.iconoPokemon.setBackgroundResource(R.mipmap.ic_bulbasaur_layer);
                break;
            case "venusaur":
                holder.iconoPokemon.setBackgroundResource(R.mipmap.ic_bulbasaur);
                break;
            case "charmander":
                holder.iconoPokemon.setBackgroundResource(R.mipmap.ic_bulbasaur);
                break;
            case "charmeleon":
                holder.iconoPokemon.setBackgroundResource(R.mipmap.ic_bulbasaur);
                break;
        }


    }

    @Override
    public int getItemCount() {return this.listaResults.size();}
}
