package com.example.apprickandmorty.Services;


import com.example.apprickandmorty.Clases.Personaje;
import com.example.apprickandmorty.Clases.PersonajesRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Url;


public interface ApiService {
        @GET("character?page=3")
        Call<PersonajesRespuesta> getAllNames(@Path("pagina")int id);

        @GET("character/{id}")
        Call<Personaje> getPostById(@Path("id") int postId);

        @GET
        Call<PersonajesRespuesta> getPage(@Url String url);
}

