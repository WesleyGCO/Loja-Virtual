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

import com.castilho.backend.entidade.Categoria;
import com.castilho.backend.servico.CategoriaServico;

@RestController
@RequestMapping("/categoria")
@CrossOrigin
public class CategoriaControle {
    @Autowired
    private CategoriaServico categoriaServico;

    // localhost:8080/categoria/ - com verbo get
    @GetMapping("/")
    public List<Categoria> listarTodos() {
        return categoriaServico.listarTodos();
    }

    // localhost:8080/categoria/ - com verbo post
    @PostMapping("/")
    public Categoria inserir(@RequestBody Categoria categoria) {
        return categoriaServico.inserir(categoria);
    }

    @PutMapping("/")
    public Categoria atualizar(@RequestBody Categoria categoria) {
        return categoriaServico.atualizar(categoria);
    }

    // localhost:8080/categoria/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirCategoria(@PathVariable Long id) {
        try {
            categoriaServico.excluir(id);
            return ResponseEntity.ok("Categoria excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
