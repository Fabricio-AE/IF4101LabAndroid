package com.fabricioae.labandroidpokedex.models;

public class InfoPokemon {

    private int id, height, weight;
    private String name;

    public InfoPokemon(int id, int height, int weight, String name) {
        this.id = id;
        this.height = height;
        this.weight = weight;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
