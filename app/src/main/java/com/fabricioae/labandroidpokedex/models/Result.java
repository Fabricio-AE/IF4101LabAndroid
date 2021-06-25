package com.fabricioae.labandroidpokedex.models;

public class Result {
    public String name;
    public String url;

    public Result(String name, String url){
        this.name = name;
        this.url = url;
    }//constructor

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}//end class
