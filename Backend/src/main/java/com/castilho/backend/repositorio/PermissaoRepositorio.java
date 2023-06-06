package com.castilho.backend.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.castilho.backend.entidade.Permissao;

@Repository
public interface PermissaoRepositorio extends JpaRepository<Permissao, Long> {
    
    List<Permissao> findByNome(String nome);
}
