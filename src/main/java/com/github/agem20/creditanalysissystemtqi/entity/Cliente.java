package com.github.agem20.creditanalysissystemtqi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Version
    private Integer versao;

    private String nome;
    private String cpf;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy", timezone = "America/Phoenix")
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date dataNascimento;
    private String sexo;
    private String estadoCivil;
    private String estado;
    private Integer dependentes;
    private BigDecimal renda;

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

    public Integer getIdade() {

        Calendar data = Calendar.getInstance();

        int diaAtual = data.get(Calendar.DAY_OF_YEAR);
        int anoAtual = data.get(Calendar.YEAR);

        data.setTime(this.dataNascimento);
        int diaNascimento = data.get(Calendar.DAY_OF_YEAR);
        int anoNascimento = data.get(Calendar.YEAR);

        int numeroDeAnos = anoAtual - anoNascimento;

        if (diaAtual < diaNascimento)
            numeroDeAnos--; // Ainda não completou aniversario esse ano.

        return numeroDeAnos;
    }

    public BigDecimal getRendaPerCapita() {
        return renda.divide(new BigDecimal(dependentes+1), RoundingMode.HALF_UP);
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

}