package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castilho.backend.entidade.ProdutoImagens;

@Repository
public interface ProdutoImagensRepositorio extends JpaRepository<ProdutoImagens, Long>{
    
}
