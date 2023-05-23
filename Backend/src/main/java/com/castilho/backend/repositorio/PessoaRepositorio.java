package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castilho.backend.entidade.Pessoa;

@Repository
public interface PessoaRepositorio extends JpaRepository<Pessoa, Long> {
}