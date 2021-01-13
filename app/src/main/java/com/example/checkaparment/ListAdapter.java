package com.example.checkaparment;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.checkaparment.databinding.ItemListBinding;

import java.util.List;

public class ListAdapter {
    private List<String> list;
    private IApartment iApartment;

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private String nombreEdificio;
        private String deptoTorre;
        private String direccionEdificio;

        public ListViewHolder(@NonNull ItemListBinding binding) {
            super(binding.getRoot());
        }

        @Override
        public void onClick(View v) {

        }
    }
}
