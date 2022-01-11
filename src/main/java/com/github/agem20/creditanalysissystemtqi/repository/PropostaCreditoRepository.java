package com.github.agem20.creditanalysissystemtqi.repository;

import java.util.stream.Stream;

import com.github.agem20.creditanalysissystemtqi.entity.PropostaCredito;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface PropostaCreditoRepository extends CrudRepository<PropostaCredito, Long>{


    @Query("select distinct(p) from PropostaCredito p JOIN p.cliente c where c.cpf = :cpf order by p.id desc")
    Stream<PropostaCredito> findLastByCPF(@Param("cpf") String cpf);

}