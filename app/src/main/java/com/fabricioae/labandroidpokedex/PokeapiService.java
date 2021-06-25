package com.fabricioae.labandroidpokedex;

import com.fabricioae.labandroidpokedex.models.InfoPokemon;
import com.fabricioae.labandroidpokedex.models.Pokemon;
import com.fabricioae.labandroidpokedex.models.Respuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeapiService {

        @GET("pokemon/?limit=50")
        Call<Respuesta> getPokemons();

        @GET("pokemon/{name}")
        Call<InfoPokemon> getPokemon(@Path("name") String name);

}
