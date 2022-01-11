package com.github.agem20.creditanalysissystemtqi.repository;

import java.util.Optional;

import com.github.agem20.creditanalysissystemtqi.entity.Cliente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

    @Query("select distinct(c) from Cliente c where c.cpf = :cpf")
    Optional<Cliente> findByCpf(@Param("cpf") String cpf);

}