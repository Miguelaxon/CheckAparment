package com.example.checkaparment.MVP_Login;

public class Presentator {
    private ILogin iLogin;
    private ModeloLogin modeloLogin;

    public Presentator(ILogin iLogin){
        this.iLogin = iLogin;
        this.modeloLogin = new ModeloLogin();
    }

    public void validarPassword(String password){
        modeloLogin.validarPassword(password);
    }

    public String mensajeLogin(){
        return modeloLogin.getMensaje();
    }
    public int contadorLogin(){
        return modeloLogin.getContador();
    }
}
