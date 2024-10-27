package com.example.mascotas.fragment;

import com.example.mascotas.Mascota;
import com.example.mascotas.adapter.MascotaAdaptador;

import java.util.ArrayList;

public interface IRecyclerViewFragmentView {

    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorRV(MascotaAdaptador adaptador);
}
