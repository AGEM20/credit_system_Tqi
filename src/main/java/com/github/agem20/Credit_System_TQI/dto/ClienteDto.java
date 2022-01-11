package com.github.agem20.Credit_System_TQI.dto;

import com.github.agem20.Credit_System_TQI.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDto {

    private Integer id;
    private String nome;
    private String email;
    private String cpf;
    private String rg;
    private String endereco;
    private Float renda;

    public ClienteDto(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.email = cliente.getEmail();
        this.cpf = cliente.getCpf();
        this.rg = cliente.getRg();
        this.endereco = cliente.getEndereco();
        this.renda = cliente.getRenda();
    }

    public static List<ClienteDto> convert(List<Cliente> clientes){
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public static ClienteDto convert(Cliente clientes){
        return new ClienteDto(clientes);
    }

}