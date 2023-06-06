package com.castilho.backend.servico;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.entidade.Marca;
import com.castilho.backend.repositorio.MarcaRepositorio;

@Service
public class MarcaServico {
    
    @Autowired
    private MarcaRepositorio marcaRepositorio;

    public List<Marca> listarTodos(){
        return marcaRepositorio.findAll();
    }

    public Marca inserir(Marca marca){
        marca.setDataCriacao(new Date());
        Marca marcaNova = marcaRepositorio.saveAndFlush(marca);
        return marcaNova;
    }

    public Marca atualizar(Marca marca){
        marca.setDataAtualizacao(new Date());
        Marca marcaAtualizada = marcaRepositorio.saveAndFlush(marca);
        return marcaAtualizada;
    }

    public void excluir(Long id){
        Marca marca = marcaRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Marca não encontrada."));
        marcaRepositorio.delete(marca);
    }
}
