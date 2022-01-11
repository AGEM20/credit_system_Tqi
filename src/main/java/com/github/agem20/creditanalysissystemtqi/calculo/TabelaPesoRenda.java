package com.github.agem20.creditanalysissystemtqi.calculo;

import com.github.agem20.creditanalysissystemtqi.entity.Cliente;

import java.util.ArrayList;
import java.util.List;

public class TabelaPesoRenda {
    List<PesoRenda> pesos;

    public TabelaPesoRenda() {
        pesos = new ArrayList<PesoRenda>();
        pesos.add(new PesoRenda(0, 500, 0L));
        pesos.add(new PesoRenda(500, 1000, 10L));
        pesos.add(new PesoRenda(1000, 1500, 15L));
        pesos.add(new PesoRenda(1500, 2500, 35L));
        pesos.add(new PesoRenda(2500, 999999999, 50L));
    }

    public Long getPeso(Cliente cliente) {
        for (PesoRenda pesoRenda : pesos) {
            if(cliente.getRendaPerCapita().compareTo(pesoRenda.getRendaMinima()) == 1
                    && (cliente.getRendaPerCapita().compareTo(pesoRenda.getRendaMaxima()) == -1
                    || cliente.getRendaPerCapita().compareTo(pesoRenda.getRendaMaxima()) == 0)) {
                return pesoRenda.getPeso();
            }
        }

        return 0L;
    }
}