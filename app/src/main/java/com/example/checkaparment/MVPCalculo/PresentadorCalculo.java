package com.example.checkaparment.MVPCalculo;

public class PresentadorCalculo {
    private ICalculo iCalculo;
    private ModeloCalculo modeloCalculo;

    public PresentadorCalculo(ICalculo iCalculo) {
        this.iCalculo = iCalculo;
        this.modeloCalculo = new ModeloCalculo();
    }

    public void calculoRevision(int luces, int dormitorio, int cocina, int bano, int terminaciones){
        modeloCalculo.calculoRevision(luces, dormitorio, cocina, bano, terminaciones);
    }

    public int resultadoCalculo(){
        return modeloCalculo.getResultadoCalculo();
    }
}
