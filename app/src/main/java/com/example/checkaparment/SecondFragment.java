package com.example.checkaparment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.checkaparment.MVPCalculo.ICalculo;
import com.example.checkaparment.MVPCalculo.ModeloCalculo;
import com.example.checkaparment.MVPCalculo.PresentadorCalculo;
import com.example.checkaparment.MVP_Login.Presentator;
import com.example.checkaparment.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment implements ICalculo {
    private FragmentSecondBinding binding;
    private PresentadorCalculo presentator;
    private String nombreEdificio;
    private String deptoTorre;
    private String direccion;
    private String urlImagen;
    private int luces, dormitorio = 0, bano = 0, cocina = 0, terminaciones = 0;

    public SecondFragment() {
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        binding.nombreEdificio.setText(nombreEdificio);
        binding.depto.setText(deptoTorre);
        Glide.with(getContext()).load(urlImagen).centerCrop().into(binding.imageView);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nombreEdificio = getArguments().getString("nombreEdificio");
            deptoTorre = getArguments().getString("deptoTorre");
            direccion = getArguments().getString("direccion");
            urlImagen = getArguments().getString("imagen");
        }
        presentator = new PresentadorCalculo(this);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (binding.cbEstadoLuces.isActivated()){ luces = 10; } else { luces = 0;}
        if (binding.cbElementoDormitorio.isClickable()) { dormitorio = 20; } else { dormitorio = 0; }
        if (binding.cbElementosCocina.isChecked()) { cocina = 30; } else { cocina = 0; }
        if (binding.cbElementosBano.isSelected()) { bano = 40; } else { bano = 0; }
        binding.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = binding.rg.findViewById(checkedId);
                int index = binding.rg.indexOfChild(radioButton);
                String texto;
                switch (index){
                    case 0:
                        terminaciones = 3;
                        calculoRevision(luces, dormitorio, cocina, bano, terminaciones);
                        break;
                    case 1:
                        terminaciones = 2;
                        calculoRevision(luces, dormitorio, cocina, bano, terminaciones);
                        break;
                    case 2:
                        terminaciones = 1;
                        calculoRevision(luces, dormitorio, cocina, bano, terminaciones);
                        break;
                }
                texto = getString(R.string.puntaje, String.valueOf(resultadoCalculo()));
                binding.tvPuntaje.setText(texto);
            }
        });
    }

    @Override
    public void calculoRevision(int luces, int dormitorio, int cocina, int bano, int terminaciones) {
        presentator.calculoRevision(luces, dormitorio, cocina, bano, terminaciones);
    }

    @Override
    public int resultadoCalculo() {
        return presentator.resultadoCalculo();
    }
}