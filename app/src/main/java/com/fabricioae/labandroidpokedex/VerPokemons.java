package com.fabricioae.labandroidpokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.fabricioae.labandroidpokedex.adapters.ListaPokemonsAdapter;
import com.fabricioae.labandroidpokedex.models.Pokemons;
import com.fabricioae.labandroidpokedex.models.Result;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class VerPokemons extends AppCompatActivity {

    private RecyclerView rvPokemons;
    //private Result result;
    private List<Pokemons> results = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_pokemons);

        this.rvPokemons = findViewById(R.id.lista_pokemons);
        this.obtenerPokemons();
        //ListaPokemonsAdapter adapter = new ListaPokemonsAdapter(this.results, this);

        //this.rvPokemons.setLayoutManager(new LinearLayoutManager(this));
        //this.rvPokemons.setAdapter(adapter);
    }

    public void/*List<Result>*/ obtenerPokemons(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<Pokemons>> call = service.getPokemons();
        System.out.println("hola ");
        try {
            Response<List<Pokemons>> respons = call.execute();
            System.out.println(respons.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        call.enqueue(new Callback<List<Pokemons>>() {
            @Override
            public void onResponse(Call<List<Pokemons>> call, Response<List<Pokemons>> response) {
                System.out.println("hola222222222222222222222222");
                System.out.println("Respuesta: "+ response.code());
                if (!response.isSuccessful()){
                    System.out.println("Respuesta: "+ response.code());
                    return;
                }
                //System.out.println("Respuesta: "+ response.code());
                List<Pokemons> pokemonsList = response.body();
                System.out.println("hola222222222222222222222222");
                for (Pokemons pokemons : pokemonsList) {
                    System.out.println(pokemons.getNext());
                    //results.add(new Result(pokemons.getName(), result.url));
                }

            }

            @Override
            public void onFailure(Call<List<Pokemons>> call, Throwable t) {

            }
        });

/*
        List<Result> lista = new ArrayList<>();
        lista.add(new Result("bulbasaur", "jaja"));
        lista.add(new Result("Charizard", "jaja"));
        lista.add(new Result("Charizard", "jaja"));
        lista.add(new Result("Charizard", "jaja"));
        lista.add(new Result("Charizard", "jaja"));
        lista.add(new Result("Charizard", "jaja"));
        lista.add(new Result("Charizard", "jaja"));
        lista.add(new Result("Charizard", "jaja"));

        return lista;*/
    }

}