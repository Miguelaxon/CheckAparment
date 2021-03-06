package com.example.checkaparment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.checkaparment.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment implements IApartment{
    private FragmentFirstBinding binding;
    private ApartmentData apartmentData = new ApartmentData();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);

        ListAdapter listAdapter = new ListAdapter(apartmentData.apartmentList(), this);
        binding.rv.setAdapter(listAdapter);
        binding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void passApartment(Apartment aparment) {
        Bundle bundle = new Bundle();
        bundle.putString("nombreEdificio", aparment.getNombreEdificio());
        bundle.putString("deptoTorre", aparment.getDeptoTorre());
        bundle.putString("direccion", aparment.getDireccionEdificio());
        bundle.putString("imagen", aparment.getImagenURL());
        Navigation.findNavController(binding.getRoot())
                .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
    }
}