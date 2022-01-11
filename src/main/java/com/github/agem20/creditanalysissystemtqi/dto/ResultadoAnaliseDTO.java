package com.github.agem20.creditanalysissystemtqi.dto;

import com.github.agem20.creditanalysissystemtqi.entity.ResultadoAnalise;

import java.math.BigDecimal;


public class ResultadoAnaliseDTO {

    public ResultadoAnaliseDTO() {
        super();
    }

    public ResultadoAnaliseDTO(ResultadoAnalise resultado) {
        super();
        this.id = resultado.getId();

        if(resultado.getPropostaCredito() != null && resultado.getPropostaCredito().getId() != null) {
            this.propostaCredito = new PropostaCreditoDTO();
            this.propostaCredito.setId(resultado.getPropostaCredito().getId());
        }

        this.versao = resultado.getVersao();
        this.status = resultado.getStatus();
        this.limiteMax = resultado.getLimiteMax();
        this.limiteMin = resultado.getLimiteMin();
        this.limite = resultado.getLimite();
    }

    private Long id;
    private PropostaCreditoDTO propostaCredito;
    private Integer versao;
    private String status;
    private BigDecimal limiteMax;
    private BigDecimal limiteMin;
    private String limite;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PropostaCreditoDTO getPropostaCredito() {
        return propostaCredito;
    }

    public void setPropostaCredito(PropostaCreditoDTO propostaCredito) {
        this.propostaCredito = propostaCredito;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

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
}