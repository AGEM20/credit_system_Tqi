package com.github.agem20.creditanalysissystemtqi.calculo;

import java.math.BigDecimal;

public class PesoRenda {
    public PesoRenda(double rendaMinima, double rendaMaxima, Long peso) {
        this.rendaMinima = new BigDecimal(rendaMinima);
        this.rendaMaxima = new BigDecimal(rendaMaxima);
        this.peso = peso;
    }

    private BigDecimal rendaMinima;
    private BigDecimal rendaMaxima;
    private Long peso;

    public BigDecimal getRendaMinima() {
        return rendaMinima;
    }

    public void setRendaMinima(BigDecimal rendaMinima) {
        this.rendaMinima = rendaMinima;
    }

    public BigDecimal getRendaMaxima() {
        return rendaMaxima;
    }

    public void setRendaMaxima(BigDecimal rendaMaxima) {
        this.rendaMaxima = rendaMaxima;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }
}