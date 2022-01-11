package com.github.agem20.creditanalysissystemtqi.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
public class ResultadoAnalise {

    public ResultadoAnalise(BigDecimal limiteMin, BigDecimal limiteMax, String limite, String status) {
        this.limiteMax = limiteMax;
        this.limiteMin = limiteMin;
        this.limite = limite;
        this.status = status;
    }

    public ResultadoAnalise() { }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private PropostaCredito propostaCredito;

    @Version
    private Integer versao;

    private String status;
    private BigDecimal limiteMax;
    private BigDecimal limiteMin;
    private String limite;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getLimiteMax() {
        return limiteMax;
    }

    public void setLimiteMax(BigDecimal limiteMax) {
        this.limiteMax = limiteMax;
    }

    public BigDecimal getLimiteMin() {
        return limiteMin;
    }

    public void setLimiteMin(BigDecimal limiteMin) {
        this.limiteMin = limiteMin;
    }

    public String getLimite() {
        return limite;
    }

    public void setLimite(String limite) {
        this.limite = limite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropostaCredito getPropostaCredito() {
        return propostaCredito;
    }

    public void setPropostaCredito(PropostaCredito propostaCredito) {
        this.propostaCredito = propostaCredito;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

}
