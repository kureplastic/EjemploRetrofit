package com.gonzalez.ejemploretrofit;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.gonzalez.ejemploretrofit.modelo.Inmueble;
import com.gonzalez.ejemploretrofit.modelo.Propietario;
import com.gonzalez.ejemploretrofit.request.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InmuebleActivityViewModel extends AndroidViewModel {

    private Context context;
    public InmuebleActivityViewModel(@NonNull Application application) {
        super(application);
        context = application.getApplicationContext();

    }

    public void obtenerInmuebles(){
        ApiClient.EndPointInmobiliaria end = ApiClient.getEndpointInmobiliaria();

        Call<List<Inmueble>> call = end.obtenerInmuebles(context.getSharedPreferences("token.xml",0).getString("token",""));
        call.enqueue(new Callback<List<Inmueble>>() {
            @Override
            public void onResponse(Call<List<Inmueble>> call, Response<List<Inmueble>> response) {
                if(response.isSuccessful()){
                    if(response.body()!=null){
                        //llenar campos de inmuebles
                        for(int i = 0; i<response.body().size(); i++){
                            Log.d("salida", response.body().get(i).getDireccion());
                        }
                    }else{
                        // error no habia nada en el body
                        Log.d("Inmuebles:","error no habia nada en el body");
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Inmueble>> call, Throwable t) {
                Toast.makeText(context, "Error al obtener el perfil", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
