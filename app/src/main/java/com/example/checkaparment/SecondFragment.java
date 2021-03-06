package com.example.checkaparment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
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
    private String  texto;
    private int luces = 0, dormitorio = 0, bano = 0, cocina = 0, terminaciones = 0;

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
        binding.btnAlerta.setEnabled(false);
        binding.rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                View radioButton = binding.rg.findViewById(checkedId);
                int index = binding.rg.indexOfChild(radioButton);
                switch (index){
                    case 0:
                        checkBoxes();
                        terminaciones = 3;
                        calculoRevision(luces, dormitorio, cocina, bano, terminaciones);
                        break;
                    case 1:
                        checkBoxes();
                        terminaciones = 2;
                        calculoRevision(luces, dormitorio, cocina, bano, terminaciones);
                        break;
                    case 2:
                        checkBoxes();
                        terminaciones = 1;
                        calculoRevision(luces, dormitorio, cocina, bano, terminaciones);
                        break;
                }
                mensajePuntaje();
            }
        });

        binding.btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "El puntaje obtenido es: "
                        + String.valueOf(resultadoCalculo()), Toast.LENGTH_SHORT).show();
            }
        });

        binding.btnAlerta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onIntent();
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

    public void checkBoxes(){
        if (binding.cbEstadoLuces.isChecked()){ luces = 10; } else { luces = 0; }
        if (binding.cbElementoDormitorio.isChecked()) { dormitorio = 20; } else { dormitorio = 0; }
        if (binding.cbElementosCocina.isChecked()) { cocina = 30; } else { cocina = 0; }
        if (binding.cbElementosBano.isChecked()) { bano = 40; } else { bano = 0; }
    }

    public void mensajePuntaje(){
        texto = getString(R.string.puntaje, String.valueOf(resultadoCalculo()));
        binding.tvPuntaje.setText(texto);
        if (resultadoCalculo() < 130) {
            binding.tvPuntaje.setTextColor(Color.WHITE);
            binding.tvPuntaje.setBackgroundColor(Color.RED);
            binding.btnAlerta.setEnabled(true);
        } else {
            binding.tvPuntaje.setTextColor(Color.BLACK);
            binding.tvPuntaje.setBackgroundColor(Color.WHITE);
            binding.btnAlerta.setEnabled(false);
        }
    }

    public void onIntent(){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setData(Uri.parse("mailto: "));
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"hideki.ahumada@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT, "ALERTA!");
        startActivity(intent);
    }
}