package com.github.agem20.creditanalysissystemtqi.operation;

import com.github.agem20.creditanalysissystemtqi.calculo.TabelaResultadoAnalise.TabelaResultadoAnalise;
import com.github.agem20.creditanalysissystemtqi.dto.PropostaCreditoDTO;
import com.github.agem20.creditanalysissystemtqi.entity.PropostaCredito;
import com.github.agem20.creditanalysissystemtqi.entity.ResultadoAnalise;
import com.github.agem20.creditanalysissystemtqi.repository.ClienteRepository;
import com.github.agem20.creditanalysissystemtqi.repository.PropostaCreditoRepository;
import org.apache.logging.log4j.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Component
@Transactional
public class PropostaCreditoOperacao {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private PropostaCreditoRepository propostaRepository;



    public PropostaCreditoDTO analisarProposta(PropostaCredito proposta) {

        TabelaResultadoAnalise tabelaResultadoAnalise = new TabelaResultadoAnalise();

        ResultadoAnalise resultado = tabelaResultadoAnalise.getResultadoAnalise(proposta.getCliente());

        proposta.setResultadoAnalise(resultado);

        clienteRepository.save(proposta.getCliente());
        propostaRepository.save(proposta);
        PropostaCreditoDTO propostaDTO = new PropostaCreditoDTO(proposta);

        propostaDTO.getCliente().setVersao(propostaDTO.getCliente().getVersao()+1);

        return propostaDTO;
    }

    public List<PropostaCreditoDTO> consultarPropostasSubmetidas(String cpf) {
        List<PropostaCreditoDTO> propostasDTO = new ArrayList<PropostaCreditoDTO>();
        Stream<PropostaCredito> propostas = propostaRepository.findLastByCPF(cpf);
        Supplier<Stream<PropostaCredito>> streamSupplier = () -> propostas;
        streamSupplier.get().forEach(x -> propostasDTO.add(new PropostaCreditoDTO(x)));
        return propostasDTO;
    }

    public ResultadoAnalise calcular(PropostaCredito proposta) {

        return null;
    }

}
