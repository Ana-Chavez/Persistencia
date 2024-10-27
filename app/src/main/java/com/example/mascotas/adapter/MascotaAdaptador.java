package com.example.mascotas.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mascotas.Mascota;
import com.example.mascotas.R;
import com.example.mascotas.db.ConstructorMascotas;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getImagen());
        mascotaViewHolder.tvNombre.setText(mascota.getNombre());
        mascotaViewHolder.tvRaiting.setText(String.valueOf(mascota.getRating()));


        mascotaViewHolder.btnHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(),
                        Toast.LENGTH_SHORT).show();

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darLikeMascota(mascota);
                mascotaViewHolder.tvRaiting.setText(constructorMascotas.obtenerLikesMascota(mascota) + " " + activity.getString(R.string.likes));


            }
        });

        /*mascotaViewHolder.huesoBlanco.setOnClickListener(v -> {
            mascota.setRating(mascota.getRating() + 1);
            mascotaViewHolder.tvRaiting.setText(String.valueOf(mascota.getRating()));
        });*/
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMascota, huesoAmarillo;
        TextView tvNombre, tvRaiting;
        private ImageButton btnHuesoBlanco;

        public MascotaViewHolder(@NonNull View itemView){
            super (itemView);
            imgMascota = itemView.findViewById(R.id.imgMascota);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            btnHuesoBlanco = itemView.findViewById(R.id.icBlanco);
            huesoAmarillo = itemView.findViewById(R.id.icNaranja);
            tvRaiting = itemView.findViewById(R.id.ratingMascota);
        }
    }
}
