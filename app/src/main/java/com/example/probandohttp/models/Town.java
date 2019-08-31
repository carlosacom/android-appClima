package com.example.probandohttp.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

public class Town {

    public String id;
    public List<City> cities;

    public Town() { }

    public Town(String id, List<City> cities) {
        this.id = id;
        this.cities = cities;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public static City parseJSON(String response) {
        Gson gson = new GsonBuilder().create();
        City city = gson.fromJson(response, City.class);
        return city;
    }

}
