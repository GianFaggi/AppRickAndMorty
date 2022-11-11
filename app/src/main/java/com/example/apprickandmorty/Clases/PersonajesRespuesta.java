package com.example.apprickandmorty.Clases;

import java.util.ArrayList;

public class PersonajesRespuesta {

    private ArrayList<Personaje> results;
    private String pages;

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public ArrayList<Personaje> getResults() {
        return results;
    }

    public void setResults(ArrayList<Personaje> results) {
        this.results = results;
    }
}
