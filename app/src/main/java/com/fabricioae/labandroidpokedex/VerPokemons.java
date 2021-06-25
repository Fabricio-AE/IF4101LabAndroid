package com.fabricioae.labandroidpokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fabricioae.labandroidpokedex.adapters.ListaPokemonsAdapter;
import com.fabricioae.labandroidpokedex.adapters.RetrofitAdapter;
import com.fabricioae.labandroidpokedex.models.Pokemon;
import com.fabricioae.labandroidpokedex.models.Respuesta;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerPokemons extends AppCompatActivity {

    private RecyclerView rvPokemons;
    private ListaPokemonsAdapter adapter;
    private Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pokemons);
        this.rvPokemons = findViewById(R.id.lista_pokemons);
        this.adapter = new ListaPokemonsAdapter(this);
        this.rvPokemons.setLayoutManager(new LinearLayoutManager(this));
        this.rvPokemons.setAdapter(this.adapter);

        RetrofitAdapter retrofitAdapter = RetrofitAdapter.getInstance();
        this.retrofit = retrofitAdapter.getRetrofit();
        this.obtenerPokemons();
    }

    public void obtenerPokemons(){


        PokeapiService service = retrofit.create(PokeapiService.class);

        Call<Respuesta> call = service.getPokemons();

        call.enqueue(new Callback<Respuesta>() {
            @Override
            public void onResponse(Call<Respuesta> call, Response<Respuesta> response) {
                if (!response.isSuccessful()){
                    System.out.println("Error");
                    return;
                }
                Respuesta respuesta = response.body();
                adapter.setPokemons(respuesta.getResults());

            }

            @Override
            public void onFailure(Call<Respuesta> call, Throwable t) {

            }
        });
    }

}