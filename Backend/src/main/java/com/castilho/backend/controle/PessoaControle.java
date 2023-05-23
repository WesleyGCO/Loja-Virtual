package com.castilho.backend.controle;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castilho.backend.entidade.Pessoa;
import com.castilho.backend.servico.PessoaServico;

@RestController
@RequestMapping("/pessoa")
@CrossOrigin
public class PessoaControle {
    
    @Autowired
    private PessoaServico pessoaServico;

    // localhost:8080/pessoa/ - com verbo get
    @GetMapping
    public List<Pessoa> listarTodos(){
        return pessoaServico.listarTodos();
    }

    // localhost:8080/pessoa/ - com verbo post
    @PostMapping
    public Pessoa salvar(@RequestBody Pessoa pessoa){
        return pessoaServico.salvar(pessoa);
    }

    // localhost:8080/pessoa/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirPessoa(@PathVariable Long id) {
        try {
            pessoaServico.excluir(id);
            return ResponseEntity.ok("Pessoa excluída com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
