package com.example.checkaparment.MVP_Login;

import org.junit.Before;
import org.junit.Test;

import java.security.acl.LastOwnerException;

import static org.junit.Assert.*;

public class ModeloLoginTest {
    ModeloLogin login;

    @Before
    public void setUp() throws Exception {
        login = new ModeloLogin();
    }

    @Test
    public void getMensaje() {
        //GIVEN
        String password = "123Pass";
        //WHEN
        login.validarPassword(password);
        //THEN
        assertEquals("Clave Correcta", login.getMensaje());
    }
}