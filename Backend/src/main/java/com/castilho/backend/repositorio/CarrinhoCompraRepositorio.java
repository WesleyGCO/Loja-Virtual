package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castilho.backend.entidade.CarrinhoCompra;

public interface CarrinhoCompraRepositorio extends JpaRepository<CarrinhoCompra, Long>{
    
}
