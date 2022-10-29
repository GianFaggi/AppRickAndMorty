package com.example.apprickandmorty.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.apprickandmorty.Activities.Detalle_Personaje;
import com.example.apprickandmorty.Clases.Personaje;
import com.example.apprickandmorty.R;

import java.util.ArrayList;

public class ListaPersonajeAdapter extends RecyclerView.Adapter<ListaPersonajeAdapter.ViewHolder> {

        private ArrayList<Personaje> dataset;
        private Context context;


        public interface OnItemClickListener {
                void onItemClick(Personaje item);
        }

        public ListaPersonajeAdapter(Context context) {
                this.context = context;
                dataset = new ArrayList<>();

        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.adapter_personaje), parent, false);
                return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                Personaje p = dataset.get(position);

                holder.name.setText(p.getName());
                holder.status.setText(p.getStatus());
                holder.species.setText(p.getSpecie());
                holder.gender.setText(p.getGenre());
                Glide.with(context).load("https://rickandmortyapi.com/api/character/avatar/" + p.getNumber())
                        .centerCrop()
                        .diskCacheStrategy(DiskCacheStrategy.ALL)
                        .into(holder.imagen);

        }

        @Override
        public int getItemCount() {
                return dataset.size();
        }

        public void adicionarListaPersonaje(ArrayList<Personaje> listapersonaje) {
                dataset.addAll(listapersonaje);
                notifyDataSetChanged();
        }

        public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

                private ImageView imagen;
                private TextView status, gender, species, name, origen, localizacion;

                public ViewHolder(View itemView) {
                        super(itemView);

                        imagen = (ImageView) itemView.findViewById(R.id.imagenGrande);
                        name = itemView.findViewById(R.id.nombrePersonaje);
                        status = itemView.findViewById(R.id.Info_Estado);
                        species = itemView.findViewById(R.id.Info_Especie);
                        gender = itemView.findViewById(R.id.Info_Genero);
                        itemView.setOnClickListener(this);
                }

                @Override
                public void onClick(View v) {
                        int position = getAdapterPosition();
                        Toast.makeText(context, "position"+position, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(context, Detalle_Personaje.class);
                        intent.putExtra("name", dataset.get(position).getName());
                        intent.putExtra("status", dataset.get(position).getStatus());
                        intent.putExtra("image", dataset.get(position).getImage());
                        intent.putExtra("number", dataset.get(position).getNumber());
                        intent.putExtra("nameOrigen", String.valueOf(dataset.get(position).getOrigin().getName()));
                        intent.putExtra("namelocation", String.valueOf(dataset.get(position).getlocation().getName()));
                        context.startActivities(new Intent[]{intent});

                        }
                }
        }



