package com.example.checkaparment.MVPCalculo;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ModeloCalculoTest {
    private ModeloCalculo calculo;

    @Before
    public void setUp() throws Exception {
        calculo = new ModeloCalculo();
    }

    @Test
    public void calculoRevision() {
    }

    @Test
    public void getResultadoCalculo() {
        //GIVEN
        int luces = 10, dormitorio = 20, bano = 30, cocina = 40;
        int terminaciones = 3;
        //WHEN
        calculo.calculoRevision(luces, dormitorio, bano, cocina, terminaciones);
        //THEN
        assertEquals(300, calculo.getResultadoCalculo());
    }
}