package com.gonzalez.ejemploretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

public class InmueblesActivity extends AppCompatActivity {
        private InmuebleActivityViewModel mv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mv = new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(InmuebleActivityViewModel.class);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inmuebles);

        mv.obtenerInmuebles();
    }
}