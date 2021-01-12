package com.example.checkaparment;

import android.os.Bundle;

import com.example.checkaparment.MVP_Login.ILogin;
import com.example.checkaparment.MVP_Login.Presentator;
import com.example.checkaparment.databinding.ActivityLoginBinding;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements ILogin {
    private ActivityLoginBinding binding;
    private ILogin iLogin;
    private Presentator presentator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        presentator = new Presentator(iLogin);

        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = binding.editTextTextPassword.getText().toString();
                validarPassword(password);
                mensajeToast(mensajeLogin());
                if (contadorLogin() == 3){
                    binding.button.setEnabled(false);
                }
            }
        });

    }

    @Override
    public void validarPassword(String password) {
        presentator.validarPassword(password);
    }

    @Override
    public String mensajeLogin() {
        return presentator.mensajeLogin();
    }

    @Override
    public int contadorLogin() {
        return presentator.contadorLogin();
    }

    public void mensajeToast(String mensaje) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show();
    }
}