package com.example.apprickandmorty.Activities;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.apprickandmorty.Adapter.ListaPersonajeAdapter;
import com.example.apprickandmorty.Clases.Personaje;
import com.example.apprickandmorty.Clases.PersonajesRespuesta;
import com.example.apprickandmorty.R;
import com.example.apprickandmorty.Services.ApiService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    private Retrofit retrofit;

    private RecyclerView recyclerView;
    private ListaPersonajeAdapter listaPersonajeAdapter;

    private static final String TAG = "Personaje";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        listaPersonajeAdapter = new ListaPersonajeAdapter(this);
        recyclerView.setAdapter(listaPersonajeAdapter);
        recyclerView.setHasFixedSize(true);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(layoutManager);



        retrofit = new Retrofit.Builder()
                .baseUrl("https://rickandmortyapi.com/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

                obtenerDatos();

    }

    private void obtenerDatos(){
        ApiService service = retrofit.create(ApiService.class);
        Call<PersonajesRespuesta> personajesRespuestaCall = service.getAllNames();

        personajesRespuestaCall.enqueue(new Callback<PersonajesRespuesta>() {
            @Override
            public void onResponse(Call<PersonajesRespuesta> call, Response<PersonajesRespuesta> response) {
                if (response.isSuccessful()) {
                    PersonajesRespuesta personajesRespuesta = response.body();
                    ArrayList<Personaje> listapersonaje = personajesRespuesta.getResults();

                    listaPersonajeAdapter.adicionarListaPersonaje(listapersonaje);


                } else {
                    Log.e(TAG, "onRespones:" + response.errorBody());
                }
            }

            @Override
            public void onFailure(Call<PersonajesRespuesta> call, Throwable t) {
                Log.e(TAG, "onFailure:" + t.getMessage());

            }
        });
    }

}

