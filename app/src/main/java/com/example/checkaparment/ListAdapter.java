package com.example.checkaparment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.checkaparment.databinding.ItemListBinding;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    private List<Apartment> list;
    private IApartment iApartment;

    public ListAdapter(List<Apartment> list, IApartment iApartment) {
        this.list = list;
        this.iApartment = iApartment;
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemListBinding binding = ItemListBinding.
                inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        Apartment apartment = list.get(position);
        holder.nombreEdificio.setText(apartment.getNombreEdificio());
        holder.deptoTorre.setText(apartment.getDeptoTorre());
        holder.direccionEdificio.setText(apartment.getDireccionEdificio());
        Glide.with(holder.urlImagen.getContext()).load(apartment.getImagenURL()).into(holder.urlImagen);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView nombreEdificio;
        private TextView deptoTorre;
        private TextView direccionEdificio;
        private ImageView urlImagen;

        public ListViewHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
            nombreEdificio = binding.tvNombreEdificio;
            deptoTorre = binding.tvDepto;
            direccionEdificio = binding.tvDireccion;
            urlImagen = binding.ivEdificio;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            iApartment.passApartment(list.get(getLayoutPosition()));
        }
    }
}
