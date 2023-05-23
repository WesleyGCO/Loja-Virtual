package com.castilho.backend.servico;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.entidade.Pessoa;
import com.castilho.backend.repositorio.PessoaRepositorio;

@Service
public class PessoaServico {
    
    @Autowired
    private PessoaRepositorio pessoaRepositorio;

    public List<Pessoa> listarTodos(){
        return pessoaRepositorio.findAll();
    }

    public Pessoa salvar(Pessoa pessoa){
        return pessoaRepositorio.save(pessoa);
    }

    public void excluir(Long id){
        Pessoa pessoa = pessoaRepositorio.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Pessoa não encontrada."));
        pessoaRepositorio.delete(pessoa);
    }
}
