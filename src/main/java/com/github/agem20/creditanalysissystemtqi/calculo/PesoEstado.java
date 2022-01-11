package com.github.agem20.creditanalysissystemtqi.calculo;

public class PesoEstado {

    private String estado;
    private Long peso;

    public PesoEstado(String estado, Long peso) {
        this.estado = estado;
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

}