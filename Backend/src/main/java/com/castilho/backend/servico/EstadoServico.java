package com.castilho.backend.servico;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castilho.backend.entidade.Estado;
import com.castilho.backend.repositorio.EstadoRepositorio;

@Service
public class EstadoServico {
    @Autowired
    private EstadoRepositorio estadoRepositorio;

    public List<Estado> listarTodos(){
        return estadoRepositorio.findAll();
    }

    public Estado salvar(Estado estado){
        return estadoRepositorio.save(estado);
    }

    public void excluir(Long id){
        Estado estado = estadoRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estado não encontrado."));
        estadoRepositorio.delete(estado);
    }

}
