package com.gonzalez.ejemploretrofit;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.gonzalez.ejemploretrofit.modelo.Propietario;
import com.gonzalez.ejemploretrofit.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Propietario> mutablePropietario;
    private Context context;
    public PerfilActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();
        mutablePropietario = new MutableLiveData<>();
    }
    public LiveData<Propietario> getMutablePropietario(){ return mutablePropietario;}

    public void cargarDatos(){
        //traer los datos con la interfaz usando el token guardado en sharedpreferences
        ApiClient.EndPointInmobiliaria end = ApiClient.getEndpointInmobiliaria();

        Call<Propietario> call = end.obtenerPerfil(context.getSharedPreferences("token.xml",0).getString("token",""));
        call.enqueue(new Callback<Propietario>() {
            @Override
            public void onResponse(Call<Propietario> call, Response<Propietario> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        mutablePropietario.postValue(response.body());
                        Log.d("salida correcta:", response.body().getNombre());
                    }else{
                        Log.d("error al traer el perfil:", response.body().getNombre());
                    }
                }
            }

            @Override
            public void onFailure(Call<Propietario> call, Throwable t) {
                Toast.makeText(context, "Error al obtener el perfil", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
