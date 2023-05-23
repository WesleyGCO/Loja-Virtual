package com.castilho.backend.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.castilho.backend.entidade.Estado;
import com.castilho.backend.servico.EstadoServico;

@RestController
@RequestMapping("/estado")
@CrossOrigin
public class EstadoControle {
    
    @Autowired
    private EstadoServico estadoServico;

    // localhost:8080/estado/ - com verbo get
    @GetMapping 
    public List<Estado> listarTodos(){
        return estadoServico.listarTodos();
    }

    // localhost:8080/estado/ - com verbo post
    @PostMapping
    public Estado salvar(@RequestBody Estado estado){
        return estadoServico.salvar(estado);
    }

    // localhost:8080/estado/1 - com verbo delete
    @DeleteMapping("/{id}")
    public void excluir(Long id){
        estadoServico.excluir(id);
    }
}
