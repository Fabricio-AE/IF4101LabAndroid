package com.fabricioae.labandroidpokedex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.fabricioae.labandroidpokedex.adapters.RetrofitAdapter;
import com.fabricioae.labandroidpokedex.models.InfoPokemon;
import com.fabricioae.labandroidpokedex.models.Pokemon;
import com.fabricioae.labandroidpokedex.models.Respuesta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class InformacionPokemon extends AppCompatActivity {

    private ImageView ivPokemon;
    private TextView tvNombrePokemon, tvMedidasPokemon, tvNumeroPokemon;
    private Retrofit retrofit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_pokemon);

        ivPokemon = findViewById(R.id.ivPokemon);
        tvNombrePokemon = findViewById(R.id.tvNombrePokemon);
        tvMedidasPokemon = findViewById(R.id.tvMedidasPokemon);
        tvNumeroPokemon = findViewById(R.id.tvNumeroPokemon);

        RetrofitAdapter retrofitAdapter = RetrofitAdapter.getInstance();
        this.retrofit = retrofitAdapter.getRetrofit();
        String valor = getIntent().getStringExtra("name");

        this.obtenerInformacion(valor);
        String id = getIntent().getStringExtra("id");
        Glide.with(this).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+id+".png").override(600, 600).into(ivPokemon);
    }

    public void obtenerInformacion(String name){

        PokeapiService service = retrofit.create(PokeapiService.class);
        System.out.println(name);
        Call<InfoPokemon> call = service.getPokemon(name);

        call.enqueue(new Callback<InfoPokemon>() {
            @Override
            public void onResponse(Call<InfoPokemon> call, Response<InfoPokemon> response) {
                if (!response.isSuccessful()){
                    System.out.println("Error");
                    return;
                }
                InfoPokemon pokemon = response.body();
                String id = "Número en la pokedex: "+pokemon.getId();
                float altura = (float) pokemon.getHeight()/10;
                float peso = (float)pokemon.getWeight()/10;
                String medidas = "Alto: "+altura+"m\n Peso: " + peso+" kg";

                tvNombrePokemon.setText(pokemon.getName());
                tvMedidasPokemon.setText(medidas);
                tvNumeroPokemon.setText(id);
            }

            @Override
            public void onFailure(Call<InfoPokemon> call, Throwable t) {

            }
        });
    }

}