package com.castilho.backend.servico;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.entidade.Permissao;
import com.castilho.backend.repositorio.PermissaoRepositorio;

@Service
public class PermissaoServico {
    
    @Autowired
    private PermissaoRepositorio permissaoRepositorio;

    public List<Permissao> listarTodos(){
        return permissaoRepositorio.findAll();
    }

    public Permissao salvar(Permissao permissao){
        return permissaoRepositorio.save(permissao);
    }

    public void excluir(Long id){
        Permissao permissao = permissaoRepositorio.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Permissão não encontrada"));
        permissaoRepositorio.delete(permissao);
    }
}
