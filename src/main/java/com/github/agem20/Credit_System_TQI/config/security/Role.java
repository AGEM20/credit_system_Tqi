package com.github.agem20.Credit_System_TQI.config.security;

public enum Role {

    USER("USER");

    private String nome;

    private Role(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }
}