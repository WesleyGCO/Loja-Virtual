package com.castilho.backend.servico;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.repositorio.CidadeRepositorio;

import com.castilho.backend.entidade.Cidade;

@Service
public class CidadeServico {
    
    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    public List<Cidade> listarTodos(){
        return cidadeRepositorio.findAll();
    }

    public Cidade salvar(Cidade cidade){
        return cidadeRepositorio.save(cidade);
    }

    public void excluir(Long id){
        Cidade cidade = cidadeRepositorio.findById(id).get();
        cidadeRepositorio.delete(cidade);
    }
}
