package com.example.checkaparment.MVPCalculo;

public class ModeloCalculo {
    private int luces = 0;
    private int dormitorio = 0;
    private int cocina = 0;
    private int bano = 0;
    private int terminaciones = 0;
    private int resultadoCalculo = 0;
    private int resultado = 0;

    public ModeloCalculo() {}

    public ModeloCalculo(int luces, int dormitorio, int cocina, int bano, int terminaciones) {
        this.luces = luces;
        this.dormitorio = dormitorio;
        this.cocina = cocina;
        this.bano = bano;
        this.terminaciones = terminaciones;
    }

    public void calculoRevision(int luces, int dormitorio, int cocina, int bano, int terminaciones) {
        this.resultadoCalculo = (luces + dormitorio + cocina + bano) * terminaciones;
    }

    public int getLuces() {
        return luces;
    }

    public void setLuces(int luces) {
        this.luces = luces;
    }

    public int getDormitorio() {
        return dormitorio;
    }

    public void setDormitorio(int dormitorio) {
        this.dormitorio = dormitorio;
    }

    public int getCocina() {
        return cocina;
    }

    public void setCocina(int cocina) {
        this.cocina = cocina;
    }

    public int getBano() {
        return bano;
    }

    public void setBano(int bano) {
        this.bano = bano;
    }

    public int getTerminaciones() {
        return terminaciones;
    }

    public void setTerminaciones(int terminaciones) {
        this.terminaciones = terminaciones;
    }

    public int getResultadoCalculo() {
        return this.resultadoCalculo;
    }
}
