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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.castilho.backend.entidade.ProdutoImagens;
import com.castilho.backend.servico.ProdutoImagensServico;

@RestController
@RequestMapping("/produtoImagens")
@CrossOrigin
public class ProdutoImagensControle {
    @Autowired
    private ProdutoImagensServico produtoImagensServico;

    // localhost:8080/produtoImagens/ - com verbo get
    @GetMapping("/")
    public List<ProdutoImagens> listarTodos() {
        return produtoImagensServico.listarTodos();
    }

    // localhost:8080/produtoImagens/ - com verbo post
    @PostMapping("/")
    public ProdutoImagens inserir(@RequestParam Long id, @RequestParam MultipartFile file) {
        return produtoImagensServico.inserir(id, file);
    }

    @PutMapping("/")
    public ProdutoImagens atualizar(@RequestBody ProdutoImagens produtoImagens) {
        return produtoImagensServico.atualizar(produtoImagens);
    }

    // localhost:8080/produtoImagens/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirProdutoImagens(@PathVariable Long id) {
        try {
            produtoImagensServico.excluir(id);
            return ResponseEntity.ok("Imagem de produto excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
