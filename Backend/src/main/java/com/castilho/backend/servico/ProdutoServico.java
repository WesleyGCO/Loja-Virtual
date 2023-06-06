package com.castilho.backend.servico;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.entidade.Produto;
import com.castilho.backend.repositorio.ProdutoRepositorio;

@Service
public class ProdutoServico {
    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public List<Produto> listarTodos(){
        return produtoRepositorio.findAll();
    }

    public Produto inserir(Produto produto){
        produto.setDataCriacao(new Date());
        Produto produtoNovo = produtoRepositorio.saveAndFlush(produto);
        return produtoNovo;
    }

    public Produto atualizar(Produto produto){
        produto.setDataAtualizacao(new Date());
        Produto produtoAtualizado = produtoRepositorio.saveAndFlush(produto);
        return produtoAtualizado;
    }

    public void excluir(Long id){
        Produto produto = produtoRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Produo não encontrado."));
        produtoRepositorio.delete(produto);
    }
}
