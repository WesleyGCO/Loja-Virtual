package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castilho.backend.entidade.Estado;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Long>{
}