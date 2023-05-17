package com.castilho.backend.controle;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

    
    public List<Estado> listarTodos(){
        return estadoServico.listarTodos();
    }

    public Estado salvar(@RequestBody Estado estado){
        return estadoServico.salvar(estado);
    }

    public void excluir(Long id){
        estadoServico.excluir(id);
    }
}
