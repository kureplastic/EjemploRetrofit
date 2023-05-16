package com.gonzalez.ejemploretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;

import com.gonzalez.ejemploretrofit.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private MainActivityViewModel mv;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mv=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(MainActivityViewModel.class);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mv.login(binding.etUsuario.getText().toString(),binding.etContraseA.getText().toString());
            }
        });
    }
}