package com.castilho.backend.servico;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.castilho.backend.entidade.Produto;
import com.castilho.backend.entidade.ProdutoImagens;
import com.castilho.backend.repositorio.ProdutoImagensRepositorio;
import com.castilho.backend.repositorio.ProdutoRepositorio;

@Service
public class ProdutoImagensServico {
    
    @Autowired
    private ProdutoImagensRepositorio produtoImagensRepositorio;

    @Autowired
    private ProdutoRepositorio produtoRepositorio;

    public List<ProdutoImagens> listarTodos(){
        return produtoImagensRepositorio.findAll();
    }

    public ProdutoImagens inserir(Long id, MultipartFile file){
        Produto produto = produtoRepositorio.findById(id).get();
        ProdutoImagens produtoImagens = new ProdutoImagens();

        try {
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nomeImagem = String.valueOf(produto.getId()) + file.getOriginalFilename();
                Path caminho = Paths.get("c:/imagens/" + nomeImagem);
                Files.write(caminho, bytes);
                produtoImagens.setNome(nomeImagem);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        produtoImagens.setProduto(produto);
        produtoImagens.setDataCriacao(new Date());
        var objeto = produtoImagensRepositorio.saveAndFlush(produtoImagens);
        return objeto;
    }

    public ProdutoImagens atualizar(ProdutoImagens produtoImagens){
        produtoImagens.setDataAtualizacao(new Date());
        ProdutoImagens produtoImagensAtualizado = produtoImagensRepositorio.saveAndFlush(produtoImagens);
        return produtoImagensAtualizado;
    }

    public void excluir(Long id){
        ProdutoImagens produtoImagens = produtoImagensRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Imagem de produto não encontrada."));
        produtoImagensRepositorio.delete(produtoImagens);
    }
}
