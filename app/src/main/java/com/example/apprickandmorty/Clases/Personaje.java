package com.example.apprickandmorty.Clases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.annotations.SerializedName;

public class Personaje {
    public String id;
    public String name;
    public String status;
    public String gender;
    public String species;
    public String image;
    private String number;
    @SerializedName("origin")
    private  origin origin;
    @SerializedName("location")
    private  location location;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getGender(){return gender;}
    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSpecies() {
        return species;
    }
    public void setSpecies(String species) {
        this.species = species;
    }

    public String getSpecie() {
        return species;
    }
    public void setSpecie(String specie) {
        this.species = specie;
    }

    public String getName() {return name;    }
    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getNumber(){
        String[] urlPartes = image.split("/");
        return urlPartes[urlPartes.length - 1];
    }
    public void setNumber(String number) {
        this.number = number;
    }

    public origin getOrigin() {
        return origin;
    }
    public void setOrigin(origin origin)
{
    this.origin = origin;
}

    public void setLocation(location location)
    {
        this.location = location;
    }
    public location getlocation() {
        return location;
    }

    public static origin parseJSON(String response){
        Gson gson = new GsonBuilder().create();
        origin origin = gson.fromJson(response,origin.class);
        return origin;
    }

    public static location parseJSON2(String response){
        Gson gson = new GsonBuilder().create();
        location location = gson.fromJson(response,location.class);
        return location;
    }

}