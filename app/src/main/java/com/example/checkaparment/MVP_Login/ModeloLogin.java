package com.example.checkaparment.MVP_Login;

public class ModeloLogin {
    private String password = "123Pass";
    private String mensaje;
    private int contador = 0;

    public void validarPassword(String clave){
        if (password != clave){
            mensaje = "Clave Incorrecta";
            contador ++;
        } else {
            mensaje = "correcto";
            contador = 0;
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getContador() {
        return contador;
    }
}
