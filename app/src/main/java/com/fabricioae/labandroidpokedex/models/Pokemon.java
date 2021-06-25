package com.fabricioae.labandroidpokedex.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pokemon {

    public String name;
    public String url;
    public String id;

    public Pokemon(String name, String url){
        this.name = name;
        this.url = url;
    }//constructor

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        String str[] = this.url.split("/");
        this.id = str[str.length-1];
        return id;
    }

}
