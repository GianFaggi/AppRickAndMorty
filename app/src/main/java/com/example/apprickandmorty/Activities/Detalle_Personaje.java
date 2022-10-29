package com.example.apprickandmorty.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.apprickandmorty.R;

public class Detalle_Personaje extends AppCompatActivity {

    ImageView imagen;
    TextView nombre, estado, origen, localizacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_personaje);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String status = intent.getStringExtra("status");
        String image = intent.getStringExtra("image");
        String number = intent.getStringExtra("number");
        String nameOrigen = intent.getStringExtra("nameOrigen");
        String namelocation = intent.getStringExtra("namelocation");


        imagen = findViewById(R.id.imageView);
        nombre = findViewById(R.id.nombrePersonaje);
        estado = findViewById(R.id.Info_Estado_Detalle);
        origen = findViewById(R.id.Info_Origen);
        localizacion = findViewById(R.id.Info_Localizacion);

        Glide.with(getBaseContext()).load("https://rickandmortyapi.com/api/character/avatar/" + number)
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(imagen);

        nombre.setText(name);
        estado.setText(status);
        origen.setText(nameOrigen);
        localizacion.setText(namelocation);
    }
}


