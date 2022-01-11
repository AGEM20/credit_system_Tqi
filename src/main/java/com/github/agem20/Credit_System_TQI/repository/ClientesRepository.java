package com.github.agem20.Credit_System_TQI.repository;


import com.github.agem20.Credit_System_TQI.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ClientesRepository extends JpaRepository<Cliente, Integer> {

    Optional<Cliente> findByEmail(String email);
    Boolean existsByEmail(String email);
}