package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castilho.backend.entidade.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long>{
    
}
