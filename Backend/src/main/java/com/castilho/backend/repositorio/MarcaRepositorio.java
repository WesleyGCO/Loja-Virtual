package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castilho.backend.entidade.Marca;

public interface MarcaRepositorio extends JpaRepository<Marca, Long>{
    
}
