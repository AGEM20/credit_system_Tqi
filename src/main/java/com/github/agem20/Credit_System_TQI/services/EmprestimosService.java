package com.github.agem20.Credit_System_TQI.services;
import com.github.agem20.Credit_System_TQI.model.Cliente;
import com.github.agem20.Credit_System_TQI.model.Emprestimo;
import com.github.agem20.Credit_System_TQI.repository.EmprestimosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmprestimosService {

    @Autowired
    private EmprestimosRepository emprestimosRepository;

    public EmprestimosService(){

    }

    public List<Emprestimo> findByCliente(Cliente cliente){
        return emprestimosRepository.findByCliente(cliente);
    }

    public Optional<Emprestimo> findById(Integer id){
        return emprestimosRepository.findById(id);
    }

    public Emprestimo save(Emprestimo emprestimo){
        return emprestimosRepository.save(emprestimo);
    }

}