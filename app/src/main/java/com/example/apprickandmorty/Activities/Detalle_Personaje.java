package com.example.apprickandmorty.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.apprickandmorty.Clases.Personaje;
import com.example.apprickandmorty.R;
import com.example.apprickandmorty.Services.ApiService;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Detalle_Personaje extends AppCompatActivity {

    ImageView imagen;
    TextView nombre, estado, origen, localizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_personaje);

        getSupportActionBar().setTitle("Detalle Personaje");


        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        imagen = findViewById(R.id.imageView);
        nombre = findViewById(R.id.nombrePersonaje);
        estado = findViewById(R.id.Info_Estado_Detalle);
        origen = findViewById(R.id.Info_Origen);
        localizacion = findViewById(R.id.Info_Localizacion);
        int posicion = Integer.parseInt(id);
        cargarPost(posicion);
    }

    private void cargarPost(int id){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiService postService = retrofit.create(ApiService.class);
        Call<Personaje> call = postService.getPostById(id);

        call.enqueue(new Callback<Personaje>() {
            @Override
            public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                Personaje pr = (Personaje) response.body();
                nombre.setText(pr.getName());
                estado.setText(pr.getStatus());
                origen.setText(pr.getOrigin().getName());
                localizacion.setText(pr.getlocation().getName());
                Glide.with(getBaseContext()).load("https://rickandmortyapi.com/api/character/avatar/" + pr.getNumber() )
                        .centerCrop()
                        .placeholder(R.drawable.ic_launcher_background)
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .fitCenter()
                        .into(imagen);

            }

            @Override
            public void onFailure(Call<Personaje> call, Throwable t) {
            }
        });
    }


    }



