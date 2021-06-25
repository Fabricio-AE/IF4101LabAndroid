package com.fabricioae.labandroidpokedex.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Respuesta {
    ArrayList<Pokemon> results;

    public Respuesta() {
        this.results = new ArrayList<>();
    }

    public ArrayList<Pokemon> getResults() {
        return results;
    }

    public void setResults(ArrayList<Pokemon> results) {
        this.results = results;
    }
}//end class
