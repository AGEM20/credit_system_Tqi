package com.github.agem20.creditanalysissystemtqi.calculo.TabelaResultadoAnalise;

import com.github.agem20.creditanalysissystemtqi.calculo.PesoPontuacao;
import com.github.agem20.creditanalysissystemtqi.calculo.TabelaPesoCliente;
import com.github.agem20.creditanalysissystemtqi.calculo.TabelaPesoEstado;
import com.github.agem20.creditanalysissystemtqi.calculo.TabelaPesoRenda;
import com.github.agem20.creditanalysissystemtqi.entity.Cliente;
import com.github.agem20.creditanalysissystemtqi.entity.ResultadoAnalise;
import com.github.agem20.creditanalysissystemtqi.enums.StatusResultadoAnalise;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TabelaResultadoAnalise {
    List<PesoPontuacao> pesos;

    public TabelaResultadoAnalise() {
        pesos = new ArrayList<PesoPontuacao>();
        pesos.add(criarPesoPontuacao(0, 0, 0, 0, "renda baixa", StatusResultadoAnalise.Negado.name()));
        pesos.add(criarPesoPontuacao(1, 3000, 100, 500, "entre 100 - 500", StatusResultadoAnalise.Aprovado.name()));
        pesos.add(criarPesoPontuacao(3001, 4000, 501, 1000, "entre 500 - 1000", StatusResultadoAnalise.Aprovado.name()));
        pesos.add(criarPesoPontuacao(4001, 12000, 1001, 1500, "entre 1000 - 1500", StatusResultadoAnalise.Aprovado.name()));
        pesos.add(criarPesoPontuacao(12001, 14000, 1501, 2000, "entre 1500 - 2000", StatusResultadoAnalise.Aprovado.name()));
        pesos.add(criarPesoPontuacao(14001, 999999999, 2001, 999999999, "superior 2000", StatusResultadoAnalise.Aprovado.name()));
    }

    private PesoPontuacao criarPesoPontuacao(
            int pontuacaoMinima,
            int pontuacaoMaxima,
            int limiteMinimo,
            int limiteMaximo,
            String limite,
            String status) {

        return new PesoPontuacao(
                pontuacaoMinima,
                pontuacaoMaxima,
                new ResultadoAnalise(
                        new BigDecimal(limiteMinimo),
                        new BigDecimal(limiteMaximo),
                        limite,
                        status
                )
        );
    }

    public ResultadoAnalise getResultadoAnalise(Cliente cliente) {

        Long pesoCliente = new TabelaPesoCliente().getPeso(cliente);
        Long pesoEstado = new TabelaPesoEstado().getPeso(cliente);
        Long pesoRenda = new TabelaPesoRenda().getPeso(cliente);

        Long pontuacao = pesoCliente * pesoEstado * pesoRenda;

        for (PesoPontuacao pesoPontuacao : pesos) {
            if(pontuacao <= pesoPontuacao.getPesoMaximo() && pontuacao >=pesoPontuacao.getPesoMinimo()) {
                return pesoPontuacao.getResultadoAnalise();
            }
        }

        return null;
    }
}
