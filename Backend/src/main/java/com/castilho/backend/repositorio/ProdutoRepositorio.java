package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castilho.backend.entidade.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long>{
    
}
