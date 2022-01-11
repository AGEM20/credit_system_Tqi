package com.github.agem20.creditanalysissystemtqi.dto;

import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;

import java.util.ArrayList;
import java.util.List;

public class Erros {

    private String status;
    private List<String> erros;

    public Erros(HttpStatus status, String message) {
        this.status = String.valueOf(status.value());
        erros = new ArrayList<String>();
        erros.add(message);
    }

    public Erros(HttpStatus status, List<ObjectError> objetosError) {
        this.erros = new ArrayList<String>();
        objetosError.forEach(erro -> {
            this.erros.add(erro.getDefaultMessage());
        });
        this.status = String.valueOf(status.value());
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getErros() {
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

}
