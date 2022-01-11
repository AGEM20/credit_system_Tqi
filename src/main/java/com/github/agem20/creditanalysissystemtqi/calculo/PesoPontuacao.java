package com.github.agem20.creditanalysissystemtqi.calculo;

import com.github.agem20.creditanalysissystemtqi.entity.ResultadoAnalise;

public class PesoPontuacao {


    public PesoPontuacao(double pesoMinimo, double pesoMaximo, ResultadoAnalise resultadoAnalise) {
        super();
        this.pesoMinimo = pesoMinimo;
        this.pesoMaximo = pesoMaximo;
        this.resultadoAnalise = resultadoAnalise;
    }


    private double pesoMinimo;
    private double pesoMaximo;
    private ResultadoAnalise resultadoAnalise;
    public double getPesoMinimo() {
        return pesoMinimo;
    }
    public void setPesoMinimo(double pesoMinimo) {
        this.pesoMinimo = pesoMinimo;
    }
    public double getPesoMaximo() {
        return pesoMaximo;
    }
    public void setPesoMaximo(double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }
    public ResultadoAnalise getResultadoAnalise() {
        return resultadoAnalise;
    }
    public void setResultadoAnalise(ResultadoAnalise resultadoAnalise) {
        this.resultadoAnalise = resultadoAnalise;
    }
}
