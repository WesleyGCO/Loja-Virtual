package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castilho.backend.entidade.Cidade;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade, Long>{
    
}
