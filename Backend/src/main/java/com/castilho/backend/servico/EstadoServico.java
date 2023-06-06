package com.castilho.backend.servico;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.castilho.backend.entidade.Estado;
import com.castilho.backend.repositorio.EstadoRepositorio;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import jakarta.transaction.Transactional;

@Service
public class EstadoServico {
    @Autowired
    private EstadoRepositorio estadoRepositorio;

    public List<Estado> listarTodos(){
        return estadoRepositorio.findAll();
    }

    public Estado inserir(Estado estado){
        estado.setDataCriacao(new Date());
        Estado estadoNovo = estadoRepositorio.saveAndFlush(estado);
        return estadoNovo;
    }

    public Estado atualizar(Estado estado){
        estado.setDataAtualizacao(new Date());
        Estado estadoAtualizado = estadoRepositorio.saveAndFlush(estado);
        return estadoAtualizado;
    }

    public void excluir(Long id){
        Estado estado = estadoRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Estado não encontrado."));
        estadoRepositorio.delete(estado);
    }

    @Transactional
    public void importarDadosCsv(String caminhoArquivoCsv) throws CsvValidationException{
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivoCsv))){
            String[] linha;
            reader.readNext();

            while((linha = reader.readNext()) != null){
                Estado estado = new Estado();
                estado.setNome(linha[1]);
                estado.setSigla(linha[2]);
                estado.setStatus(linha[3]);
                estado.setDataCriacao(new Date());
                estadoRepositorio.save(estado);
            }
        } catch (IOException e) {
            // Tratar exceções
        }
    }

}
