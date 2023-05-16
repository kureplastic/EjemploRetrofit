package com.gonzalez.ejemploretrofit.request;

import com.gonzalez.ejemploretrofit.modelo.Inmueble;
import com.gonzalez.ejemploretrofit.modelo.Propietario;
import com.gonzalez.ejemploretrofit.modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public class ApiClient {

    private static final String PATH="http://practicastuds.ulp.edu.ar/api/";
    private static  EndPointInmobiliaria endPointInmobiliaria;

    public static EndPointInmobiliaria getEndpointInmobiliaria(){

        Gson gson = new GsonBuilder().setLenient().create();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(PATH)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        endPointInmobiliaria=retrofit.create(EndPointInmobiliaria.class);

        return endPointInmobiliaria;
    }





    public interface EndPointInmobiliaria{

        @POST("Propietarios/login")
        Call<String> login(@Body Usuario user);

        @GET("Propietarios")
        Call<Propietario> obtenerPerfil(@Header("Authorization") String token);

        @GET("Inmuebles/0")
        Call<List<Inmueble>> obtenerInmuebles(@Header("Authorization") String token);

        @GET("Propietarios/inmuebles")
        Call<List<Inmueble>> obtenerInmueblesPorPropietario(@Header("Authorization") String token);

    }


}
