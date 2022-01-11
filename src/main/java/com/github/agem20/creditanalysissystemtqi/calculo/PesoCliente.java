package com.github.agem20.creditanalysissystemtqi.calculo;


import java.util.ArrayList;
import java.util.List;



public class PesoCliente {
    public PesoCliente(Integer idadeMinima, Integer idadeMaxima,String sexo,  String estadoCivil, Long peso) {
        super();
        this.estadoCivil = estadoCivil;
        this.idadeMinima = idadeMinima;
        this.idadeMaxima = idadeMaxima;
        this.sexo = sexo;
        this.peso = peso;
    }

    private String estadoCivil;
    private Integer idadeMinima;
    private Integer idadeMaxima;
    private String sexo;
    private Long peso;

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Integer getIdadeMinima() {
        return idadeMinima;
    }

    public void setIdadeMinima(Integer idadeMinima) {
        this.idadeMinima = idadeMinima;
    }

    public Integer getIdadeMaxima() {
        return idadeMaxima;
    }

    public void setIdadeMaxima(Integer idadeMaxima) {
        this.idadeMaxima = idadeMaxima;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }
}
