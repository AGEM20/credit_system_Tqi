package com.github.agem20.creditanalysissystemtqi.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.agem20.creditanalysissystemtqi.entity.Cliente;

import java.math.BigDecimal;
import java.util.Date;

public class ClienteDTO {

    public ClienteDTO() {
        super();
    }

    public ClienteDTO(Cliente cliente) {
        super();
        this.id = cliente.getId();
        this.versao = cliente.getVersao();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.dataNascimento = cliente.getDataNascimento();
        this.sexo = cliente.getSexo();
        this.estadoCivil = cliente.getEstadoCivil();
        this.estado = cliente.getEstado();
        this.dependentes = cliente.getDependentes();
        this.renda = cliente.getRenda();
        this.idade = cliente.getIdade();
    }

    private Long id;
    private Integer idade;
    private Integer versao;
    private String nome;
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Phoenix")
    private Date dataNascimento;
    private String sexo;
    private String estadoCivil;
    private String estado;
    private Integer dependentes;
    private BigDecimal renda;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Integer getVersao() {
        return versao;
    }

    public void setVersao(Integer versao) {
        this.versao = versao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getDependentes() {
        return dependentes;
    }

    public void setDependentes(Integer dependentes) {
        this.dependentes = dependentes;
    }

    public BigDecimal getRenda() {
        return renda;
    }

    public void setRenda(BigDecimal renda) {
        this.renda = renda;
    }
}
