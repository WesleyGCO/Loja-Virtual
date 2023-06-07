package com.castilho.backend.controle;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castilho.backend.entidade.Produto;
import com.castilho.backend.servico.ProdutoServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produto")
@CrossOrigin
public class ProdutoControle {
    @Autowired
    private ProdutoServico produtoServico;

    // localhost:8080/produto/ - com verbo get
    @GetMapping("/")
    public List<Produto> listarTodos() {
        return produtoServico.listarTodos();
    }

    // localhost:8080/produto/ - com verbo post
    @PostMapping("/")
    public Produto inserir(@Valid @RequestBody Produto produto) {
        return produtoServico.inserir(produto);
    }

    @PutMapping("/")
    public Produto atualizar(@Valid @RequestBody Produto produto) {
        return produtoServico.atualizar(produto);
    }

    // localhost:8080/produto/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirProduto(@Valid @PathVariable Long id) {
        try {
            produtoServico.excluir(id);
            return ResponseEntity.ok("Produto excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
