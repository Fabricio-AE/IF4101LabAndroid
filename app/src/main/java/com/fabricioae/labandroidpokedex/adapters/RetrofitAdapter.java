package com.fabricioae.labandroidpokedex.adapters;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitAdapter {
    private static RetrofitAdapter instance = null;
    private Retrofit retrofit;

    private RetrofitAdapter(){
        this.retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }//retrofitAdapter

    public static RetrofitAdapter getInstance(){
        if(instance == null)
            instance = new RetrofitAdapter();
        return instance;
    }//getInstance

    public Retrofit getRetrofit() {
        return retrofit;
    }

    public void setRetrofit(Retrofit retrofit) {
        this.retrofit = retrofit;
    }
}
