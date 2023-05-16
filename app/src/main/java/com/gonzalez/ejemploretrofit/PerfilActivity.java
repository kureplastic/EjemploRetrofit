package com.gonzalez.ejemploretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.gonzalez.ejemploretrofit.databinding.ActivityPerfilBinding;
import com.gonzalez.ejemploretrofit.modelo.Propietario;

public class PerfilActivity extends AppCompatActivity {

    private PerfilActivityViewModel mv;
    private ActivityPerfilBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPerfilBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mv = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(PerfilActivityViewModel.class);

        mv.cargarDatos();
        //observer al mutablePropietario
        mv.getMutablePropietario().observe(this, new Observer<Propietario>() {
            @Override
            public void onChanged(Propietario propietario) {
                //llenar vista
                binding.tvNombre.setText(propietario.getNombre());
                binding.tvEmail.setText(propietario.getEmail());
                binding.tvTelefono.setText(propietario.getTelefono());
                binding.tvClave.setText(propietario.getClave());
            }
        });
        binding.btInmuebles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ir a inmuebles
                Intent intent = new Intent(getApplicationContext(), InmueblesActivity.class);
                startActivity(intent);
            }
        });
    }
}