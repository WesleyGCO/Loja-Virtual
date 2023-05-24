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

import com.castilho.backend.servico.CidadeServico;
import com.castilho.backend.entidade.Cidade;

@RestController
@RequestMapping("/cidade")
@CrossOrigin
public class CidadeControle {
    
    @Autowired
    private CidadeServico cidadeServico;

    // localhost:8080/cidade/ - com o verbo get
    @GetMapping
    public List<Cidade> listarTodos(){
        return cidadeServico.listarTodos();
    }

    // localhost:8080/cidade/ - com verbo post
    @PostMapping
    public Cidade salvar(@RequestBody Cidade cidade){
        return cidadeServico.salvar(cidade);
    }

    // localhost:8080/cidade/1 - com verbo delete
    @DeleteMapping("/{id}")
    public void excluir(Long id){
        cidadeServico.excluir(id);
    }

}
