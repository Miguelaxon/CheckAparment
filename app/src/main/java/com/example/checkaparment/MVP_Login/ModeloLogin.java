package com.example.checkaparment.MVP_Login;

public class ModeloLogin {
    private String password;
    private String mensaje;
    private int contador = 0;

    public void validarPassword(String clave){
        password = "123Pass";
        if (clave.equals(password)){
            mensaje = "Clave Correcta";
            contador = 0;
        } else {
            mensaje = "Clave Incorrecta";
            contador ++;
        }
    }

    public String getMensaje() {
        return mensaje;
    }

    public int getContador() {
        return contador;
    }
}
