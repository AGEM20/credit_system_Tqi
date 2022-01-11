package com.github.agem20.creditanalysissystemtqi.calculo;

import com.github.agem20.creditanalysissystemtqi.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class TabelaPesoCliente {

    List<PesoCliente> pesos;

    public TabelaPesoCliente() {
        pesos = new ArrayList<PesoCliente>();

        pesos.add(new PesoCliente(16, 30, "M", "Solteiro", 10L));
        pesos.add(new PesoCliente(16, 30, "F", "Solteiro", 15L));
        pesos.add(new PesoCliente(30, 45, "M", "Solteiro", 25L));
        pesos.add(new PesoCliente(30, 45, "F", "Solteiro", 25L));
        pesos.add(new PesoCliente(45, 130, "M", "Solteiro", 15L));
        pesos.add(new PesoCliente(45, 130, "F", "Solteiro", 15L));

        pesos.add(new PesoCliente(16, 30, "M", "Viuvo", 10L));
        pesos.add(new PesoCliente(16, 30, "F", "Viuvo", 15L));
        pesos.add(new PesoCliente(30, 45, "M", "Viuvo", 25L));
        pesos.add(new PesoCliente(30, 45, "F", "Viuvo", 25L));
        pesos.add(new PesoCliente(45, 130, "M", "Viuvo", 15L));
        pesos.add(new PesoCliente(45, 130, "F", "Viuvo", 15L));

        pesos.add(new PesoCliente(16, 30, "M", "Divorciado", 10L));
        pesos.add(new PesoCliente(16, 30, "F", "Divorciado", 15L));
        pesos.add(new PesoCliente(30, 45, "M", "Divorciado", 25L));
        pesos.add(new PesoCliente(30, 45, "F", "Divorciado", 25L));
        pesos.add(new PesoCliente(45, 130, "M", "Divorciado", 15L));
        pesos.add(new PesoCliente(45, 130, "F", "Divorciado", 15L));



        pesos.add(new PesoCliente(16, 30, "M", "Casado", 20L));
        pesos.add(new PesoCliente(16, 30, "F", "Casado", 20L));
        pesos.add(new PesoCliente(30, 45, "M", "Casado", 30L));
        pesos.add(new PesoCliente(30, 45, "F", "Casado", 30L));
        pesos.add(new PesoCliente(45, 130, "M", "Casado", 20L));
        pesos.add(new PesoCliente(45, 130, "F", "Casado", 20L));
    }

    public Long getPeso(Cliente cliente) {
        for (PesoCliente pesoCliente : pesos) {
            if(cliente.getIdade() >= pesoCliente.getIdadeMinima()
                    && cliente.getIdade() < pesoCliente.getIdadeMaxima()
                    && cliente.getSexo().equals(pesoCliente.getSexo())
                    && cliente.getEstadoCivil().equals(pesoCliente.getEstadoCivil())) {

                return pesoCliente.getPeso();
            }
        }

        return 0L;
    }

}