package com.castilho.backend.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.castilho.backend.entidade.CarrinhoCompraProduto;

public interface CarrinhoCompraProdutoRepositorio extends JpaRepository<CarrinhoCompraProduto, Long>{
    
}
