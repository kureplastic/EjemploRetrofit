package com.gonzalez.ejemploretrofit;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.gonzalez.ejemploretrofit.modelo.Usuario;
import com.gonzalez.ejemploretrofit.request.ApiClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel
{
    private Context context;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.context=application.getApplicationContext();
    }

    public void login(String usuario,String clave){

        Usuario miUsuario=new Usuario(usuario,clave);
        ApiClient.EndPointInmobiliaria end=ApiClient.getEndpointInmobiliaria();
        Call<String> call= end.login(miUsuario);
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if(response.isSuccessful()){

                    if(response.body()!=null){
                        Log.d("salida ",response.body());
                        SharedPreferences sp = context.getSharedPreferences("token.xml",0);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("token","Bearer " + response.body());
                        editor.commit();
                        Intent intent = new Intent(context, PerfilActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                    }

                }else{
                    Log.d("salida ","aca no se pudo iniciar sesion");
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

                Toast.makeText(context,"Error al llamar login: " + t,Toast.LENGTH_LONG).show();
            }
        });

    }
}
