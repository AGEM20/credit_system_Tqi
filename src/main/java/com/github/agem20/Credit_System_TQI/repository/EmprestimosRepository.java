package com.github.agem20.Credit_System_TQI.repository;

import com.github.agem20.Credit_System_TQI.model.Cliente;
import com.github.agem20.Credit_System_TQI.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmprestimosRepository extends JpaRepository<Emprestimo, Integer> {
    List<Emprestimo> findByCliente(Cliente cliente);
}