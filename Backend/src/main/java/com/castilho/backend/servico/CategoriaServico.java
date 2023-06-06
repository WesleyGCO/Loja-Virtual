package com.castilho.backend.servico;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.entidade.Categoria;
import com.castilho.backend.repositorio.CategoriaRepositorio;

@Service
public class CategoriaServico {
    
    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> listarTodos(){
        return categoriaRepositorio.findAll();
    }

    public Categoria inserir(Categoria categoria){
        categoria.setDataCriacao(new Date());
        Categoria categoriaNova = categoriaRepositorio.saveAndFlush(categoria);
        return categoriaNova;
    }

    public Categoria atualizar(Categoria categoria){
        categoria.setDataAtualizacao(new Date());
        Categoria categoriaAtualizada = categoriaRepositorio.saveAndFlush(categoria);
        return categoriaAtualizada;
    }

    public void excluir(Long id){
        Categoria categoria = categoriaRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Categoria não encontrada."));

        categoriaRepositorio.delete(categoria);
    }
}
