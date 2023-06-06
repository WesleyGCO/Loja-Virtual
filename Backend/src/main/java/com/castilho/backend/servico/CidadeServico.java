package com.castilho.backend.servico;

import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.castilho.backend.repositorio.CidadeRepositorio;
import com.castilho.backend.repositorio.EstadoRepositorio;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import jakarta.transaction.Transactional;

import com.castilho.backend.entidade.Cidade;
import com.castilho.backend.entidade.Estado;

@Service
public class CidadeServico {
    
    @Autowired
    private CidadeRepositorio cidadeRepositorio;
    @Autowired
    private EstadoRepositorio estadoRepositorio;

    public List<Cidade> listarTodos(){
        return cidadeRepositorio.findAll();
    }

    public Cidade inserir(Cidade cidade){
        cidade.setDataCriacao(new Date());
        Cidade cidadeNova = cidadeRepositorio.saveAndFlush(cidade);
        return cidadeNova;
    }

    public Cidade atualizar(Cidade cidade){
        cidade.setDataAtualizacao(new Date());
        Cidade cidadeAtualizada = cidadeRepositorio.saveAndFlush(cidade);
        return cidadeAtualizada;

    }

    public void excluir(Long id){
        Cidade cidade = cidadeRepositorio.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Cidade não encontrado."));
        cidadeRepositorio.delete(cidade);
    }

    @Transactional
    public void importarDadosCsv(String caminhoArquivoCsv) throws CsvValidationException, NumberFormatException{
        try (CSVReader reader = new CSVReader(new FileReader(caminhoArquivoCsv))){
            String[] linha;

            reader.readNext();
            while((linha = reader.readNext()) != null){
                Cidade cidade = new Cidade();
                Estado estado = estadoRepositorio.findById(Long.parseLong(linha[3])).get();
                cidade.setNome(linha[1]);
                cidade.setStatus(linha[2]);
                cidade.setEstado(estado);
                cidade.setMarcada(linha[4]);
                cidade.setDataCriacao(new Date());
                cidadeRepositorio.save(cidade);
            }
        } catch(IOException e){
            // Tratar as exceções
        }
    }
}
