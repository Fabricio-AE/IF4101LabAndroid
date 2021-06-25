package com.fabricioae.labandroidpokedex;

import com.fabricioae.labandroidpokedex.models.Pokemons;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GitHubService {

        @GET("api/v2/pokemon/?limit=8")
        Call<List<Pokemons>> getPokemons();

}
