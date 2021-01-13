package com.example.checkaparment;

public class Apartment {
    private String nombreEdificio;
    private String torreEdificio;
    private String deptoTorre;
    private String direccionEdificio;
    private String imagenURL;

    public Apartment() {
    }

    public Apartment(String nombreEdificio, String torreEdificio, String deptoTorre, String direccionEdificio, String imagenURL) {
        this.nombreEdificio = nombreEdificio;
        this.torreEdificio = torreEdificio;
        this.deptoTorre = deptoTorre;
        this.direccionEdificio = direccionEdificio;
        this.imagenURL = imagenURL;
    }

    public String getNombreEdificio() {
        return nombreEdificio;
    }

    public void setNombreEdificio(String nombreEdificio) {
        this.nombreEdificio = nombreEdificio;
    }

    public String getTorreEdificio() {
        return torreEdificio;
    }

    public void setTorreEdificio(String torreEdificio) {
        this.torreEdificio = torreEdificio;
    }

    public String getDeptoTorre() {
        return deptoTorre;
    }

    public void setDeptoTorre(String deptoTorre) {
        this.deptoTorre = deptoTorre;
    }

    public String getDireccionEdificio() {
        return direccionEdificio;
    }

    public void setDireccionEdificio(String direccionEdificio) {
        this.direccionEdificio = direccionEdificio;
    }

    public String getImagenURL() {
        return imagenURL;
    }

    public void setImagenURL(String imagenURL) {
        this.imagenURL = imagenURL;
    }
}
