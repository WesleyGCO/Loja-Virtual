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

import com.castilho.backend.entidade.Estado;
import com.castilho.backend.servico.EstadoServico;
import com.opencsv.exceptions.CsvValidationException;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/estado")
@CrossOrigin
public class EstadoControle {
    
    @Autowired
    private EstadoServico estadoServico;

    // localhost:8080/estado/ - com verbo get
    @GetMapping("/")
    public List<Estado> listarTodos(){
        return estadoServico.listarTodos();
    }

    // localhost:8080/estado/ - com verbo post
    @PostMapping("/")
    public Estado inserir(@Valid @RequestBody Estado estado){
        return estadoServico.inserir(estado);
    }

    @PostMapping("/importarCsv")
    public String importarCsv(@Valid @RequestParam("caminhoArquivoCsv") String caminhoArquivoCsv) throws CsvValidationException{
        estadoServico.importarDadosCsv(caminhoArquivoCsv);
        return "Dados importados com sucesso!";
    }

    @PutMapping("/")
    public Estado atualizar(@Valid @RequestBody Estado estado){
        return estadoServico.atualizar(estado);
    }

    // localhost:8080/estado/1 - com verbo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> excluirEstado(@Valid @PathVariable Long id) {
        try {
            estadoServico.excluir(id);
            return ResponseEntity.ok("Estado excluído com sucesso");
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
