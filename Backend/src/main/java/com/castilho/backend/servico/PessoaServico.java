package com.castilho.backend.servico;

import java.util.Date;
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

    public Pessoa inserir(Pessoa pessoa){
        pessoa.setDataCriacao(new Date());
        Pessoa pessoaNova = pessoaRepositorio.saveAndFlush(pessoa);
        return pessoaNova;
    }

    public Pessoa atualizar(Pessoa pessoa){
        pessoa.setDataAtualizacao((new Date()));
        Pessoa pessoaAtualizada = pessoaRepositorio.saveAndFlush(pessoa);
        return pessoaAtualizada;
    }

    public void excluir(Long id){
        Pessoa pessoa = pessoaRepositorio.findById(id)
        .orElseThrow(() -> new NoSuchElementException("Pessoa não encontrada."));
        pessoaRepositorio.delete(pessoa);
    }
}
