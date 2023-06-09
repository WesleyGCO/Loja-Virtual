package com.castilho.backend.controle;

import java.util.List;

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

import com.castilho.backend.entidade.Permissao;
import com.castilho.backend.servico.PermissaoServico;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/permissao")
@CrossOrigin
public class PermissaoControle {
    @Autowired
    private PermissaoServico permissaoServico;

    // localhost:8080/permissao/ - com verbo get
    @GetMapping
    public List<Permissao> listarTodos(){
        return permissaoServico.listarTodos();
    }

    // localhost:8080/permissao/ - com verbo post
    @PostMapping
    public Permissao inserir(@Valid @RequestBody Permissao permissao){
        return permissaoServico.inserir(permissao);
    }

    @PutMapping("/")
    public Permissao atualizar(@Valid @RequestBody Permissao permissao){
        return permissaoServico.atualizar(permissao);
    }

    // localhost:8080/permissao/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPermissao(@Valid @PathVariable Long id){
        try {
            permissaoServico.excluir(id);
            return ResponseEntity.ok("Permissão excluída com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
