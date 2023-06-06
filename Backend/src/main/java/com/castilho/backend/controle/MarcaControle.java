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

import com.castilho.backend.entidade.Marca;
import com.castilho.backend.servico.MarcaServico;

@RestController
@RequestMapping("/marca")
@CrossOrigin
public class MarcaControle {
    @Autowired
    private MarcaServico marcaServico;

    // localhost:8080/marca/ - com verbo get
    @GetMapping("/")
    public List<Marca> listarTodos() {
        return marcaServico.listarTodos();
    }

    // localhost:8080/marca/ - com verbo post
    @PostMapping("/")
    public Marca inserir(@RequestBody Marca marca) {
        return marcaServico.inserir(marca);
    }

    @PutMapping("/")
    public Marca atualizar(@RequestBody Marca marca) {
        return marcaServico.atualizar(marca);
    }

    // localhost:8080/marca/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirMarca(@PathVariable Long id) {
        try {
            marcaServico.excluir(id);
            return ResponseEntity.ok("Marca excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
