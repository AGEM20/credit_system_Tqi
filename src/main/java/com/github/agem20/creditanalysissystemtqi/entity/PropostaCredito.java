package com.github.agem20.creditanalysissystemtqi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;


@Entity
public class PropostaCredito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Cliente cliente;

    @Cascade(value=CascadeType.PERSIST)
    @OneToOne
    private ResultadoAnalise resultadoAnalise;

    @Version
    private Integer versao;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public ResultadoAnalise getResultadoAnalise() {
        return resultadoAnalise;
    }

    public void setResultadoAnalise(ResultadoAnalise resultadoAnalise) {
        this.resultadoAnalise = resultadoAnalise;
    }
}