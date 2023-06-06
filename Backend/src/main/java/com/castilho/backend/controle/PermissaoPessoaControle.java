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

import com.castilho.backend.entidade.PermissaoPessoa;
import com.castilho.backend.servico.PermissaoPessoaServico;

@RestController
@RequestMapping("/permissaoPessoa")
@CrossOrigin
public class PermissaoPessoaControle {
    @Autowired
    private PermissaoPessoaServico permissaoPessoaServico;

    // localhost:8080/permissaoPessoa/ - com verbo get
    @GetMapping("/")
    public List<PermissaoPessoa> listarTodos() {
        return permissaoPessoaServico.listarTodos();
    }

    // localhost:8080/permissaoPessoa/ - com verbo post
    @PostMapping("/")
    public PermissaoPessoa inserir(@RequestBody PermissaoPessoa permissaoPessoa) {
        return permissaoPessoaServico.inserir(permissaoPessoa);
    }

    @PutMapping("/")
    public PermissaoPessoa atualizar(@RequestBody PermissaoPessoa permissaoPessoa) {
        return permissaoPessoaServico.atualizar(permissaoPessoa);
    }

    // localhost:8080/permissaoPessoa/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPermissaoPessoa(@PathVariable Long id) {
        try {
            permissaoPessoaServico.excluir(id);
            return ResponseEntity.ok("Permissao de pessoa excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
