package com.github.agem20.creditanalysissystemtqi.calculo;

import com.github.agem20.creditanalysissystemtqi.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class TabelaPesoEstado {
    List<PesoEstado> pesos;

    public TabelaPesoEstado() {
        pesos = new ArrayList<PesoEstado>();
        pesos.add(new PesoEstado("MA", 25L));
        pesos.add(new PesoEstado("SC", 20L));
        pesos.add(new PesoEstado("SP", 15L));
        pesos.add(new PesoEstado("RJ", 15L));
    }

    public Long getPeso(Cliente cliente) {
        for (PesoEstado pesoEstado : pesos) {
            if(cliente.getEstado().equals(pesoEstado.getEstado())) {
                return pesoEstado.getPeso();
            }
        }

        return 0L;
    }
}