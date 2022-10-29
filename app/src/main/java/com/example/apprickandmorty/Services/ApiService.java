package com.example.apprickandmorty.Services;


import com.example.apprickandmorty.Clases.PersonajesRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface ApiService {
        @GET("character")
        Call<PersonajesRespuesta> getAllNames();

    @GET("character/{id}")
    Call<PersonajesRespuesta> getPostById(@Path("id") int postId);

}

