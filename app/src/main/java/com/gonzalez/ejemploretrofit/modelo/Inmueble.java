package com.gonzalez.ejemploretrofit.modelo;

public class Inmueble {

    private String direccion;
    private int superficie;
    private double latitud;
    private double longitud;
    private int propietarioId;
    private String propietario;
    private int id;
    private int grupoId;

    public Inmueble(String direccion, int superficie, double latitud, double longitud, int propietarioId, String propietario, int id, int grupoId) {
        this.direccion = direccion;
        this.superficie = superficie;
        this.latitud = latitud;
        this.longitud = longitud;
        this.propietarioId = propietarioId;
        this.propietario = propietario;
        this.id = id;
        this.grupoId = grupoId;
    }

    public Inmueble() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public int getPropietarioId() {
        return propietarioId;
    }

    public void setPropietarioId(int propietarioId) {
        this.propietarioId = propietarioId;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGrupoId() {
        return grupoId;
    }

    public void setGrupoId(int grupoId) {
        this.grupoId = grupoId;
    }
}