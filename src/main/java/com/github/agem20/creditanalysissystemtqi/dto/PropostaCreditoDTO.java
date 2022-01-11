package com.github.agem20.creditanalysissystemtqi.dto;

import com.github.agem20.creditanalysissystemtqi.entity.PropostaCredito;

public class PropostaCreditoDTO {

    public PropostaCreditoDTO() {
        super();
    }

    public PropostaCreditoDTO(PropostaCredito proposta) {
        super();
        this.id = proposta.getId();
        this.cliente = new ClienteDTO(proposta.getCliente());
        this.resultadoAnalise = new ResultadoAnaliseDTO(proposta.getResultadoAnalise());
        this.versao = proposta.getVersao();
    }

    private Long id;
    private ClienteDTO cliente;
    private ResultadoAnaliseDTO resultadoAnalise;
    private Integer versao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ResultadoAnaliseDTO getResultadoAnalise() {
        return resultadoAnalise;
    }

    public void setResultadoAnalise(ResultadoAnaliseDTO resultadoAnalise) {
        this.resultadoAnalise = resultadoAnalise;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

}
