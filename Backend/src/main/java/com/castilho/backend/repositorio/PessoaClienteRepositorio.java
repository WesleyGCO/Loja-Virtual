package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castilho.backend.entidade.Pessoa;

public interface PessoaClienteRepositorio extends JpaRepository<Pessoa, Long>{
    
}
